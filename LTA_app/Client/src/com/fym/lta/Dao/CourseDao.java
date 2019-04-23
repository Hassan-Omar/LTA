package com.fym.lta.Dao;

import com.fym.lta.dto.CourseDto;

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
    public boolean isExist (CourseDto Course) ; 
}
