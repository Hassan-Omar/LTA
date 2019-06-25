package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.DepartmentDto;

import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class DepartmentDaoImp implements DepartmentDao {


    public List<DepartmentDto> getAll_Departments() {

        List<DepartmentDto> Departments = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_ALL_DEPARTMENT);

            jdbcRs.execute();

            DepartmentDto Department = null;

            while (jdbcRs.next()) {
                if (Departments == null)

                    Departments = new ArrayList<>();
                Department = new DepartmentDto();

                Department.setDepartment_id(jdbcRs.getInt(1));
                Department.setName(jdbcRs.getString(2));
                Department.setCode(jdbcRs.getString(3));
                
                BuildingDto building  = new BuildingDto(jdbcRs.getInt(4));
                building.setCode(jdbcRs.getString(5));
                Department.setHomebuilding(building);
                
                Department.setInsertedBy(jdbcRs.getString(6));                
                Department.setUpdatedBy(jdbcRs.getString(7));
                
                Department.setInertion_Date(jdbcRs.getDate(8));
                Department.setUpdate_Date(jdbcRs.getDate(9));

                
                Departments.add(Department);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Departments;
    }

    public boolean delete_Department(DepartmentDto Department) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DELETE_DEPARTMENT);

            jdbcRs.setString(1, Department.getCode());

            jdbcRs.execute();
            
            jdbcRs.setCommand(Queries.DELETE_BUILDING_TO_DEPARTMENT);

            jdbcRs.setString(1, Department.getCode());

            jdbcRs.execute();
            
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean insert_Department(DepartmentDto department) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());

            jdbcRs.setCommand(Queries.INSERT_NEW_DEPARTMENT);
            jdbcRs.setAutoCommit(false);
            jdbcRs.setString(1, department.getCode());
            jdbcRs.setString(2, department.getName());

            // check if the inserted date is not setted we we will set it
            if (department.getInertion_Date() != null)
                jdbcRs.setDate(3, new java.sql.Date(department.getInertion_Date().getTime()));
            else
                jdbcRs.setNull(3, java.sql.Types.DATE);

             
             jdbcRs.setString(4, department.getInsertedBy());
           
            
            jdbcRs.execute();
            jdbcRs.setCommand(Queries.INSERT_BUILDING_TO_DEPARTMENT);
            jdbcRs.setString(2, department.getCode());
            jdbcRs.setInt(1, department.getHomebuilding().getBuilding_id());
            jdbcRs.execute();
            jdbcRs.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean Update_Department(DepartmentDto department) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setAutoCommit(false);

            jdbcRs.setCommand(Queries.UPDATE_DEPARTMENT);
            
            jdbcRs.setString(1, department.getName());
            jdbcRs.setString(4, department.getCode()); 
 
             // check if the update date is not setted we we will set it
            if (department.getUpdate_Date() != null)
                jdbcRs.setDate(2, new java.sql.Date(department.getUpdate_Date().getTime()));
            else
                jdbcRs.setNull(2, java.sql.Types.DATE);

            if (department.getUpdatedBy() != null)
                jdbcRs.setString(3, department.getUpdatedBy());
            else
                jdbcRs.setNull(3, Types.VARCHAR);

            jdbcRs.execute();
            jdbcRs.setCommand(Queries.UPDATE_BUILDING_TO_DEPARTMENT);

            jdbcRs.setString(2, department.getCode());
            if(department.getHomebuilding()!=null)
            jdbcRs.setInt(1, department.getHomebuilding().getBuilding_id());
            else 
                jdbcRs.setNull(1, Types.VARCHAR);
            
            jdbcRs.execute();
            jdbcRs.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isExist(DepartmentDto Department) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_DEPARTMENT_EXIST);
            jdbcRs.setString(1, Department.getCode());
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

    public List<DepartmentDto> Search_Department(DepartmentDto Department) {
        List<DepartmentDto> departments = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DEPARTMENT_SEARCH);
            jdbcRs.setString(1, '%' + Department.getCode().toLowerCase().trim() + '%');
            jdbcRs.setString(2, '%' + Department.getCode().toLowerCase().trim() + '%');

            jdbcRs.execute();

            DepartmentDto dep = new DepartmentDto();
            while (jdbcRs.next()) {
                if (departments == null)
                    departments = new ArrayList<>();

                departments = new ArrayList<>();
                Department = new DepartmentDto();

                dep.setDepartment_id(jdbcRs.getInt(1));
                dep.setName(jdbcRs.getString(2));
                dep.setCode(jdbcRs.getString(3));
                
                BuildingDto building  = new BuildingDto(jdbcRs.getInt(4));
                building.setCode(jdbcRs.getString(5));
                dep.setHomebuilding(building);
                
                Department.setInsertedBy(jdbcRs.getString(6));                
                Department.setUpdatedBy(jdbcRs.getString(7));
                Department.setInertion_Date(jdbcRs.getDate(8));
                Department.setUpdate_Date(jdbcRs.getDate(9));

                departments.add(dep);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return departments;

    }

}
