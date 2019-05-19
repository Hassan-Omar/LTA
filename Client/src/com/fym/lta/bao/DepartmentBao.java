package com.fym.lta.bao;

import com.fym.lta.dto.DepartmentDto;

import java.util.List;

public interface DepartmentBao {
    /**
     * insert new Department if it doesn't exists
     * otherwise it updates the exis. once
     */

    public boolean saveDepartment(DepartmentDto Department);


    /**
     * search for Department 
     */

    public List<DepartmentDto> SearchDepartment(DepartmentDto Department);


    /**
     * Department a Slot
     */
    public boolean deleteDepartment(DepartmentDto Department);

 
 
    /**
     * Get all Departments
     * 
     */
    public List<DepartmentDto> listDepartment() ;
}

