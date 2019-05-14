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
        
        
        try (JdbcRowSet jdbcR = RowSetProvider.newFactory().createJdbcRowSet()) 
         {
             jdbcR.setUrl(ConnectionFactory.getUrl());
             jdbcR.setUsername(ConnectionFactory.getUsername());
             jdbcR.setPassword(ConnectionFactory.getPassword());
             jdbcR.setCommand(Queries.UPDATE_SLOT);
             
             if (slot.getCurrentLocation() != null )
             jdbcR.setInt(1,slot.getCurrentLocation().getLocation_id());   
             jdbcR.setString(2,slot.getCurrentCourse().getCode());
             jdbcR.setString(3,slot.getCurrentCourse().getInstructors().get(0).getEmail());   
             jdbcR.setInt(4,slot.getSlot_id());   



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

    public boolean isExist(SlotDto slot) {
        try (JdbcRowSet jdbcR = RowSetProvider.newFactory().createJdbcRowSet()) 
         {
             jdbcR.setUrl(ConnectionFactory.getUrl());
             jdbcR.setUsername(ConnectionFactory.getUsername());
             jdbcR.setPassword(ConnectionFactory.getPassword());
             jdbcR.setCommand(Queries.IS_SLOT_EXISTE);
             if (slot.getCurrentLocation() != null )
             jdbcR.setInt(1,slot.getCurrentLocation().getLocation_id());
            
             jdbcR.setString(2,slot.getCurrentCourse().getCode());
             jdbcR.setString(3,slot.getCurrentCourse().getInstructors().get(0).getEmail());   
             jdbcR.execute(); 
            
               if(jdbcR.next())
                return true;
               else return false ; 
         }
         catch (java.sql.SQLIntegrityConstraintViolationException e) 
         {
             e.printStackTrace();
         } catch (SQLException e)
        {
        }


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
            
             if (slot.getCurrentLocation() != null )
             jdbcR.setInt(1,slot.getCurrentLocation().getLocation_id());   
             jdbcR.setString(2,slot.getCurrentCourse().getCode());
             jdbcR.setString(3,slot.getCurrentCourse().getInstructors().get(0).getEmail());   


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
