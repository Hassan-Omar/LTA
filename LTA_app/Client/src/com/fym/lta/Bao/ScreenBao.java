package com.fym.lta.Bao;

import com.fym.lta.dto.ScreenDto;

public interface ScreenBao {


    /**
     * insert new Screen if it doesn't exists
     * otherwise it updates the exis. once
     */
    public boolean saveScreen(ScreenDto Screen);




}
