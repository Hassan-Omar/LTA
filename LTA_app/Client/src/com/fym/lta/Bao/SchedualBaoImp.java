
package com.fym.lta.bao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.SchedualDao;
import com.fym.lta.dto.SchedualDto;

import java.util.List;


public class SchedualBaoImp implements SchedualBao {

    SchedualDao schedualDao = new DaoFactory().createSchedualDao();


    public boolean saveSchedual(SchedualDto schedual) throws LTAException {

        boolean status = false;

        if (schedualDao.isExist(schedual.getSCHEDULECODE())) {
           
               // status = schedualDao.update_Schedual(schedual);
               schedualDao.delete_Schedual(schedual.getSCHEDULECODE());
               status = schedualDao.insert_Schedual(schedual);
        } else
          
                status = schedualDao.insert_Schedual(schedual);
           


        return status;
    }


    public List<SchedualDto> SearchSchedual(String SCHEDULECODE) {

        if (SCHEDULECODE == null)
            return schedualDao.getAll_Scheduals();

        return schedualDao.SearchSchedual(SCHEDULECODE);

    }

    public boolean deleteSchedual(String SCHEDULECODE)

    {
        return schedualDao.delete_Schedual(SCHEDULECODE);
    }


    public List<SchedualDto> listAll() {

        return schedualDao.getAll_Scheduals();

    }

    @Override
    public List<SchedualDto> listSchedual_inDeparts(String code) {
      
        return schedualDao.listSchedual_inDeparts(code);
    }

 
    @Override
    
    public SchedualDto getSlectedTable(String tableCode)
    {
         
        return schedualDao.getSlectedTable(tableCode);
    }
}
