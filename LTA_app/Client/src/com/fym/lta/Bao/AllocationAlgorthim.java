package com.fym.lta.bao;

import com.fym.lta.dto.DepartmentDto;
import com.fym.lta.dto.LocationDto;
import com.fym.lta.dto.SchedualDto;
import com.fym.lta.dto.SlotDto;

import java.util.ArrayList;
import java.util.List;

public class AllocationAlgorthim {

    //var to hold the value of saving table after allocation ;
    boolean saveStatus = false, saveStatus2 = false;
    String report = " Error in \r\n"; // this to hold the value which we need to told to the user
    SchedualBao schedualBaoObj = new BaoFactory().createSchedualBao();
    LocationBao locationBaoObj = new BaoFactory().createLocationBao();

    // list of all departments stored on DB
    List<DepartmentDto> allDeparts = new BaoFactory().createDepartmentBao().listDepartment();


    public float calc_UtilizationFactor() {
        return 0;
    }

    public String alloc_All() { // loops on all departments
        for (int i = 0; i < allDeparts.size(); i++) {
            List<SchedualDto> schedualIn_Depart = schedualBaoObj.listSchedual_inDeparts(allDeparts.get(i).getCode());
            // loops on the department's schedual
            for (int k = 0; k < schedualIn_Depart.size(); k++) { // calling allocate_Table method to allocate  table no k
                saveStatus2 = allocate_Table(schedualIn_Depart.get(k), allDeparts.get(i).getCode()) ;

                if (!saveStatus2)
                    report += " table no " + k + " dep name " + allDeparts.get(i).getCode();

            }
        }

        return report;
    }


    // method to  connect location  and alloce for a certian time
    public boolean allocate_Table(SchedualDto currentSchedual, String depCode) {

        // get the number of student
        int studentNum = currentSchedual.getStudent_number();

        // first we need a list of avaialable rooms
        List<LocationDto> availableRooms = locationBaoObj.getAvailableLocations(depCode);
        System.out.println(depCode);
        // get the list of slots form this table
        List<SlotDto> currentSlots = currentSchedual.getSchedual_Slots();

        // loop on the slots

        for (int i = 0; i < currentSlots.size(); i++) { // this to hold the value of needed space type
            String prefSpace = currentSlots.get(i).getPrefSpace();
            String sCode =   currentSlots.get(i).getCode();
           
           for (int k = 0; k < availableRooms.size();
                 k++) { // check if the prefSpace is proper and the capacity is proper
                if (prefSpace.equals(availableRooms.get(k).getType().getDescription()) &&
                    (availableRooms.get(k).getCapacity() >= studentNum))
                       
                {

               if(!testLocStatus(availableRooms.get(k),sCode))    
                
                // allocate this space
                { // allocate this locatoion
                        LocationDto currentLoc = availableRooms.get(k);
                        SlotDto slot = new SlotDto();
                        slot.setCode(sCode);
                        List<SlotDto> slots = null;
                       
                      
                        if(availableRooms.get(k).getAssignedSlots()!=null)
                         slots = availableRooms.get(k).getAssignedSlots();
                        else slots = new ArrayList() ; 
                       
                      
                        slots.add(slot);
                        currentLoc.setAssignedSlots(slots);
                        // update this location's status to busy
                       saveStatus = locationBaoObj.updateLocationSlot(currentLoc);

                         // remove this reserved location from list
                        availableRooms.remove(k);

                    }

                 }

            }

           
        }


        return saveStatus;
    }

    public boolean testLocStatus (LocationDto loc ,String sCode) {

     boolean status =false ;
     if(loc.getAssignedSlots()==null)
         return false ; 
    else {
            for (int i = 0; i < loc.getAssignedSlots().size(); i++) {
                if (sCode.equals(loc.getAssignedSlots().get(i)))
                    status = true;
            }
        }

     return status ; 

    } 
}
