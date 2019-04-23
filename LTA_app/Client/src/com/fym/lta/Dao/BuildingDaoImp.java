package com.fym.lta.Dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.BuildingDto;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class BuildingDaoImp implements BuildingDao {
    public List<BuildingDto> getAll_Buildings() {

        List<BuildingDto> Buildings = null;
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_ALL_BUILDINGS);
            jdbcRs.execute();

            BuildingDto Building = null;

            while (jdbcRs.next()) {
                if (Buildings == null)
                    Buildings = new ArrayList<>();
                Building = new BuildingDto();
                Building.setBuilding_id(jdbcRs.getInt(1));
                Building.setCode(jdbcRs.getString(2));
                Building.setDescription(jdbcRs.getString(3));
               // there are others still not added 
          
                Buildings.add(Building);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Buildings;
    }

    public boolean delete_Building(BuildingDto building) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DELETE_BUILDING);
            jdbcRs.setInt(1, building.getBuilding_id());
            jdbcRs.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;    }

    public boolean insert_Building(BuildingDto building) throws LTAException {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSER_NEW_BUILDING);
            
            
            jdbcRs.setString(1, building.getCode()); 
            jdbcRs.setString(2, building.getDescription());
            
            if (building.getUPDATE_DATE() != null)
                jdbcRs.setDate(3,new java.sql.Date(building.getUPDATE_DATE().getTime()));  
            else
                jdbcRs.setNull(3, java.sql.Types.DATE);
            
            if (building.getINSERTION_DATE() != null)
                jdbcRs.setDate(4, new java.sql.Date(building.getINSERTION_DATE().getTime())); 
            else
                jdbcRs.setNull(4, java.sql.Types.DATE);
            
            
            
            
            // check if the person who imserte  is not setted we we will set it empty
            if (building.getINSERTED_BY() != null)
                jdbcRs.setString(5, building.getINSERTED_BY()); 
            else
                jdbcRs.setNull(5, Types.VARCHAR);


            if (building.getUPDATED_BY() != null)
                jdbcRs.setString(6, building.getUPDATED_BY()); 
            else
                jdbcRs.setNull(6, Types.VARCHAR);
            
            
            
            
            jdbcRs.execute();
            
            return true;
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            LTAException ex = new LTAException();
            ex.setExactMessage("Role Name Already Exists!!!");
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean Update_Building(BuildingDto building) {
        return false;
    }

    public boolean isExist(BuildingDto building) {
        return false;
    }
}
