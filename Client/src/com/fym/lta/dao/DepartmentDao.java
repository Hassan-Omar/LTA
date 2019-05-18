package com.fym.lta.dao;

import com.fym.lta.dto.DepartmentDto;

import java.util.List;

public interface DepartmentDao {

    // this behavior to get all Department data

    public List<DepartmentDto> getAll_Departments();

    // this behavior to delete  Department data

    public boolean delete_Department(DepartmentDto Department);

    // this behavior to search for Department by id

    public boolean insert_Department(DepartmentDto Department);

    // this behavior to update Department data

    public boolean Update_Department(DepartmentDto Department);
    
    // this behavior to check Department existance

    public boolean isExist(DepartmentDto Department);
    
    // this behavior to search for a Deprtment Data 
    public List<DepartmentDto> Search_Department(DepartmentDto Department); 
    
    
    
    
}
