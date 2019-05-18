package com.fym.lta.bao;

import com.fym.lta.dao.BuildingDao;
import com.fym.lta.dao.DaoFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.dto.BuildingDto;

import java.util.List;

public class BuildingBaoImp implements BuildingBao {
    BuildingDao buildingBaoObject = new DaoFactory().createBuildingDao();

    public boolean saveBuilding(BuildingDto building) {
        boolean status = false;

        try {
            if (buildingBaoObject.isExist(building))
            status = buildingBaoObject.Update_Building(building);
                else 
            status = buildingBaoObject.insert_Building(building);
        } catch (LTAException e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<BuildingDto> SearchBuilding(String code) {
        return buildingBaoObject.searchBuildings(code);
    }

    public List<BuildingDto> listBuilding() {
        return buildingBaoObject.getAll_Buildings();
    }


    public boolean deleteBuilding(BuildingDto building) {
        return buildingBaoObject.delete_Building(building);
    }
}
