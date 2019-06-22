package com.fym.lta.bao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.EquipmentDao;

import com.fym.lta.dto.EquipmentDto;

import com.fym.lta.dto.LocationDto;

import java.util.List;

public class EquipmentBaoImp implements EquipmentBao {
    
    private EquipmentDao daoEquipment = new DaoFactory().createEquipmentDao();
    
    public boolean insertEquipment(EquipmentDto Equipment)throws LTAException {
        boolean saveFlage = true;
        try{
                saveFlage = daoEquipment.insert_Equipment(Equipment);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return saveFlage;
    }

    public boolean deleteEquipment(EquipmentDto Equipment) {
        boolean flag; 
        flag = daoEquipment.delete_Equipment(Equipment);
        return flag;
    }
    
    public boolean updateEquipment(EquipmentDto Equipment) throws LTAException
    
    { return daoEquipment.Update_Equipment(Equipment);
                   }

  
   public List<EquipmentDto> SearchEquipment(String name){
        return daoEquipment. searchEquipments(name);
    }
    
    public List<EquipmentDto> ListAll() {
        return daoEquipment.getAll_Equipments();
    }
    
   
}
