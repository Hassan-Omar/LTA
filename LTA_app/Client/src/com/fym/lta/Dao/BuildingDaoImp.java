package com.fym.lta.dao;

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
                Building.setINSERTED_BY(jdbcRs.getString(4));
                Building.setUPDATED_BY(jdbcRs.getString(5));
                Building.setINSERTION_DATE(jdbcRs.getDate(6));
                Building.setUPDATE_DATE(jdbcRs.getDate(7));
                
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
            jdbcRs.setString(1, building.getCode());
            jdbcRs.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insert_Building(BuildingDto building) throws LTAException {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSER_NEW_BUILDING);


            jdbcRs.setString(1, building.getCode());
            jdbcRs.setString(2, building.getDescription());

            
            if (building.getINSERTION_DATE() != null)
                jdbcRs.setDate(3, new java.sql.Date(building.getINSERTION_DATE().getTime()));
            else
                jdbcRs.setNull(3, java.sql.Types.DATE);


            jdbcRs.setString(4, building.getINSERTED_BY());
            

           
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
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.UPDATE_BUILDING);
            jdbcRs.setString(1, building.getDescription());

            if (building.getUPDATED_BY() != null)
                jdbcRs.setString(2, building.getUPDATED_BY());
            else
                jdbcRs.setNull(2, Types.VARCHAR);
           
            if (building.getUPDATE_DATE() != null)
                jdbcRs.setDate(3, new java.sql.Date(building.getUPDATE_DATE().getTime()));
            else
                jdbcRs.setNull(3, java.sql.Types.DATE);

           
            jdbcRs.setString(4, building.getCode());

            jdbcRs.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isExist(BuildingDto building) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_BUILDING_EXIST);
            jdbcRs.setString(1, building.getCode());
            jdbcRs.execute();
            if (jdbcRs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public List<BuildingDto> searchBuildings(String code){
        
        
            List<BuildingDto> buildings = null;

            try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
                jdbcRs.setUrl(ConnectionFactory.getUrl());
                jdbcRs.setUsername(ConnectionFactory.getUsername());
                jdbcRs.setPassword(ConnectionFactory.getPassword());
                jdbcRs.setCommand(Queries.BUILDINGS_SEARCH);
                jdbcRs.setString(1, '%' + code.toLowerCase().trim() + '%');

                jdbcRs.execute();


                while (jdbcRs.next()) {
                    if (buildings == null)
                        buildings = new ArrayList<>();

                   BuildingDto lSerch = new BuildingDto();
                    lSerch.setCode(jdbcRs.getString(2));
                    lSerch.setBuilding_id(jdbcRs.getInt(1));
                    lSerch.setDescription(jdbcRs.getString(3));
                    lSerch.setINSERTED_BY(jdbcRs.getString(4));
                    lSerch.setUPDATED_BY(jdbcRs.getString(5));
                    lSerch.setINSERTION_DATE(jdbcRs.getDate(6));
                    lSerch.setUPDATE_DATE(jdbcRs.getDate(7));
                    
                     
                    buildings.add(lSerch);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return buildings;
        
        
        
        }
    
    
}
