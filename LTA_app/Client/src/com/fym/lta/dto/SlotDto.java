package com.fym.lta.dto;


public class SlotDto {
    private int Slot_id;
    private String PrefSpace,type ;
    private LocationDto CurrentLocation;
    private CourseDto currentCourse;
    private EmployeeDto crrentStaffMemb ;  

    public void setPrefSpace(String PrefSpace) {
        this.PrefSpace = PrefSpace;
    }

    public String getPrefSpace() {
        return PrefSpace;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setCrrentStaffMemb(EmployeeDto crrentStaffMemb) {
        this.crrentStaffMemb = crrentStaffMemb;
    }

    public EmployeeDto getCrrentStaffMemb() {
        return crrentStaffMemb;
    }
 
    public SlotDto() {
    }

    public void setSlot_id(int Slot_id) {
        this.Slot_id = Slot_id;
    }

    public int getSlot_id() {
        return Slot_id;
    }
 
 

    public void setCurrentLocation(LocationDto CurrentLocation) {
        this.CurrentLocation = CurrentLocation;
    }

    public LocationDto getCurrentLocation() {
        return CurrentLocation;
    }

    public void setCurrentCourse(CourseDto currentCourse) {
        this.currentCourse = currentCourse;
    }

    public CourseDto getCurrentCourse() {
        return currentCourse;
    }

 
}
