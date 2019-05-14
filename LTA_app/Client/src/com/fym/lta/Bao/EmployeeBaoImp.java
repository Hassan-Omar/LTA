package com.fym.lta.bao;

import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.EmployeeDao;
import com.fym.lta.common.LTAException;
import com.fym.lta.dto.EmployeeDto;

import java.util.List;

public class EmployeeBaoImp implements EmployeeBao 
{
    EmployeeDao empDaoObject = new DaoFactory().createEmployeeDao();

 

    public List<EmployeeDto> SearchEmployee(EmployeeDto Employee) {

        return empDaoObject.search_employees(Employee);

    }

   
    public List<EmployeeDto> listEmployee() {

        return empDaoObject.getAll_Employees();
    }

    public boolean deleteEmployee(EmployeeDto Employee) {
        return empDaoObject.delete_Employee(Employee);
    }

    @Override
    public boolean saveEmployee(EmployeeDto employee) {
        
        boolean saveStatus  = false ; 
        
        if(empDaoObject.isExist(employee.getEmail() ))
            try {
               saveStatus  =  empDaoObject.Update_Employee(employee);
            } catch (LTAException e) {
            }
        else saveStatus = empDaoObject.insert_Employee(employee) ;
        return saveStatus;
    }
}
