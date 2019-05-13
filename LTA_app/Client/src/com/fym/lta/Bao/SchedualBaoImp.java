package com.fym.lta.bao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dao.CourseDao;
import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.EmployeeDao;
import com.fym.lta.dao.SchedualDao;
import com.fym.lta.dao.UserDao;
import com.fym.lta.dto.CourseDto;
import com.fym.lta.dto.EmployeeDto;
import com.fym.lta.dto.SchedualDto;
import com.fym.lta.dto.UserDto;

import java.sql.SQLException;

import java.util.List;


public class SchedualBaoImp implements SchedualBao 
{ 

    SchedualDao SchedualDao = new DaoFactory().createSchedualDao();
    
    
    public boolean insertSchedual(SchedualDto Schedual) 
    {

    boolean  check = false;
        try {
            check = SchedualDao.insert_Schedual(Schedual);
        } catch (SQLException e) {
        }
return check;
}



    public List<SchedualDto>  SearchSchedual(String SCHEDULECODE)
    {
        
        if (SCHEDULECODE==null)
            return SchedualDao.getAll_Scheduals() ; 
        
        return SchedualDao.SearchSchedual(SCHEDULECODE);
                
    }

    public boolean deleteSchedual(String SCHEDULECODE)
    
    {
        return SchedualDao.delete_Schedual(SCHEDULECODE) ;
    }
    
    public boolean isExists(String SCHEDULECODE , String acadimyear) {
        return SchedualDao.isExist( SCHEDULECODE ,acadimyear );
    }
    
    public List<SchedualDto> listAll()
    {
        
            return SchedualDao.getAll_Scheduals();

        }

}
