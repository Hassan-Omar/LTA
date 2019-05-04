
package com.fym.lta.dto;

import java.util.List;

public class LocationDto {

    private int Location_id, capacity ;
    private FloorDto floor ;
    private BuildingDto building ;

    public void setBuilding(BuildingDto building) {
        this.building = building;
    }

    public BuildingDto getBuilding() {
        return building;
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


    private String code, description;
    private LocationTypeDto type;
    private List<EquipmentDto> Location_equipments;
    private String occupation_purpose ; 

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
