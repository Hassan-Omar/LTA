package com.fym.lta.dto;

public class EquipmentDto {

    private int Equipment_id, lifSpan;
    private String code, type, startingTime;

    public EquipmentDto(int Equipment_id, int lifSpan, String code,
                        String type, String startingTime) {
        super();
        this.Equipment_id = Equipment_id;
        this.lifSpan = lifSpan;
        this.code = code;
        this.type = type;
        this.startingTime = startingTime;
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

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getStartingTime() {
        return startingTime;
    }
}
