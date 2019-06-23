package com.fym.lta.dao;


import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.CourseDto;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class CourseDaoImp implements CourseDao {

    public List<CourseDto> getAll_Courses() {
        List<CourseDto> Courses = null;
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_ALL_COURSES);

            jdbcRs.execute();


            CourseDto Course = null;

            while (jdbcRs.next()) {
                if (Courses == null)

                    Courses = new ArrayList<>();
                Course = new CourseDto();
                Course.setCourse_id(jdbcRs.getInt(1));
                Course.setCode(jdbcRs.getString(2));
                Course.setName(jdbcRs.getString(3));
                Course.setDescription(jdbcRs.getString(4));
                Course.setInsertedBy(jdbcRs.getString(5));
                Course.setUpdatedBy(jdbcRs.getString(6));
                Course.setInertion_Date(jdbcRs.getDate(7));
                Course.setUpdate_Date(jdbcRs.getDate(8));
                Course.setHoursperWeak(jdbcRs.getInt(9));
                Courses.add(Course);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Courses;


    }

    public boolean delete_Course(CourseDto Course) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setAutoCommit(false);
            jdbcRs.setCommand(Queries.DELETE_COURSE);
            jdbcRs.setString(1, Course.getCode());
            jdbcRs.execute();

            jdbcRs.setCommand(Queries.DELETE_DEPARTMENT_COURSE);
            jdbcRs.setString(1, Course.getCode());

            jdbcRs.execute();
            jdbcRs.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean save_Courses(List<CourseDto> courses) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setAutoCommit(false);
           for(int i=0; i<courses.size(); i++)
           {  
               CourseDto course =  courses.get(i); 
               if(isExist(course.getCode()))
               {
                   jdbcRs.setCommand(Queries.UPDATE_COURSE);

                   jdbcRs.setString(1, course.getCode());
                   jdbcRs.setString(2, course.getName());

                   jdbcRs.setString(3, course.getUpdatedBy());
                   
                    if (course.getUpdate_Date() != null)
                       jdbcRs.setDate(4, new java.sql.Date(course.getUpdate_Date().getTime()));
                   else
                       jdbcRs.setNull(4, java.sql.Types.DATE);

                   if(course.getHoursperWeak()!=0)
                   jdbcRs.setInt(5, course.getHoursperWeak());
                   else
                       jdbcRs.setNull(5, java.sql.Types.INTEGER);
                   
                   jdbcRs.setInt(6, course.getNeededLocType().getLocationType_id());

                   if(course.getDescription() !=null)
                   jdbcRs.setString(7, course.getDescription());
                   else
                   jdbcRs.setNull(7, java.sql.Types.VARCHAR);
                   
                   
                   jdbcRs.setString(8, course.getCode());
                   jdbcRs.execute();

                   jdbcRs.setCommand(Queries.UPDATE_DEPARTMENT_COURSE);

                   jdbcRs.setString(2, course.getCode());
                   jdbcRs.setString(1, course.getDepartment().getCode());

                   jdbcRs.execute();  
                   jdbcRs.commit();
               }
               else
               {
                   jdbcRs.setCommand(Queries.INSERT_NEW_COURSE);
                   
                    
                   jdbcRs.setString(1, course.getCode());
                   
                   jdbcRs.setString(2, course.getName());

                   jdbcRs.setString(3, course.getInsertedBy());
                    

                   // check if the inserted date is not setted we we will set it
                   if (course.getInertion_Date() != null)
                       jdbcRs.setDate(4, new java.sql.Date(course.getInertion_Date().getTime()));
                   else
                       jdbcRs.setNull(4, java.sql.Types.DATE);
                   
                   
                   if(course.getHoursperWeak()!=0)
                   jdbcRs.setInt(5, course.getHoursperWeak());
                   else
                       jdbcRs.setNull(5, java.sql.Types.INTEGER);
                   
                   jdbcRs.setString(6, course.getNeededLocType().getCode());
                   
                   if(course.getDescription() !=null)
                   jdbcRs.setString(7, course.getDescription());
                   else
                   jdbcRs.setNull(7, java.sql.Types.VARCHAR);
                   
                   jdbcRs.execute();

                   jdbcRs.setCommand(Queries.INSERT_DEPARTMENT_COURSE);

                   jdbcRs.setString(1, course.getCode());
                   jdbcRs.setString(2, course.getDepartment().getCode());

                   jdbcRs.execute();
                   jdbcRs.commit();
                       
               }
           }
           
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    

    public boolean isExist(String code) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_COURSE_EXIST);
            jdbcRs.setString(1, code);
            jdbcRs.execute();
            if (jdbcRs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<CourseDto> search_Courses(CourseDto Course) {

        List<CourseDto> Courses = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.SEARCH_COURSES);
            jdbcRs.setString(1, '%' + Course.getCode().toLowerCase().trim() + '%');
            jdbcRs.setString(2, '%' + Course.getCode().toLowerCase().trim() + '%');

            jdbcRs.execute();


            while (jdbcRs.next()) {
                if (Courses == null)
                    Courses = new ArrayList<>();
                Course = new CourseDto();
                Course.setCourse_id(jdbcRs.getInt(1));
                Course.setCode(jdbcRs.getString(2));
                Course.setName(jdbcRs.getString(3));
                Course.setDescription(jdbcRs.getString(4));
                Course.setInsertedBy(jdbcRs.getString(5));
                Course.setUpdatedBy(jdbcRs.getString(6));
                Course.setInertion_Date(jdbcRs.getDate(7));
                Course.setUpdate_Date(jdbcRs.getDate(8));
                Course.setHoursperWeak(jdbcRs.getInt(10));


                Courses.add(Course);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Courses;

    }


}

