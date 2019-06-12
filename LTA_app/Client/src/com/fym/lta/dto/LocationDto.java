
package com.fym.lta.dto;

import java.util.Date;
import java.util.List;

public class LocationDto {

    private int Location_id, capacity ;
    private FloorDto floor ;
    private SlotDto assignedSlot;
    private List<SlotDto> assignedSlots;
    private String code, description  ,insertedBy, updatedBy;;
    private LocationTypeDto type;
    private List<EquipmentDto> Location_equipments;
    private String occupation_purpose ; 
    private Date inertion_Date, update_Date;

    public LocationDto(int Location_id, int capacity, String code,
                       String description,  LocationTypeDto type,
                       List<EquipmentDto> Location_equipments) {
        super();
        this.Location_id = Location_id;
        this.capacity = capacity;
        this.code = code;
        this.description = description;
        this.type = type;
        this.Location_equipments = Location_equipments;
    }

    public void setAssignedSlot(SlotDto assignedSlot) {
        this.assignedSlot = assignedSlot;
    }

    public void setAssignedSlots(List<SlotDto> assignedSlots) {
        this.assignedSlots = assignedSlots;
    }

    public List<SlotDto> getAssignedSlots() {
        return assignedSlots;
    }

    public SlotDto getAssignedSlot() {
        return assignedSlot;
    }


    public LocationDto(String code) {
        super();
        this.
            code = code;
    }

    public void setOccupation_purpose(String occupation_purpose) {
        this.occupation_purpose = occupation_purpose;
    }

    public String getOccupation_purpose() {
        return occupation_purpose;
    }

    public void setFloor(FloorDto floor) {
        this.floor = floor;
    }

    public FloorDto getFloor() {
        return floor;
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

    public LocationDto() {
    }

    public void setLocation_id(int Location_id) {
        this.Location_id = Location_id;
    }

    public int getLocation_id() {
        return Location_id;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }


    public void setType(LocationTypeDto type) {
        this.type = type;
    }

    public LocationTypeDto getType() {
        return type;
    }

    public void setLocation_equipments(List<EquipmentDto> Location_equipments) {
        this.Location_equipments = Location_equipments;
    }

    public List<EquipmentDto> getLocation_equipments() {
        return Location_equipments;
    }
}
