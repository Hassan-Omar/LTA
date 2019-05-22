package com.fym.lta.bao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dto.EmployeeDto;

import java.util.List;

public interface EmployeeBao {
    
    
    
    public boolean saveEmployee(EmployeeDto Employee)throws LTAException;
 

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
