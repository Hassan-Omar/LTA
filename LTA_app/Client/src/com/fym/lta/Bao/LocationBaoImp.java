package com.fym.lta.bao;

import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.LocationDao;
import com.fym.lta.dto.LocationDto;

import java.util.List;

public class LocationBaoImp implements LocationBao{
    private LocationDao daoLocation = new DaoFactory().createLocationDao();
      
    public boolean insertLocation(LocationDto Location) {
              boolean saveFlage = true;
              try{
                      saveFlage = daoLocation.insert_Location(Location);
              }catch(Exception e){
                  e.printStackTrace();
                  return false;
              }
              return saveFlage;
          }




    @Override

    public boolean updateLocation(LocationDto Location)
    
    { return daoLocation.Update_Location(Location);
                   }

    @Override
    public   List<LocationDto> searchLocation (String code){
        return daoLocation.searchLocations(code);
    }

    @Override
    public boolean deleteLocation(LocationDto Location) {
        boolean flag; 
        flag = daoLocation.delete_Location(Location);
        return flag;
    }

    @Override
    public List<LocationDto> ListAll() {
        return daoLocation.getAll_Locations();
    }
    
    public List<LocationDto> filterLocations(String LocationTypeCode,String BuildingCode){
        
        return daoLocation.filter(LocationTypeCode,BuildingCode);
    }
    
   

    @Override
    public List<LocationDto> getAvailableLocations(String depName) {
        return daoLocation.getAvailableRoom(depName);
    }

    @Override
    public boolean saveLocationSlot(LocationDto loc) {

        return daoLocation.insertLocationSlot(loc);
    }
}


