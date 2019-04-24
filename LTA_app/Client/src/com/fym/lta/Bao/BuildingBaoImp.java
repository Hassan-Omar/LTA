package com.fym.lta.Bao;

import com.fym.lta.Dao.BuildingDao;
import com.fym.lta.Dao.DaoFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.dto.BuildingDto;

import java.util.List;

public class BuildingBaoImp implements BuildingBao {
    BuildingDao buildingBaoObject = new DaoFactory().CreateBuildingDao();

    public boolean saveBuilding(BuildingDto building) {
        boolean status = false;

        try {
            status = buildingBaoObject.insert_Building(building);
        } catch (LTAException e) {
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
