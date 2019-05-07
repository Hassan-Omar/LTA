package com.fym.lta.bao;

import com.fym.lta.dto.EquipmentDto;

import com.fym.lta.dto.LocationDto;

import java.util.List;

public interface EquipmentBao {
    /**
     * insert new Equipment if it doesn't exists
     * otherwise it updates the exis. once
     */
    public boolean insertEquipment(EquipmentDto Equipment);


    /**
     * search for Equipment
     */

    public List<EquipmentDto> SearchEquipment(String name);


    /**
     * delete an Equipment 
     */
    public boolean deleteEquipment(EquipmentDto Equipment);
    
    /**
     * Update an Equipment 
     */
    public boolean updateEquipment(EquipmentDto Equipment);
    
    /**
     * List All Equipments 
     */
    public List<EquipmentDto> ListAll();
    
   
   
}
