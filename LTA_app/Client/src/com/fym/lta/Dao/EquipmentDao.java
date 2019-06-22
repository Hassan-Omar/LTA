package com.fym.lta.dao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dto.EquipmentDto;

import com.fym.lta.dto.LocationDto;

import java.util.List;

public interface EquipmentDao {


    // this behavior to get all Equipments data

    public List<EquipmentDto> getAll_Equipments();
    
    // this behavior to delete  Equipment data

    public boolean delete_Equipment (EquipmentDto Equipment);

    // this behavior to insert  Equipment 

    public boolean insert_Equipment(EquipmentDto Equipment) throws LTAException;

    // this behavior to update Equipment data

    public boolean Update_Equipment(EquipmentDto Equipment)throws LTAException;

    // this behavior to check Equipment existance 
    
    public boolean isExist (EquipmentDto Equipment);
    
    // this behavior to search for Equipment by code
    public List<EquipmentDto> searchEquipments(String code);
    
  
    
}
