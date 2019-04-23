package com.fym.lta.Bao;

import com.fym.lta.Dao.DaoFactory;
import com.fym.lta.Dao.EmployeeDao;
import com.fym.lta.common.LTAException;
import com.fym.lta.dto.EmployeeDto;

import java.util.List;

public class EmployeeBaoImp implements EmployeeBao {
    EmployeeDao empDaoObject = new DaoFactory().CreateEmployeeDao();


    public boolean insertEmployee(EmployeeDto Employee) {
    
        return empDaoObject.insert_Employee(Employee);
     }

    public List<EmployeeDto> SearchEmployee(EmployeeDto Employee) {

        return empDaoObject.search_employees(Employee);

    }

    public boolean updateEmployee(EmployeeDto Employee){

        try {
            return empDaoObject.Update_Employee(Employee);
        } catch (LTAException e) {
        }
   return false; }

    public List<EmployeeDto> listEmployee() {

        return empDaoObject.getAll_Employees();
    }

    public boolean deleteEmployee(EmployeeDto Employee) {
        return empDaoObject.delete_Employee(Employee);
    }
}
