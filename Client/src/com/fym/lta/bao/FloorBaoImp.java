package com.fym.lta.bao;

import com.fym.lta.dao.BuildingDao;
import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.FloorDao;
import com.fym.lta.common.LTAException;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.FloorDto;

import com.fym.lta.dto.LocationDto;

import java.util.Collections;
import java.util.List;

public class FloorBaoImp implements FloorBao {
    
    FloorDao FloorDaoObj = new DaoFactory().createFloorDao();
    private FloorDto Floor;

/**save inserted or updated floor.. */
    public boolean save(FloorDto Floor) {
    boolean SaveStatus = true;
    try{
            if(FloorDaoObj.isExist(Floor))  //if this floor does exist..
                SaveStatus = FloorDaoObj.Update_Floor(Floor); //update it
            else   //if this floor doesnot exist..
                  SaveStatus= FloorDaoObj.insert_Floor(Floor); //insert it..  
            
      }catch(Exception e){
                  e.printStackTrace();
                  return false;
              }
              return SaveStatus;
              }


/** search for a certain floor..   */
 @Override          
    public List<FloorDto> SearchFloor(String code) {
        
        if (code == null)
            return FloorDaoObj.getAll_Floors();

        return FloorDaoObj.searchFloor(code);
        
        }

   

/**get all floors in database  */
        @Override
        public List<FloorDto> listFloor() {
            return FloorDaoObj.getAll_Floors();
        }
    
    
/** delete Existed floor*/
  @Override   
  public boolean deleteFloor(FloorDto Floor) {
   boolean flag;
   flag = FloorDaoObj.delete_Floor(Floor);
        return flag;
        
        }

}
