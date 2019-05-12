package com.fym.lta.dao;

import com.fym.lta.dto.CourseDto;

import com.fym.lta.dto.EmployeeDto;

import java.util.List;

public interface CourseDao {
    // this behavior to get all Courses data

    public List<CourseDto> getAll_Courses();


    public boolean delete_Course(CourseDto Course);

    // this behavior to search for Course by id

    public boolean insert_Course(CourseDto Course);

    // this behavior to update Course data

    public boolean Update_Course(CourseDto Course);
    
    // this behavior to check  Course data existance
    public boolean isExist (String Code) ; 
    
    // this behavior to Search for Course data 
    public List<CourseDto> search_Courses(CourseDto Course);
}
