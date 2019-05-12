package com.fym.lta.dao;

import com.fym.lta.dto.SlotDto;

import java.util.List;

public interface SlotDao {

    // this behavior to get all Slots data

    public List<SlotDto> getAll_Slots();

    // this behavior to delete  Slot data

    public boolean delete_Slot(SlotDao slot);

    // this behavior to search for Slot by id



    // this behavior to update Slot data

    public boolean Update_Slot(SlotDto slot);
    
    // this behavior to check Slot existance

    public boolean isExist(SlotDto slot);

    public boolean insert_Slot(SlotDto slot);
}
