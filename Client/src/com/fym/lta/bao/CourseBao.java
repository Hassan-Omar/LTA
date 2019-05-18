package com.fym.lta.bao;

import com.fym.lta.dto.CourseDto;

import java.util.List;

public interface CourseBao {

    /**
     * insert new Course if it doesn't exists
     * otherwise it updates the exis. once
     */

    public boolean saveCourse(CourseDto Course);


    /**
     * search for Course 
     */

    public List<CourseDto> SearchCourse(CourseDto Course) ;


    /**
     * delete a Course 
     */
    public boolean deleteCourse(CourseDto Course);
    public boolean isexistCourse(String code);

  
    public List<CourseDto> listCourses() ;
    
    
}
