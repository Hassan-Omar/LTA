package com.fym.lta.Bao;

import com.fym.lta.dto.EquipmentDto;

import java.util.Collections;
import java.util.List;

public class EquipmentBaoImp implements EquipmentBao {
    public boolean saveEquipment(EquipmentDto Equipment) {
        return false;
    }

    public List<EquipmentDto> SearchEquipment(String name) {
        return Collections.emptyList();
    }

    public boolean deleteEquipment(EquipmentDto Equipment) {
        return false;
    }
}
