package com.fym.lta.dto;

import java.util.Date;
import java.util.List;

public class FloorDto {

    private int Floor_id;
    private String code, Description;
    private List<LocationDto> floor_Location;

    private BuildingDto building ;

    public FloorDto(BuildingDto building) {
        super();
        this.building = building;
    }

    public FloorDto(int Floor_id) {
        super();
        this.Floor_id = Floor_id;
    }

    public void setBuilding(BuildingDto building) {
        this.building = building;
    }

    public BuildingDto getBuilding() {
        return building;
    }

    public FloorDto (){
        
    }


    public FloorDto(String code) {
        super();
        this.code = code;
    }


    private String  insertedBy, updatedBy;
    private Date inertion_Date, update_Date;


    public void setInsertedBy(String insertedBy) {
        this.insertedBy = insertedBy;
    }

    public String getInsertedBy() {
        return insertedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setInertion_Date(Date inertion_Date) {
        this.inertion_Date = inertion_Date;
    }

    public Date getInertion_Date() {
        return inertion_Date;
    }

    public void setUpdate_Date(Date update_Date) {
        this.update_Date = update_Date;
    }

    public Date getUpdate_Date() {
        return update_Date;
    }

    public FloorDto(int Floor_id, String code, String Description,
                    List<LocationDto> floor_Location) {
        super();
        this.Floor_id = Floor_id;
        this.code = code;
        this.Description = Description;
        this.floor_Location = floor_Location;
    }


    public void setFloor_id(int Floor_id) {
        this.Floor_id = Floor_id;
    }

    public int getFloor_id() {
        return Floor_id;
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

    public void setFloor_Location(List<LocationDto> floor_Location) {
        this.floor_Location = floor_Location;
    }

    public List<LocationDto> getFloor_Location() {
        return floor_Location;
    }

    public Object getBuilding_id() {
        return null;
    }
}
