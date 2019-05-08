package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.DepartmentDto;

import java.sql.SQLException;

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
                Department.setCode(jdbcRs.getString(2)); // need for edite
                Department.setName(jdbcRs.getString(3));
           //     Department.setHomebuilding(jdbcRs.getString(4)); //*********** bta5od Building DTO 

                Departments.add(Department);

            }
        } catch (SQLException e) {
        }

        return Departments;
    }

    public boolean delete_Department(DepartmentDto Department) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DELETE_DEPARTMENT);
            
            jdbcRs.setInt(1, Department.getDepartment_id());
            System.out.println(Department.getDepartment_id());
            jdbcRs.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean insert_Department(DepartmentDto Department) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSERT_NEW_DEPARTMENT);


            jdbcRs.setString(2, Department.getCode());
            jdbcRs.setString(3, Department.getName());
          //jdbcRs.setString(4, Department.getHomebuilding());
           

            jdbcRs.execute();
            return true;
       } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            LTAException ex = new LTAException();
            ex.setExactMessage("Department Already Exists");
            try {
                throw ex;
            } catch (LTAException f) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean Update_Department(DepartmentDto Department) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
                                jdbcRs.setUrl(ConnectionFactory.getUrl());
                                jdbcRs.setUsername(ConnectionFactory.getUsername());
                                jdbcRs.setPassword(ConnectionFactory.getPassword());
                                jdbcRs.setCommand(Queries.UPDATE_DEPARTMENT);
                                                                             
                                jdbcRs.setString(2, Department.getCode());
                                jdbcRs.setString(3, Department.getName());
                           //     jdbcRs.setString(4, Department.getHomebuilding());
                           
                          System.out.println("------------"+Department.getDepartment_id());
                                jdbcRs.execute();
                                System.out.println("---+++-");
                              return true ;
                            }catch(java.sql.SQLIntegrityConstraintViolationException e){
                                LTAException ex = new LTAException();
                                ex.setExactMessage("Error in Update May be not exist !");
                             //   throw ex;
                            }catch(Exception e){
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
            jdbcRs.setString(3, Department.getName());
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
    
    public List<DepartmentDto> Search_Department (DepartmentDto Department){
            List<DepartmentDto> departments = null;

            try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
                jdbcRs.setUrl(ConnectionFactory.getUrl());
                jdbcRs.setUsername(ConnectionFactory.getUsername());
                jdbcRs.setPassword(ConnectionFactory.getPassword());
                jdbcRs.setCommand(Queries.DEPARTMENT_SEARCH);
                jdbcRs.setString(1, '%' + Department.getName().toLowerCase().trim() + '%');

                jdbcRs.execute();


                while (jdbcRs.next()) {
                    if (departments == null)
                        departments = new ArrayList<>();

                   DepartmentDto lSerch = new DepartmentDto();
                    lSerch.setName(jdbcRs.getString(3));
                    lSerch.setCode(jdbcRs.getString(2));
                
                   
                     
                    departments.add(lSerch);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return departments;
            
        }
    
}
