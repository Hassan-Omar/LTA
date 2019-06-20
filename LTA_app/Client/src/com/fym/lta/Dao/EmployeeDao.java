package com.fym.lta.dao;


import com.fym.lta.common.LTAException;
import com.fym.lta.dto.EmployeeDto;

import java.util.List;

public interface EmployeeDao {
    

    // this behavior to get all buildings data

    public List<EmployeeDto> getAll_Employees() ;


    // this behavior to delete  building data

    public boolean delete_Employee  (EmployeeDto Employee);


    // this behavior to search for building by id

    public boolean save_Employees(List<EmployeeDto> employees)throws LTAException;
 
     
    public List<EmployeeDto> search_employees(EmployeeDto Employee);
    
    public boolean isExist(String email ) ;

}
