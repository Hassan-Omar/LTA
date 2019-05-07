package com.fym.lta.dto;

public class SlotDto {
    private int Slot_id;
    private String startTime, day;
    private LocationDto CurrentLocation;
    private CourseDto currentCourse;

    public SlotDto(int Slot_id, String startTime, String day,
                   LocationDto CurrentLocation, CourseDto currentCourse) {
        super();
        this.Slot_id = Slot_id;
        this.startTime = startTime;
        this.day = day;
        this.CurrentLocation = CurrentLocation;
        this.currentCourse = currentCourse;

    }

    public SlotDto() {
    }

    public void setSlot_id(int Slot_id) {
        this.Slot_id = Slot_id;
    }

    public int getSlot_id() {
        return Slot_id;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
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
