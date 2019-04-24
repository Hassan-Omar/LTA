package com.fym.lta.Bao;

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
      
}
