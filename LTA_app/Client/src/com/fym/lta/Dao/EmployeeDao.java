package com.fym.lta.Dao;


import com.fym.lta.dto.EmployeeDto;

import java.util.List;

public interface EmployeeDao {
    

    // this behavior to get all buildings data

    public List<EmployeeDto> getAll_Employees() ;


    // this behavior to delete  building data

    public boolean delete_Employee  (EmployeeDto Employee);


    // this behavior to search for building by id

    public boolean insert_Employee (EmployeeDto Employee);


    // this behavior to update building data

    public boolean Update_Employee (EmployeeDto Employee);
    
    // this behavior to check  building existance
     public boolean isExist (EmployeeDto Employee);
    
    public List<EmployeeDto> search_employees(EmployeeDto Employee);
}
