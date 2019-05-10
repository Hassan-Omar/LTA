package com.fym.lta.dto;

import java.util.Date;
import java.util.List;


public class CourseDto {
    private int Course_id, hoursperWeak,enteredNeededSlots;
    private String code, Description, name ,insertedBy, updatedBy;
    private Date inertion_Date, update_Date;
    private List<EmployeeDto> Instructors; // max 2 Instructors
    private List<SlotDto> periods; // max 2 Slot
    private List<LocationTypeDto> neededLocType ; // this to know what type is needed lab or room  

    public CourseDto(int Course_id, int hoursperWeak, String code,
                     String Description, String name) {
        super();
        this.Course_id = Course_id;
        this.hoursperWeak = hoursperWeak;
        this.code = code;
        this.Description = Description;
        this.name = name;
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

    public void setEnteredNeededSlots(int enteredNeededSlots) {
        this.enteredNeededSlots = enteredNeededSlots;
    }

    public int getEnteredNeededSlots() {
        return enteredNeededSlots;
    }

    public CourseDto() {
    }

    public void setCourse_id(int Course_id) {
        this.Course_id = Course_id;
    }

    public int getCourse_id() {
        return Course_id;
    }

    public void setHoursperWeak(int hoursperWeak) {
        this.hoursperWeak = hoursperWeak;
    }

    public int getHoursperWeak() {
        return hoursperWeak;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setInstructors(List<EmployeeDto>Instructors) {
        this.Instructors = Instructors;
    }

    public List<EmployeeDto> getInstructors() {
        return Instructors;
    }

    public void setPeriods(List<SlotDto>periods) {
        this.periods = periods;
    }

    public List<SlotDto> getPeriods() {
        return periods;
    }

    public void setNeededLocType(List<LocationTypeDto> neededLocType) {
        this.neededLocType = neededLocType;
    }

    public List<LocationTypeDto> getNeededLocType() {
        return neededLocType;
    }
}
