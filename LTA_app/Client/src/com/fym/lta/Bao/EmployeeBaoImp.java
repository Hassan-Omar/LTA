package com.fym.lta.Bao;

import com.fym.lta.Dao.DaoFactory;
import com.fym.lta.Dao.EmployeeDao;
import com.fym.lta.dto.EmployeeDto;

import java.util.List;

public class EmployeeBaoImp implements EmployeeBao {
    EmployeeDao empDaoObject = new DaoFactory().CreateEmployeeDao();


    public boolean insertEmployee(EmployeeDto Employee) {
        // shut off this part untile u implment this method
        // if (empDaoObject.isExist(Employee))
        return empDaoObject.insert_Employee(Employee);
        //else // report me
    }

    public List<EmployeeDto> SearchEmployee(EmployeeDto Employee) {

        return empDaoObject.search_employees(Employee);

    }


    public List<EmployeeDto> listEmployee() {

        return empDaoObject.getAll_Employees();
    }

    public boolean deleteEmployee(EmployeeDto Employee) {
        return false;
    }
}
