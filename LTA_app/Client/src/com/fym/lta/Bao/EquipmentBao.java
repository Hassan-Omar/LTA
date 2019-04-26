package com.fym.lta.bao;

import com.fym.lta.dto.EquipmentDto;

import java.util.List;

public interface EquipmentBao {
    /**
     * insert new Equipment if it doesn't exists
     * otherwise it updates the exis. once
     */
    public boolean saveEquipment(EquipmentDto Equipment);


    /**
     * search for Equipment
     */

    public List<EquipmentDto> SearchEquipment(String name);


    /**
     * delete an Equipment 
     */
    public boolean deleteEquipment(EquipmentDto Equipment);
}
