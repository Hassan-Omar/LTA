package com.fym.lta.Dao;


import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.EmployeeDto;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
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

                Employee.setEmp_id(jdbcRs.getInt(6));
                //  Employee.setEmail(jdbcRs.getString(1));
                Employee.setCareerDgree(jdbcRs.getString(1)); // need for edite
                Employee.setFName(jdbcRs.getString(2));
                Employee.setSName(jdbcRs.getString(3));
                Employee.setLName(jdbcRs.getString(4));
                Employee.setFamilyName(jdbcRs.getString(5));


                Employees.add(Employee);

            }
        } catch (SQLException e) {
        }

        return Employees;
    }

    @Override
    public boolean delete_Employee(EmployeeDto Employee) {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean insert_Employee(EmployeeDto Employee) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSER_NEW_EMPLOYEE);

            //jdbcRs.setString(1, Employee.getCareerDgree());
            // jdbcRs.setString(2, Employee.getEmail());
            jdbcRs.setString(1, Employee.getFName());
            jdbcRs.setString(2, Employee.getSName());
            jdbcRs.setString(3, Employee.getLName());
            jdbcRs.setString(4, Employee.getFamilyName());

            jdbcRs.execute();
            return true;
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
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
    public boolean Update_Employee(EmployeeDto Employee) {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean isExist(EmployeeDto Employee) {
        // TODO Implement this method
        return false;
    }

    @Override
    public List<EmployeeDto> search_employees(EmployeeDto Employee) {
        // TODO Implement this method
        return Collections.emptyList();
    }
}
