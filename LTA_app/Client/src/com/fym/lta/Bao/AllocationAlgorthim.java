package com.fym.lta.bao;

import com.fym.lta.dto.LocationDto;
import com.fym.lta.dto.SchedualDto;
import com.fym.lta.dto.SlotDto;

import java.util.List;

public class AllocationAlgorthim {
    
     SchedualBao schedualBaoObj = new BaoFactory().createSchedualBao();
     LocationBao locationBaoObj = new BaoFactory().createLocationBao();

    

    public float calc_UtilizationFactor() {
        return 0;
    }
    
    
    // method to  connect location  and alloce for a certian time
    public SchedualDto allocate(SchedualDto  currentSchedual ,String depName) {
         
        // first we need a list of avaialable rooms 
        List<LocationDto> availableRooms  = locationBaoObj.getAvailableLocations(depName); 
        
        // get the list of slots form this table 
        List<SlotDto> currentSlots = currentSchedual.getSchedual_Slots(); 
        
        // loop on the slots 
        
        for(int i= 0; i<currentSlots.size() ; i++)
        {   // this to hold the value of needed space type  
            String prefSpace  = currentSlots.get(i).getPrefSpace();
            
            for (int k=0 ; k < availableRooms.size() ; k++)
            {   // check if the prefSpace is proper 
                if (prefSpace.equals(availableRooms.get(k).getType().getDescription()))
                // allocate this space 
                {   // allocate this locatoion 
                    LocationDto currentLoc = availableRooms.get(k) ; 
                    currentSlots.get(i).setCurrentLocation(currentLoc);
                    
                    // update this location's status to busy  
                    currentLoc.setStatus("busy");
                    locationBaoObj.updateLocation(currentLoc); 
                    
                    // remove this reserved location from list 
                    availableRooms.remove(k);
                    
                }
                
                
                }
            
            // update the table content  
            currentSchedual.setSchedual_Slots(currentSlots);
            //  save the table 
            schedualBaoObj.saveSchedual(currentSchedual) ;
        }
        
        
    return currentSchedual; }


    
}
