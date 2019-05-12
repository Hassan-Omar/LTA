package com.fym.lta.bao;

import com.fym.lta.dto.SlotDto;

public interface SlotBao {
    /**
     * insert new Slot if it doesn't exists
     * otherwise it updates the exis. once
     */

    public boolean saveSlot(SlotDto slot);

    public SlotDto SearchSlot(String Day ,String startTime);


     
}
