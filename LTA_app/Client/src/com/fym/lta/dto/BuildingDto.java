package com.fym.lta.dto;

import java.util.Date;
import java.util.List;

public class BuildingDto {

    public void setINSERTED_BY(String INSERTED_BY) {
        this.INSERTED_BY = INSERTED_BY;
    }

    public String getINSERTED_BY() {
        return INSERTED_BY;
    }

    public void setUPDATED_BY(String UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    public String getUPDATED_BY() {
        return UPDATED_BY;
    }

    public void setINSERTION_DATE(Date INSERTION_DATE) {
        this.INSERTION_DATE = INSERTION_DATE;
    }

    public Date getINSERTION_DATE() {
        return INSERTION_DATE;
    }

    public void setUPDATE_DATE(Date UPDATE_DATE) {
        this.UPDATE_DATE = UPDATE_DATE;
    }

    public Date getUPDATE_DATE() {
        return UPDATE_DATE;
    }
    private int building_id;
    private String code, Description ,INSERTED_BY, UPDATED_BY;
    private List<FloorDto> building_floor;
    private List<DepartmentDto> Departments_in_building;
    private Date INSERTION_DATE, UPDATE_DATE;
    
    
    
    public BuildingDto(int building_id, String code, String Description,
                       List<FloorDto> building_floor,
                       List<DepartmentDto> Departments_in_building) {
        super();
        this.building_id = building_id;
        this.code = code;
        this.Description = Description;
        this.building_floor = building_floor;
        this.Departments_in_building = Departments_in_building;
    }

    public BuildingDto() {
    }


    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }

    public void setBuilding_floor(List<FloorDto> building_floor) {
        this.building_floor = building_floor;
    }

    public List<FloorDto> getBuilding_floor() {
        return building_floor;
    }

    public void setDepartments_in_building(List<DepartmentDto> Departments_in_building) {
        this.Departments_in_building = Departments_in_building;
    }

    public List<DepartmentDto> getDepartments_in_building() {
        return Departments_in_building;
    }

    public void setDepartments_in_building(String string) {
    }

    public void setBuilding_floor(String string) {
    }
}
