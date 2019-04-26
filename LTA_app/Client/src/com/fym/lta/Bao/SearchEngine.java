package com.fym.lta.bao;

import com.fym.lta.dao.BuildingDao;
import com.fym.lta.dao.CourseDao;
import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.DepartmentDao;
import com.fym.lta.dao.EquipmentDao;
import com.fym.lta.dao.FloorDao;
import com.fym.lta.dao.LocationDao;
import com.fym.lta.dao.SchedualDao;
import com.fym.lta.dao.SlotDao;
import com.fym.lta.dao.UserDao;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.CourseDto;
import com.fym.lta.dto.DepartmentDto;
import com.fym.lta.dto.EquipmentDto;
import com.fym.lta.dto.FloorDto;
import com.fym.lta.dto.LocationDto;
import com.fym.lta.dto.SchedualDto;
import com.fym.lta.dto.SlotDto;
import com.fym.lta.dto.UserDto;

import java.util.List;

public class SearchEngine {


    // this function to search for available room  " from stored data"

    public List<LocationDto> getallAvailableRoom() {
        return null;
    }

    // this function to search for available slots " from stored data"

    public List<SlotDto> getallAvailableSlots() {
        return null;
    }


    // all  comming just to use dao methods of get all ;

    public List<LocationDto> getallLocations() {
        LocationDao Location = new DaoFactory().createLocationDao();
        return Location.getAll_Locations();
    }

    public List<BuildingDto> getAllBuildings() {
        BuildingDao building = new DaoFactory().createBuildingDao();
        return building.getAll_Buildings();
    }

    public List<UserDto> getallUsers() {
        UserDao User = new DaoFactory().createUserDao();
        return User.getAll_Users();
    }

    public List<EquipmentDto> getAllEquipments() {
        EquipmentDao Equipment = new DaoFactory().createEquipmentDao();
        return Equipment.getAll_Equipments();
    }

    public List<FloorDto> getallFloors() {
        FloorDao Floor = new DaoFactory().createFloorDao();
        return Floor.getAll_Floors();
    }

    public List<DepartmentDto> getAllDepartments() {
        DepartmentDao Department = new DaoFactory().createDepartmentDao();
        return Department.getAll_Departments();
    }


    public List<CourseDto> getAllCourses() {
        CourseDao Course = new DaoFactory().createCourseDao();
        return Course.getAll_Courses();
    }

    public List<SlotDto> getallSlots() {
        SlotDao Slot = new DaoFactory().createSlotDao();
        return Slot.getAll_Slots();
    }

    public List<SchedualDto> getAllDScheduals() {
        SchedualDao Schedual = new DaoFactory().createSchedualDao();
        return Schedual.getAll_Scheduals();
    }
}
