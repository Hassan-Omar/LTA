package com.fym.lta.bao;

import com.fym.lta.dto.EquipmentDto;
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
    
    /**
     * save List of Equipments in specific location
     */
    
    public boolean saveEquipment(List<EquipmentDto> equipment , LocationDto location);
    

    public List<LocationDto> getAvailableLocations(String depName) ; 

}
