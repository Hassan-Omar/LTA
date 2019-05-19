package com.fym.lta.dto;

public class SearchDto {
    public SearchDto() {
        }
    private LocationDto location; 
    private BuildingDto building ; 
    private LocationTypeDto type ; 
    private FloorDto floor ; 
    private EquipmentDto equipment ;

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setBuilding(BuildingDto building) {
        this.building = building;
    }

    public BuildingDto getBuilding() {
        return building;
    }

    public void setType(LocationTypeDto type) {
        this.type = type;
    }

    public LocationTypeDto getType() {
        return type;
    }

    public void setFloor(FloorDto floor) {
        this.floor = floor;
    }

    public FloorDto getFloor() {
        return floor;
    }

    public void setEquipment(EquipmentDto equipment) {
        this.equipment = equipment;
    }

    public EquipmentDto getEquipment() {
        return equipment;
    }
}
