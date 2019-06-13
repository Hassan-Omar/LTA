package com.fym.lta.dao;


import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.DepartmentDto;
import com.fym.lta.dto.EmployeeDto;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class EmployeeDaoImp implements EmployeeDao {
    public EmployeeDaoImp() {
        super();
    }

    @Override
    public List<EmployeeDto> getAll_Employees() {

        List<EmployeeDto> Employees = null;
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_ALL_EMPLOYEE);

            jdbcRs.execute();

            EmployeeDto Employee = null;

            while (jdbcRs.next()) {
                if (Employees == null)

                    Employees = new ArrayList<>();
                Employee = new EmployeeDto();

 
                Employee.setFName(jdbcRs.getString(1));
                Employee.setSName(jdbcRs.getString(2));
                Employee.setLName(jdbcRs.getString(3));
                Employee.setFamilyName(jdbcRs.getString(4));
                
                Employee.setInsertedBy(jdbcRs.getString(5));
                Employee.setUpdatedBy(jdbcRs.getString(6));
                Employee.setInertion_Date(jdbcRs.getDate(7));
                Employee.setUpdate_Date(jdbcRs.getDate(8));

                Employee.setEmail(jdbcRs.getString(9));
                Employee.setCareerDgree(jdbcRs.getString(10));
                Employee.setEmp_id(jdbcRs.getInt(11));

                DepartmentDto dep = new DepartmentDto() ; 
                dep.setName(jdbcRs.getString(12));
                Employee.setDepartment(dep);

                Employees.add(Employee);

            }
        } catch (SQLException e) {
        }

        return Employees;
    }

    @Override
    public boolean delete_Employee(EmployeeDto Employee) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DELETE_EMPLOYEE);
            
            jdbcRs.setString(1, Employee.getEmail());
            jdbcRs.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean insert_Employee(EmployeeDto Employee) 
    {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet())
        {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSER_NEW_EMPLOYEE); 
            
            jdbcRs.setString(1, Employee.getFName());  
            jdbcRs.setString(2, Employee.getSName()); 
            jdbcRs.setString(3,Employee.getLName());
            jdbcRs.setString(4,Employee.getFamilyName());
           
            jdbcRs.setString(5, Employee.getInsertedBy());
            
             // check if the update date is not setted we we will set it 
             if (Employee.getInertion_Date() != null)
                 jdbcRs.setDate(6, new java.sql.Date(Employee.getInertion_Date().getTime()));
             else
                 jdbcRs.setNull(6, java.sql.Types.DATE);

        
            
            jdbcRs.setString(7,Employee.getEmail());
            
            
            jdbcRs.setString(8,Employee.getCareerDgree());
            
            
            jdbcRs.setString(9,Employee.getDepartment().getCode());
            
            
            
            jdbcRs.execute();
            return true;
        } 
        catch (java.sql.SQLIntegrityConstraintViolationException e) 
        {
            LTAException ex = new LTAException();
            ex.setExactMessage("EMployee Already Exists");
            try {
                throw ex;
            } catch (LTAException f) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean Update_Employee(EmployeeDto Employee) throws LTAException {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
                                jdbcRs.setUrl(ConnectionFactory.getUrl());
                                jdbcRs.setUsername(ConnectionFactory.getUsername());
                                jdbcRs.setPassword(ConnectionFactory.getPassword());
                                jdbcRs.setCommand(Queries.UPDATE_EMPLOYEE);
                                                                                                      
                                jdbcRs.setString(1, Employee.getFName());  
                                jdbcRs.setString(2, Employee.getSName()); 
                                jdbcRs.setString(3,Employee.getLName());
                                jdbcRs.setString(4,Employee.getFamilyName());
                            
                            
                               if (Employee.getUpdatedBy() != null)
                                    jdbcRs.setString(5, Employee.getUpdatedBy());
                                
                                // check if the update date is not setted we we will set it 
                                if (Employee.getUpdate_Date() != null)
                                    jdbcRs.setDate(6, new java.sql.Date(Employee.getUpdate_Date().getTime()));
                                else
                                    jdbcRs.setNull(6, java.sql.Types.DATE);

                                jdbcRs.setString(7,Employee.getCareerDgree());
                                
                                
                                jdbcRs.setString(8,Employee.getDepartment().getCode());
                                
                                jdbcRs.setString(9,Employee.getEmail());

                                jdbcRs.execute();
                              return true ;
                            }catch(java.sql.SQLIntegrityConstraintViolationException e){
                                LTAException ex = new LTAException();
                                ex.setExactMessage("Error in Update May be not exist !");
                                throw ex;
                            }catch(Exception e){
                               e.printStackTrace();     
                            }
                       
                      return false;
    }

    @Override
    public boolean isExist(String email ) 
    {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_EMPLOYEE_EXIST);
            jdbcRs.setString(1, email);
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

    @Override
    public List<EmployeeDto> search_employees(EmployeeDto Employee) {
       
        List<EmployeeDto> employees = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.EMPLOYEE_SEARCH);
            jdbcRs.setString(1, '%' + Employee.getFName().toLowerCase().trim() + '%');
            jdbcRs.setString(2, '%' + Employee.getFName().toLowerCase().trim() + '%');
            jdbcRs.setString(3, '%' + Employee.getFName().toLowerCase().trim() + '%');

            jdbcRs.execute();


            while (jdbcRs.next()) {
                if (employees == null)
                    employees = new ArrayList<>();

                EmployeeDto lSerch = new EmployeeDto () ;
                lSerch.setFName(jdbcRs.getString(1));
                lSerch.setSName(jdbcRs.getString(2));
                Employee.setLName(jdbcRs.getString(3));
                lSerch.setFamilyName(jdbcRs.getString(4));
                
                lSerch.setInsertedBy(jdbcRs.getString(5));
                lSerch.setUpdatedBy(jdbcRs.getString(6));
                lSerch.setInertion_Date(jdbcRs.getDate(7));
                lSerch.setUpdate_Date(jdbcRs.getDate(8));

                lSerch.setEmail(jdbcRs.getString(9));
                lSerch.setCareerDgree(jdbcRs.getString(10));
                lSerch.setEmp_id(jdbcRs.getInt(11));

                DepartmentDto dep = new DepartmentDto() ; 
                dep.setName(jdbcRs.getString(12));
                lSerch.setDepartment(dep);
                employees.add(lSerch);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
        
    }

    }

