package com.fym.lta.bao;

import com.fym.lta.dto.LocationDto;

import java.util.List;

public interface LocationBao {
    /**
       * insert new Location if it doesn't exists
       * otherwise it updates the exis. once
       */
      public boolean insertLocation(LocationDto Location);

    public boolean updateLocation(LocationDto Location);
   

    public   List<LocationDto> searchLocation (String code);

      /**
       * delete a Location 
       */
      public boolean deleteLocation(LocationDto Location);
      
    /**
     * get List of Locations  
     */
      public List<LocationDto> ListAll();
    
    /**
     * filter Locations based on Location Type & Building  
     */
      public List<LocationDto> filterLocations(String LocationTypeCode,String BuildingCode);
    
  

    public List<LocationDto> getAvailableLocations(String depName) ; 


    public boolean saveLocationSlot(LocationDto loc ); 

    // this only can used for algorithm 
    public boolean isSlotAssigned(LocationDto loc) ;
    
}
