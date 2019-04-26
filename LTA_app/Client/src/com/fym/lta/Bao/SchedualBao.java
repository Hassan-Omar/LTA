package com.fym.lta.bao;

import com.fym.lta.dto.SchedualDto;

public interface SchedualBao {
    /**
     * insert new Schedual if it doesn't exists
     * otherwise it updates the exis. once
     */

    public boolean saveSchedual(SchedualDto Schedual);


    /**
     * Schedual for Course 
     */

    public SchedualDto SearchSchedual(String code );


    /**
     * delete a Schedual  
     */
    public boolean deleteSchedual(SchedualDto Schedual);
}
