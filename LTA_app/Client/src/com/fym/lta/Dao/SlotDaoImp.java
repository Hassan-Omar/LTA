package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.SlotDto;

import java.sql.SQLException;
import java.sql.Types;

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
             jdbcR.setString(4,slot.getCurrentCourse().getInstructors().get(1).getEmail());   

             
             jdbcR.setString(5,slot.getType());
             
             jdbcR.setString(6,slot.getPrefSpace());
            
             jdbcR.setInt(7,slot.getSlot_id());   



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

    public int isExist(SlotDto slot) {
        try (JdbcRowSet jdbcR = RowSetProvider.newFactory().createJdbcRowSet()) 
         {
             jdbcR.setUrl(ConnectionFactory.getUrl());
             jdbcR.setUsername(ConnectionFactory.getUsername());
             jdbcR.setPassword(ConnectionFactory.getPassword());
             jdbcR.setCommand(Queries.IS_SLOT_EXIST);
             if (slot.getCurrentLocation() != null )
 
             jdbcR.setString(1,slot.getCode());
             jdbcR.setString(2,slot.getCurrentCourse().getCode());
             
             if (slot.getCurrentCourse().getInstructors().get(0).getEmail()!=null)
                 jdbcR.setString(3,slot.getCurrentCourse().getInstructors().get(0).getEmail()); 
             else 
                 jdbcR.setNull(3, Types.VARCHAR);
            
            
             if(slot.getCurrentCourse().getInstructors().get(1).getEmail()!= null)
                jdbcR.setString(4,slot.getCurrentCourse().getInstructors().get(1).getEmail());
             else 
                jdbcR.setNull(4, Types.VARCHAR);
            
            
             jdbcR.execute(); 
            
               if(jdbcR.next())
                return jdbcR.getInt(1);
               else return -1 ; 
         }
         catch (java.sql.SQLIntegrityConstraintViolationException e) 
         {
             e.printStackTrace();
         } catch (SQLException e)
        {
        }


        return -1 ;
    }

    @Override
    public boolean insert_Slot(SlotDto slot) {
      
      
        try (JdbcRowSet jdbcR = RowSetProvider.newFactory().createJdbcRowSet()) 
         {
             jdbcR.setUrl(ConnectionFactory.getUrl());
             jdbcR.setUsername(ConnectionFactory.getUsername());
             jdbcR.setPassword(ConnectionFactory.getPassword());
             jdbcR.setCommand(Queries.INSER_NEW_SLOT);
            
            //"UPDATE SLOT SET LOCATION_ID=? , COURSE_CODE = ? , STAFF_EMAIL =? , STAFF_EMAIL2 =? , TYPE = ? CODE = ? , PREFSPACE=? WHERE S_CODE = ? ";

             if (slot.getCurrentLocation() != null )
             jdbcR.setInt(1,slot.getCurrentLocation().getLocation_id()); 
             else 
                 jdbcR.setNull(1, Types.VARCHAR);
            
             jdbcR.setString(2,slot.getCurrentCourse().getCode());
            
             if (slot.getCurrentCourse().getInstructors().get(0).getEmail()!=null)
                 jdbcR.setString(3,slot.getCurrentCourse().getInstructors().get(0).getEmail()); 
             else 
                 jdbcR.setNull(3, Types.VARCHAR);
             
             
             if(slot.getCurrentCourse().getInstructors().get(1).getEmail()!= null)
                jdbcR.setString(4,slot.getCurrentCourse().getInstructors().get(1).getEmail());
             else 
                jdbcR.setNull(4, Types.VARCHAR);
 
             jdbcR.setString(6,slot.getCode());
            
             jdbcR.setString(5,slot.getType());
            
             jdbcR.setString(7,slot.getPrefSpace());


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
