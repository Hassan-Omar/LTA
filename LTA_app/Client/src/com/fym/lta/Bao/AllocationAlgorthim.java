package com.fym.lta.bao;

import com.fym.lta.dto.DepartmentDto;
import com.fym.lta.dto.LocationDto;
import com.fym.lta.dto.SchedualDto;
import com.fym.lta.dto.SlotDto;
import com.fym.lta.ui.AutoAssignment;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AllocationAlgorthim {

    //var to hold the value of saving table after allocation ;
    boolean saveStatus = false, saveStatus2 = false;
    String report = " Error in \r\n"; // this to hold the value which we need to told to the user
    SchedualBao schedualBaoObj = new BaoFactory().createSchedualBao();
    LocationBao locationBaoObj = new BaoFactory().createLocationBao();

    // list of all departments stored on DB
    List<DepartmentDto> allDeparts = new BaoFactory().createDepartmentBao().listDepartment();



    public String alloc_All() { // loops on all departments
    int depNum = allDeparts.size();
    
        for (int i = 0; i < depNum; i++) {
            List<SchedualDto> schedualIn_Depart = schedualBaoObj.listSchedual_inDeparts(allDeparts.get(i).getCode());
            // loops on the department's schedual
            for (int k = 0; k < schedualIn_Depart.size(); k++) { // calling allocate_Table method to allocate  table no k
                saveStatus2 = allocate_Table(schedualIn_Depart.get(k), allDeparts.get(i).getCode());

                if (!saveStatus2)
                    report += " table no " + k + " dep name " + allDeparts.get(i).getCode();

            }
             // i think  depNum  well never >= 100  so i don't need if statment 
             int ratio = 100 / depNum ; 
             AutoAssignment.slotNO += ratio;
        }

        return report;
    }


    // method to  connect location  and alloc for a certian one table 
    public boolean allocate_Table(SchedualDto currentSchedual, String depCode) {

        // get the number of student
        int studentNum = currentSchedual.getStudent_number();

        // first we need a list of avaialable rooms
        List<LocationDto> rooms_inDep = locationBaoObj.getAvailableLocations(depCode);

        // get the list of slots form this table
        List<SlotDto> currentSlots = currentSchedual.getSchedual_Slots();

         List<SlotDto> assigSlots= new ArrayList<>();
        // loop on the slots      
        for (int i = 0; i < currentSlots.size(); i++) 
        {
          // System.out.println("i"+i + "size"+currentSlots.get(i).getSlot_id());
           List<LocationDto> filterdRooms = filterLocation(rooms_inDep ,currentSlots.get(i).getCode());
           LocationDto chosenRoom = decitionMake(filterdRooms , studentNum , currentSlots.get(i).getPrefSpace() ) ; 
           if(chosenRoom==null)
           {JOptionPane.showMessageDialog(null, "i can't find a proper location ");}
            else
           {
           // update this location 
           chosenRoom.setAssignedSlot(currentSlots.get(i));
            System.out.println(chosenRoom.getLocation_id());
           locationBaoObj.saveLocationSlot(chosenRoom); 
           }
            // update availableRooms list  
            /* rooms_inDep.remove(chosenRoom);
            assigSlots.add(currentSlots.get(i));
            chosenRoom.setAssignedSlots(assigSlots);
            rooms_inDep.add(chosenRoom); */
            
            rooms_inDep = locationBaoObj.getAvailableLocations(depCode);            
            
        }

        return saveStatus;
    }

  // method to filter the rooms based on slotCode 
 // actually it will return all rooms which are free at the time of slot which has code=slotCode
   List<LocationDto> filterLocation(List<LocationDto> locations, int slotCode) {
      
      for(int i=0; i<locations.size(); i++)
      {
          List<SlotDto> assignedSlots = locations.get(i).getAssignedSlots();
         // if assignedSlots is null that means it available along the day 
         if(assignedSlots!=null)
         {
              
              for(int k=0; k<assignedSlots.size(); k++)
              {
                 if(assignedSlots.get(k).getCode()== slotCode )
                 { // this means room no i is busy at this time 
                   locations.remove(i);
                  }
              }
          }
          
          
      }
       
     return locations ;  
    }

    // method to calculate the distance between the student's number , capacity
    // and return the location which have the min distance 
    LocationDto cal_Min_Distance(List<LocationDto> locations, int student_Num) {
        // this to hold all distances
        int[] distances = new int[locations.size()];
        // loop to calculate all distances
        for (int i = 0; i < locations.size(); i++) { // actually this is the free places if we reserved for +ve only
            // as -ve means this not proper room
            distances[i] = locations.get(i).getCapacity() - student_Num;
        } 
        
        // this to hold the index of the minmum distance
        int min_index =0 ; 
        // loop to get minmum distance 
        for(int i=0; i<distances.length ; i++)
        {
            // check if distance is positive 
            if(i>0 && distances[i]>0)
            {   
                if (distances[i]<distances[i-1])
                    min_index = i ; 
            }

        }
        return locations.get(min_index);
    }

    // method to check if the room is proper 
    boolean checkProper(LocationDto location, String prefSpace) {
         
            if (prefSpace.equals((location.getType().getDescription())))
               return true;
            else
               
        return false;
    }

    // method to choose the best location (( this to drive the tow method calculateProper,calculateDistance ))
    @SuppressWarnings("oracle.jdeveloper.java.trivial-assignment")
    LocationDto decitionMake(List<LocationDto> locations, int student_Num, String prefSpace) {
        LocationDto resultLocation = null ; 
        
        for (int i=0; i<locations.size(); i++)
        {
            LocationDto minLocation = cal_Min_Distance(locations ,student_Num) ;
            if( checkProper(minLocation ,prefSpace))
            {
                // now this is proper 
                // i can't trust if this will success or not 
                resultLocation = minLocation ; 
                i = locations.size() ; 
            }
            
            else 
            {
                // if we come here  this means the minLocation faild to proper 
                // so we need to remove this from our list 
                locations.remove(minLocation) ; 

            }
            
        }
    

        return resultLocation;
    }


}