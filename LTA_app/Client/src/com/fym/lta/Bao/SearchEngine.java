package com.fym.lta.Bao;

import com.fym.lta.Dao.BuildingDao;
import com.fym.lta.Dao.CourseDao;
import com.fym.lta.Dao.DaoFactory;
import com.fym.lta.Dao.DepartmentDao;
import com.fym.lta.Dao.EquipmentDao;
import com.fym.lta.Dao.FloorDao;
import com.fym.lta.Dao.LocationDao;
import com.fym.lta.Dao.SchedualDao;
import com.fym.lta.Dao.SlotDao;
import com.fym.lta.Dao.UserDao;
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
        BuildingDao building = new DaoFactory().CreateBuildingDao();
        return building.getAll_Buildings();
    }

    public List<UserDto> getallUsers() {
        UserDao User = new DaoFactory().CreateUserDao();
        return User.getAll_Users();
    }

    public List<EquipmentDto> getAllEquipments() {
        EquipmentDao Equipment = new DaoFactory().CreateEquipmentDao();
        return Equipment.getAll_Equipments();
    }

    public List<FloorDto> getallFloors() {
        FloorDao Floor = new DaoFactory().CreateFloorDao();
        return Floor.getAll_Floors();
    }

    public List<DepartmentDto> getAllDepartments() {
        DepartmentDao Department = new DaoFactory().CreateDepartmentDao();
        return Department.getAll_Departments();
    }


    public List<CourseDto> getAllCourses() {
        CourseDao Course = new DaoFactory().CreateCourseDao();
        return Course.getAll_Courses();
    }

    public List<SlotDto> getallSlots() {
        SlotDao Slot = new DaoFactory().CreateSlotDao();
        return Slot.getAll_Slots();
    }

    public List<SchedualDto> getAllDScheduals() {
        SchedualDao Schedual = new DaoFactory().CreateSchedualDao();
        return Schedual.getAll_Scheduals();
    }
}
