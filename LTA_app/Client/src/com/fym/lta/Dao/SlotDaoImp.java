package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.SlotDto;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class SlotDaoImp implements SlotDao {
    public List<SlotDto> getAll_Slots() {
        return Collections.emptyList();
    }

    public boolean delete_Slot(SlotDao slot) {
        return false;
    }
    public boolean Update_Slot(SlotDto slot) {
        return false;
    }

    public boolean isExist(SlotDto slot) {
        return false;
    }

    @Override
    public boolean insert_Slot(SlotDto slot) {
      
      
        try (JdbcRowSet jdbcR = RowSetProvider.newFactory().createJdbcRowSet()) 
         {
             jdbcR.setUrl(ConnectionFactory.getUrl());
             jdbcR.setUsername(ConnectionFactory.getUsername());
             jdbcR.setPassword(ConnectionFactory.getPassword());
             jdbcR.setCommand(Queries.INSER_NEW_SLOT);

            jdbcR.setString(1, slot.getDay());
            jdbcR.setString(2, slot.getStartTime());
            jdbcR.setString(3, slot.getPrefSpace());
            jdbcR.setString(4, slot.getType());
            jdbcR.setInt(5, slot.getSlot_id());
         //   jdbcR.setInt(6, slot.getCurrentCourse().getCode());



            jdbcR.execute();             
               
            
             return true;
         }
         catch (java.sql.SQLIntegrityConstraintViolationException e) 
         {
             e.printStackTrace();
         } catch (SQLException e)
        {
        }


        return false;
    }
}
