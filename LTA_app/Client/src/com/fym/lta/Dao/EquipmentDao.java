package com.fym.lta.dao;

import com.fym.lta.dto.EquipmentDto;

import java.util.List;

public interface EquipmentDao {


    // this behavior to get all Equipments data

    public List<EquipmentDto> getAll_Equipments();
    
    // this behavior to delete  Equipment data

    public boolean delete_Equipment (EquipmentDto Equipment);

    // this behavior to search for Equipment by id

    public boolean insert_Equipment(EquipmentDto Equipment);

    // this behavior to update Equipment data

    public boolean Update_Equipment(EquipmentDto Equipment);

    // this behavior to check Equipment existance 
    
    public boolean isExist (EquipmentDto Equipment);
    
}
