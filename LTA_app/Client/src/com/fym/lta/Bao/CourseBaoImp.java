package com.fym.lta.bao;

import com.fym.lta.dao.CourseDao;
import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dto.CourseDto;

import java.util.List;

public class CourseBaoImp implements CourseBao
{
    CourseDao courseDaoObject = new DaoFactory().createCourseDao();


    public boolean saveCourse(CourseDto Course) {
        boolean status = false;
        if (courseDaoObject.isExist(Course))
            status = courseDaoObject.Update_Course(Course);
        else
            status = courseDaoObject.insert_Course(Course);

        return status;
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
