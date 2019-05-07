package com.fym.lta.bao;

import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.SchedualDao;
import com.fym.lta.dao.UserDao;
import com.fym.lta.dto.SchedualDto;
import com.fym.lta.dto.UserDto;

import java.util.List;


public class SchedualBaoImp implements SchedualBao 
{ 

    SchedualDao SchedualDao = new DaoFactory().createSchedualDao();

    
    public boolean insertSchedual(SchedualDto Schedual) 
    {
        boolean check = false;

        
        try 
        {
            check = SchedualDao.insert_Schedual(Schedual);
        } 
        catch (Exception e) 
        {
            // not handeled we should move up to user
            e.printStackTrace();
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
    
    public boolean isExists(String SCHEDULECODE , int acadimyear) {
        // delegate to dao method 
        return SchedualDao.isExist( SCHEDULECODE ,acadimyear );
    }
    
    public List<SchedualDto> listAll()
    {
        
            return SchedualDao.getAll_Scheduals();

        }

}
