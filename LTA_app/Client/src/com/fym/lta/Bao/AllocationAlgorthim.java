package com.fym.lta.bao;

import com.fym.lta.dto.CourseDto;
import com.fym.lta.dto.DepartmentDto;
import com.fym.lta.dto.LocationDto;

import com.fym.lta.dto.SlotDto;

import java.util.List;

public class AllocationAlgorthim {
    private DepartmentDto currentDepart;
    private CourseDto currentCourse;
    private LocationDto AvailableRoom;

    // this function to search for available room  " run time only "

    public List<LocationDto> getallAvailableRoom() {
        return null;
    }

    // method to check that the student number < = room capapcity

    public boolean checkRoomProper(int Roomid) {
        return false;
    }

    public float calc_utilizationFactor() {
        return 0;
    }
    // method to  connect location  and alloce for a certian time

    public void allocate(int Roomid, int Slotid) {
    }


    // this function to search for available room  " run time only"

    public List<SlotDto> getAvailableSlotes() {
        return null;
    }
}
