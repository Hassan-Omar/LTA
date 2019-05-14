package com.fym.lta.bao;

import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.SchedualDao;
import com.fym.lta.dto.SchedualDto;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;


public class SchedualBaoImp implements SchedualBao 
{ 

    SchedualDao SchedualDao = new DaoFactory().createSchedualDao();
    
    
    public boolean saveSchedual(SchedualDto schedual) 
    {

    boolean  status = false ; 
    
    if(SchedualDao.isExist(schedual.getSCHEDULECODE()))
    {
            try {
                status = SchedualDao.update_Schedual(schedual);
                
            } catch (SQLException e) {
            }
        }
    else
            try {
                status = SchedualDao.insert_Schedual(schedual);
            } catch (SQLException e) {
            }

        return status;
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
    
    
    
    public List<SchedualDto> listAll()
    {
        
            return SchedualDao.getAll_Scheduals();

        }

    @Override
    public List<SchedualDto> listSchedual_inDeparts(String code) {
        // TODO Implement this method
        return Collections.emptyList();
    }
}
