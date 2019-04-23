package com.fym.lta.dto;

import java.util.*;

public class DepartmentDto {
    private int department_id;
    private String name, code, Description;
    private BuildingDto homebuilding;
    private List<CourseDto> Department_Courses;
    private List<EmployeeDto> Department_StaffMembers;
    private List<SchedualDto> Department_Scheduals;


    public DepartmentDto(int department_id, String name, String code,
                         String Description, BuildingDto homebuilding,
                         List<CourseDto> Department_Courses,
                         List<EmployeeDto> Department_StaffMembers,
                         List<SchedualDto> Department_Scheduals) {
        super();
        this.department_id = department_id;
        this.name = name;
        this.code = code;
        this.Description = Description;
        this.homebuilding = homebuilding;
        this.Department_Courses = Department_Courses;
        this.Department_StaffMembers = Department_StaffMembers;
        this.Department_Scheduals = Department_Scheduals;
    }

    public DepartmentDto() {
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void setHomebuilding(BuildingDto homebuilding) {
        this.homebuilding = homebuilding;
    }

    public BuildingDto getHomebuilding() {
        return homebuilding;
    }

    public void setDepartment_Courses(List<CourseDto> Department_Courses) {
        this.Department_Courses = Department_Courses;
    }

    public List<CourseDto> getDepartment_Courses() {
        return Department_Courses;
    }

    public void setDepartment_StaffMembers(List<EmployeeDto> Department_StaffMembers) {
        this.Department_StaffMembers = Department_StaffMembers;
    }

    public List<EmployeeDto> getDepartment_StaffMembers() {
        return Department_StaffMembers;
    }

    public void setDepartment_Scheduals(List<SchedualDto> Department_Scheduals) {
        this.Department_Scheduals = Department_Scheduals;
    }

    public List<SchedualDto> getDepartment_Scheduals() {
        return Department_Scheduals;
    }
}
