package com.fym.lta.Bao;

import com.fym.lta.Dao.DaoFactory;
import com.fym.lta.Dao.LocationDao;
import com.fym.lta.dto.LocationDto;

import java.util.List;

public class LocationBaoImp implements LocationBao{
    private LocationDao dab = new DaoFactory().createLocationDao();
      
    public boolean insertLocation(LocationDto Location) {
              boolean saveFlage = true;
              try{
                      saveFlage = dab.insert_Location(Location);
              }catch(Exception e){
                  e.printStackTrace();
                  return false;
              }
              return saveFlage;
          }




    @Override

    public boolean updateLocation(LocationDto Location)
    
    { return dab.Update_Location(Location);
                   }

    @Override
    public   List<LocationDto> searchLocation (String code){
        return dab.searchLocations(code);
    }

    @Override
    public boolean deleteLocation(LocationDto Location) {
        boolean flag; 
        flag = dab.delete_Location(Location);
        return flag;
    }

    @Override
    public List<LocationDto> ListAll() {
        return dab.getAll_Locations();
    }
}

   

