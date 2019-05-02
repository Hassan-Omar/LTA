
package com.fym.lta.dto;

public class LocationTypeDto {

    private int LocationType_id;
    private String code, Description;

    public LocationTypeDto(){
        
    }

    public LocationTypeDto(String code) {
        super();
        this.code = code;
    }

    public void setLocationType_id(int LocationType_id) {
        this.LocationType_id = LocationType_id;
    }

    public int getLocationType_id() {
        return LocationType_id;
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
}
