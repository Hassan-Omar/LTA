package com.fym.lta.dao;


import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.CourseDto;

import java.sql.SQLException;
import java.sql.Types;

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
                Course.setHoursperWeak(jdbcRs.getInt(10));


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

    public boolean insert_Course(CourseDto Course) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setAutoCommit(false);
            jdbcRs.setCommand(Queries.INSERT_NEW_COURSE);

            jdbcRs.setString(1, Course.getCode());
            jdbcRs.setString(2, Course.getName());

            // check if the person who imserte  is not setted we we will set it empty
            if (Course.getInsertedBy() != null)
                jdbcRs.setString(3, Course.getInsertedBy());
            else
                jdbcRs.setNull(3, Types.VARCHAR);


            if (Course.getUpdatedBy() != null)
                jdbcRs.setString(4, Course.getUpdatedBy());
            else
                jdbcRs.setNull(4, Types.VARCHAR);


            // check if the inserted date is not setted we we will set it
            if (Course.getInertion_Date() != null)
                jdbcRs.setDate(5, new java.sql.Date(Course.getInertion_Date().getTime()));
            else
                jdbcRs.setNull(5, java.sql.Types.DATE);

            if (Course.getUpdate_Date() != null)
                jdbcRs.setDate(6, new java.sql.Date(Course.getUpdate_Date().getTime()));
            else
                jdbcRs.setNull(6, java.sql.Types.DATE);

            jdbcRs.setInt(7, Course.getHoursperWeak());

            jdbcRs.setInt(8, Course.getNeededLocType().getLocationType_id());


            jdbcRs.setString(9, Course.getDescription());

            jdbcRs.execute();

            jdbcRs.setCommand(Queries.INSERT_DEPARTMENT_COURSE);

            jdbcRs.setString(1, Course.getCode());
            jdbcRs.setInt(2, Course.getDepartment().getDepartment_id());

            jdbcRs.execute();
            jdbcRs.commit();


            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean Update_Course(CourseDto Course) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setAutoCommit(false);
            jdbcRs.setCommand(Queries.UPDATE_COURSE);

            jdbcRs.setString(1, Course.getCode());
            jdbcRs.setString(2, Course.getName());

            if (Course.getUpdatedBy() != null)
                jdbcRs.setString(3, Course.getUpdatedBy());
            else
                jdbcRs.setNull(3, Types.VARCHAR);


            if (Course.getUpdate_Date() != null)
                jdbcRs.setDate(4, new java.sql.Date(Course.getUpdate_Date().getTime()));
            else
                jdbcRs.setNull(4, java.sql.Types.DATE);

            jdbcRs.setInt(5, Course.getHoursperWeak());

            jdbcRs.setInt(6, Course.getNeededLocType().getLocationType_id());

            jdbcRs.setString(7, Course.getDescription());

            jdbcRs.setString(8, Course.getCode());
            jdbcRs.execute();

            jdbcRs.setCommand(Queries.UPDATE_DEPARTMENT_COURSE);

            jdbcRs.setString(2, Course.getCode());
            jdbcRs.setInt(1, Course.getDepartment().getDepartment_id());

            jdbcRs.execute();
            jdbcRs.commit();

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

