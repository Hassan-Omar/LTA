package com.fym.lta.bao;

import com.fym.lta.dto.CourseDto;

public interface CourseBao {

    /**
     * insert new Course if it doesn't exists
     * otherwise it updates the exis. once
     */

    public boolean saveCourse(CourseDto Course);


    /**
     * search for Course 
     */

    public CourseDto SearchCourse(String Code);


    /**
     * delete a Course 
     */
    public boolean deleteCourse(CourseDto Course);
}
