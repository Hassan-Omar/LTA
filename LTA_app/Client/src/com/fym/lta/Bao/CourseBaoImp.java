package com.fym.lta.bao;

import com.fym.lta.dao.CourseDao;
import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dto.CourseDto;

import java.util.Collections;
import java.util.List;

public class CourseBaoImp implements CourseBao
{
    CourseDao courseDaoObject = new DaoFactory().createCourseDao();


    public boolean saveCourses(List<CourseDto> courses) {
         
     return courseDaoObject.save_Courses(courses);
 
    }

    public List<CourseDto> SearchCourse(CourseDto Course) {

        return courseDaoObject.search_Courses(Course);
    }

    public boolean deleteCourse(CourseDto Course) {
        return courseDaoObject.delete_Course(Course);
    }


    public List<CourseDto> listCourses() {
        return courseDaoObject.getAll_Courses();
    }


    
}
