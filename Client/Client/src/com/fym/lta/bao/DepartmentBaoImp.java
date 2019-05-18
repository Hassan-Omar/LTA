package com.fym.lta.bao;

import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.DepartmentDao;
import com.fym.lta.dto.DepartmentDto;

import java.util.List;

public class DepartmentBaoImp implements DepartmentBao {
    
    DepartmentDao depDaoObject = new DaoFactory().createDepartmentDao();
    
    public boolean saveDepartment(DepartmentDto Department) {
        boolean status  = false ;
      if (depDaoObject.isExist(Department))
          
         status =  depDaoObject.Update_Department(Department);
          else 
          status = depDaoObject.insert_Department(Department);
         return status; 
  }

    public List<DepartmentDto> SearchDepartment(DepartmentDto Department) {
        
        return depDaoObject.Search_Department(Department);
    }

    public boolean deleteDepartment(DepartmentDto Department) {
        return depDaoObject.delete_Department(Department);
    }
  
    
    public List<DepartmentDto> listDepartment() {
        return depDaoObject.getAll_Departments(); 
        }
    
}
