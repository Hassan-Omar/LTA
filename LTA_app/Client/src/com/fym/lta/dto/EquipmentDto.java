package com.fym.lta.dto;

import java.util.Date;

public class EquipmentDto {

    private int Equipment_id, lifSpan ;
    private String code, type,insertedBy, updatedBy;
    private LocationDto location_equipment ;
    private Date inertion_Date, update_Date, startingTime;

    public EquipmentDto(String code) {
        super();
        this.code = code;
    }


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

    public void setLocation_equipment(LocationDto location_equipment) {
        this.location_equipment = location_equipment;
    }

    public LocationDto getLocation_equipment() {
        return location_equipment;
    }


    public EquipmentDto(){
        
    }

    public EquipmentDto(int Equipment_id) {
        super();
        this.Equipment_id = Equipment_id;
    }

    public void setEquipment_id(int Equipment_id) {
        this.Equipment_id = Equipment_id;
    }

    public int getEquipment_id() {
        return Equipment_id;
    }

    public void setLifSpan(int lifSpan) {
        this.lifSpan = lifSpan;
    }

    public int getLifSpan() {
        return lifSpan;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getStartingTime() {
        return startingTime;
    }

}
