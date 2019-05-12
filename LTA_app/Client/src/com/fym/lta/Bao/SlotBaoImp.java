package com.fym.lta.bao;

import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.SlotDao;
import com.fym.lta.dto.SlotDto;

public class SlotBaoImp implements SlotBao {
    SlotDao SlotDao = new DaoFactory().createSlotDao(); 
    public boolean saveSlot(SlotDto slot) {
         
        return SlotDao.insert_Slot(slot);
    }

    public SlotDto SearchSlot(String Day, String startTime) {
        return null;
    }
}
