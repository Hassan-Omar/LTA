package com.fym.lta.Bao;

import com.fym.lta.dto.DepartmentDto;

public interface DepartmentBao {
    /**
     * insert new Department if it doesn't exists
     * otherwise it updates the exis. once
     */

    public boolean saveDepartment(DepartmentDto Department);


    /**
     * search for Department 
     */

    public DepartmentDto SearchDepartment(String name );


    /**
     * Department a Slot
     */
    public boolean deleteDepartment(DepartmentDto Department);
}
