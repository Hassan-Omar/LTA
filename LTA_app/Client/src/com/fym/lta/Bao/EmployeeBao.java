package com.fym.lta.bao;

import com.fym.lta.dto.EmployeeDto;

import java.util.List;

public interface EmployeeBao {
    /**
     * insert new Employee if it doesn't exists
     * otherwise it updates the exis. once
     */
   public boolean insertEmployee(EmployeeDto Employee);

    public boolean updateEmployee(EmployeeDto Employee);
    /**
     * search for Employee  
     */

   public List<EmployeeDto> SearchEmployee(EmployeeDto Employee)  ;
    
  public boolean isExist(String email);

    public List<EmployeeDto> listEmployee()  ; 

    /**
     * delete an Employee 
     */
    public boolean deleteEmployee(EmployeeDto Employee);
    
}
