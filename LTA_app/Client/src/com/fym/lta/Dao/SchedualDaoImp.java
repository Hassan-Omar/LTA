package com.fym.lta.dao;
import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.SchedualDto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class SchedualDaoImp implements SchedualDao
{
    public List<SchedualDto> getAll_Scheduals()
    {
        
        List<SchedualDto> Scheduals = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_ALL_SCHEDULE);
            jdbcRs.execute();

            SchedualDto Schedual = null;

            while (jdbcRs.next()) {
                if (Scheduals == null)
                    Scheduals = new ArrayList<>();
                Schedual = new SchedualDto();
                Schedual.setSCHEDULECODE(jdbcRs.getString(1));
                Schedual.setAcademicYear(jdbcRs.getString(2));
                Schedual.setCodeDeparment(jdbcRs.getString(3));

                Scheduals.add(Schedual);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Scheduals;
    }

    public boolean delete_Schedual (String SCHEDULECODE )
    {        
            try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DELETE_SCHEDULE);
            jdbcRs.setString(1, SCHEDULECODE);
            jdbcRs.execute();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
      
    }


    public List<SchedualDto> SearchSchedual(String SCHEDULECODE)
    { List<SchedualDto> Scheduals = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) 
        {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.Search_SCHEDULE);
            jdbcRs.setString(1, '%' + SCHEDULECODE.toLowerCase().trim() + '%');
            jdbcRs.execute();


            while (jdbcRs.next()) {
                if (Scheduals == null)
                    
                Scheduals = new ArrayList<>();
                SchedualDto SerchForTable = new SchedualDto();
                
                SerchForTable.setSCHEDULECODE(jdbcRs.getString(1));
                SerchForTable.setAcademicYear(jdbcRs.getString(2));
                SerchForTable.setCodeDeparment(jdbcRs.getString(3));
   
   
                Scheduals.add(SerchForTable);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Scheduals;
 

    }

    public boolean isExist(String SCHEDULECODE ,int acadimcyear)
 {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_USER_EXIST);
            jdbcRs.setString(1,  SCHEDULECODE );
            jdbcRs.setInt(2,  acadimcyear );
            jdbcRs.execute();
            
            if(jdbcRs.next())
            {
               return true ;  
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean insert_Schedual (SchedualDto Schedual) throws SQLException
    {   
       try (JdbcRowSet jdbcR = RowSetProvider.newFactory().createJdbcRowSet()) 
        {
            jdbcR.setUrl(ConnectionFactory.getUrl());
            jdbcR.setUsername(ConnectionFactory.getUsername());
            jdbcR.setPassword(ConnectionFactory.getPassword());
            jdbcR.setCommand(Queries.INSER_NEW_SCHEDULE);
            
            jdbcR.setString(1, Schedual.getSCHEDULECODE());  // SetSCHEDULECODE
            jdbcR.setString(2, Schedual.getAcademicYear()); // Set AcademicYear 
            jdbcR.setString(3, Schedual.getCodeDeparment()); // Set AcademicYear 
            
            jdbcR.execute();
           
            for (int i=0; i<Schedual.getSchedual_Slots().size(); i++)
            { 
            jdbcR.setCommand(Queries.INSER_NEW_SLotSCHEDULE);
            jdbcR.setString(1,Schedual.getSCHEDULECODE());
            jdbcR.setInt (2, Schedual.getSchedual_Slots().get(i).getSlot_id());
            System.out.println(Schedual.getSchedual_Slots().get(i).getSlot_id());
            jdbcR.execute();
            
            }    
           
            return true;
        }
        catch (java.sql.SQLIntegrityConstraintViolationException e) 
        {
            e.printStackTrace();
        } 
        
 /*       try (JdbcRowSet jdbcR = RowSetProvider.newFactory().createJdbcRowSet()) 
       {
           jdbcR.setUrl(ConnectionFactory.getUrl());
            jdbcR.setUsername(ConnectionFactory.getUsername());
            jdbcR.setPassword(ConnectionFactory.getPassword());
               
            for (int i=0; i<Schedual.getSchedual_Slots().size(); i++)
        { jdbcR.setCommand(Queries.INSER_NEW_SLotSCHEDULE);
         jdbcR.setString(1,Schedual.getSCHEDULECODE()); 
         jdbcR.setInt   (2, Schedual.getSchedual_Slots().get(i).getSlot_id());          
         jdbcR.execute();
        
        }
           return true;
       }  
        catch (java.sql.SQLIntegrityConstraintViolationException e) 
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        return false;  
     }

    
    
  
}
