package com.fym.lta.bao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dto.SchedualDto;

import java.util.List;

public interface SchedualBao {
    /**
     * insert new Schedual if it doesn't exists
     * otherwise it updates the exis. once
     */
  public boolean saveSchedual(SchedualDto Schedual) throws LTAException;
    public List<SchedualDto> listAll();
    public List<SchedualDto>  SearchSchedual(String SCHEDULECODE);
    public boolean deleteSchedual(String SCHEDULECODE );

    public List<SchedualDto>  listSchedual_inDeparts(String name);
    
    
    public SchedualDto getSlectedTable(String tableCode);
    

}
