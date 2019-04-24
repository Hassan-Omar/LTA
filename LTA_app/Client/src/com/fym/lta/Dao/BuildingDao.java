
package com.fym.lta.Dao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dto.BuildingDto;

import java.util.List;

public interface BuildingDao {


    // this behavior to get all buildings data

    public List<BuildingDto> getAll_Buildings();


    // this behavior to delete  building data

    public boolean delete_Building(BuildingDto building );


    // this behavior to search for building by id

    public boolean insert_Building(BuildingDto building)throws LTAException;


    // this behavior to update building data

    public boolean Update_Building(BuildingDto building);
    
    // this behavior to check data existance 
    public boolean isExist (BuildingDto building);
    

    public List<BuildingDto> searchBuildings(String code);

}
