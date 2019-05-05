package com.fym.lta.bao;

import com.fym.lta.dto.FloorDto;

import java.util.Collections;
import java.util.List;

public class FloorBaoImp implements FloorBao {
    public boolean saveFloor(FloorDto Floor) {
        return false;
    }

    public List<FloorDto> SearchFloor(String floorNumber) {
        return Collections.emptyList();
    }

    public boolean deleteFloor(FloorDto floor) {
        return false;
    }
    
    public List<FloorDto> listAll(){
        return Collections.emptyList();   
    }
}
