package com.fym.lta.bao;

import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.FloorDto;

import com.fym.lta.dto.LocationDto;

import java.util.List;


public interface FloorBao {
///////////////////////////////////////////////////////////////////////////
    /**
     * insert new Floor if it doesn't exists
     * otherwise it updates the exist one
     */
    public boolean save(FloorDto Floor);

///////////////////////////////////////////////////////////////////////////
    /**
     * search for Floor 
     */

    public List<FloorDto> SearchFloor(String code);

///////////////////////////////////////////////////////////////////////////
        /**
         * return all existed floors from database
         */
        public List<FloorDto> listFloor();
///////////////////////////////////////////////////////////////////////////
    /**
     * delete a Floor
     */
    public boolean deleteFloor(FloorDto floor);


}
