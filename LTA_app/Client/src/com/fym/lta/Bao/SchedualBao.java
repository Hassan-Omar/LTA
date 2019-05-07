package com.fym.lta.bao;

import com.fym.lta.dto.SchedualDto;
import java.util.List;

public interface SchedualBao {
    /**
     * insert new Schedual if it doesn't exists
     * otherwise it updates the exis. once
     */

    public boolean insertSchedual(SchedualDto Schedual);
    public List<SchedualDto> listAll();
    public List<SchedualDto>  SearchSchedual(String SCHEDULECODE);
    public boolean deleteSchedual(String SCHEDULECODE );
    public boolean isExists(String SCHEDULECODE , int acadimyear);
}
