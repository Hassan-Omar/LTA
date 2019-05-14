package com.fym.lta.bao;

import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.SlotDao;
import com.fym.lta.dto.SlotDto;

public class SlotBaoImp implements SlotBao {
    SlotDao slotDaoObj = new DaoFactory().createSlotDao();

    public boolean saveSlot(SlotDto slot) {
        boolean saveStatus = false;
        int slotID = slotDaoObj.isExist(slot) ;
        if ( slotID > 0)
        {   slot.setSlot_id(slotID);
            saveStatus = slotDaoObj.Update_Slot(slot);
        }
        else
            saveStatus = slotDaoObj.insert_Slot(slot);
        return saveStatus;
    }

    public SlotDto SearchSlot(String Day, String startTime) {
        return null;
    }
}
