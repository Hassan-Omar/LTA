package com.fym.lta.bao;

import com.fym.lta.dto.CourseDto;

import java.util.List;

public interface CourseBao {

    /**
     * insert new Course if it doesn't exists
     * otherwise it updates the exis. once
     */

    public boolean saveCourses(List<CourseDto> courses);


    /**
     * search for Course 
     */

    public List<CourseDto> SearchCourse(CourseDto course) ;


    /**
     * delete a Course 
     */
    public boolean deleteCourse(CourseDto Course);
    
    
    public List<CourseDto> listCourses() ;
    
    
}
