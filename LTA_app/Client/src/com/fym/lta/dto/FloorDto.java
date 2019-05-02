package com.fym.lta.dto;

import java.util.List;

public class FloorDto {

    private int Floor_id;
    private String code, Description;
    private List<LocationDto> floor_Location;

    public FloorDto(int Floor_id) {
        super();
        this.Floor_id = Floor_id;
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
}
