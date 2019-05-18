package com.fym.lta.bao;

import com.fym.lta.dao.BuildingDao;
import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.LocationTypeDao;
import com.fym.lta.common.LTAException;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.LocationTypeDto;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.Collections;
import java.util.List;

public class LocationTypeBaoImp implements LocationTypeBao {
    
    LocationTypeDao LocationTypeDaoObj = new DaoFactory().createLocationTypeDao();   
    private LocationTypeDto LocationType;
   
   
/**save inserted  Location type */   
 public boolean save(LocationTypeDto LocationType) {
        boolean SaveStatus = true;
        try {
            if(LocationTypeDaoObj.isExist(LocationType))
                SaveStatus = LocationTypeDaoObj.Update_LocationType(LocationType);
            
              else     SaveStatus = LocationTypeDaoObj.insert_LocationType(LocationType);
            
              
              }catch(Exception e){
                  e.printStackTrace();
                  return false;
              }
              return SaveStatus;
              }

/** search for a certain location type..   */
@Override          
    public List<LocationTypeDto> SearchLocationType(String Code) {
        
        if (Code == null)
            return LocationTypeDaoObj.getAll_LocationTypes();

        return LocationTypeDaoObj.SearchLocationType(Code);
        
        }
    
    
/**get all Location types in database  */ 
        @Override
    public List<LocationTypeDto> listLocationType( ){
         return LocationTypeDaoObj.getAll_LocationTypes();
     }


/** delete Existed Location Type*/
    @Override    
public boolean deleteLocationType(LocationTypeDto LocationType) {
        boolean flag; 
        flag = LocationTypeDaoObj.delete_LocationType(LocationType);
        return flag;
    }

    @Override
    public List<LocationTypeDto> searchLocationType(LocationTypeDto locType) {
        // TODO Implement this method
        return Collections.emptyList();
    }
}
