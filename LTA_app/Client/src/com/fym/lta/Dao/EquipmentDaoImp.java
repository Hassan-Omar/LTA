package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.EquipmentDto;

import com.fym.lta.dto.LocationDto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class EquipmentDaoImp implements EquipmentDao {
    public List<EquipmentDto> getAll_Equipments() {
        List<EquipmentDto>  equip = null;
              try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                      jdbc.setUrl(ConnectionFactory.getUrl());
                      jdbc.setUsername(ConnectionFactory.getUsername());
                      jdbc.setPassword(ConnectionFactory.getPassword());
                  jdbc.setCommand(Queries.LIST_ALL_EQUIPMENTS);
                  jdbc.execute();
                  EquipmentDto equipment = null; 
                  while(jdbc.next()){
                      if(equip == null)
                      equip = new ArrayList<>();
                     equipment = new EquipmentDto();
                     equipment.setEquipment_id(jdbc.getInt(1));
                     equipment.setCode(jdbc.getString(2));
                     equipment.setType(jdbc.getString(3)); 
                     equipment.setLifSpan(jdbc.getInt(4));    
                     equipment.setStartingTime(jdbc.getString(5));
                     equip.add(equipment);
                  }
              }
              catch(Exception e){
                  e.printStackTrace();      
              }
              
              return equip;
    }

    public boolean delete_Equipment(EquipmentDto Equipment) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                        jdbc.setUrl(ConnectionFactory.getUrl());
                        jdbc.setUsername(ConnectionFactory.getUsername());
                        jdbc.setPassword(ConnectionFactory.getPassword());
                    jdbc.setCommand(Queries.DELETE_Equipment);   
                    jdbc.setInt(1, Equipment.getEquipment_id());
                    jdbc.execute();
                    return true;
                    }catch(Exception e){
                       e.printStackTrace();   
                        return false;
                    }
    }

    public boolean insert_Equipment(EquipmentDto Equipment) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                    jdbc.setUrl(ConnectionFactory.getUrl());
                    jdbc.setUsername(ConnectionFactory.getUsername());
                    jdbc.setPassword(ConnectionFactory.getPassword());
                    jdbc.setCommand(Queries.INSER_NEW_Equipment);
                    jdbc.setInt(1, Equipment.getEquipment_id());
                    jdbc.setString(2, Equipment.getCode());
                    jdbc.setString(3, Equipment.getType());
                    jdbc.setInt(4, Equipment.getLifSpan());
                    jdbc.setString(5, Equipment.getStartingTime());
                    jdbc.execute(); 
                    return true;
                }
               
                catch(Exception e){
                    e.printStackTrace();      
                }
        return false;    
    }

    public boolean Update_Equipment(EquipmentDto Equipment) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                    jdbc.setUrl(ConnectionFactory.getUrl());
                    jdbc.setUsername(ConnectionFactory.getUsername());
                    jdbc.setPassword(ConnectionFactory.getPassword());
                    
                    jdbc.setCommand(Queries.UPDATE_Equipment);
                    jdbc.setString(1, Equipment.getCode());
                    jdbc.setString(2, Equipment.getType());
                    jdbc.setInt(3,Equipment.getLifSpan());
                    jdbc.setString(4, Equipment.getStartingTime());
                    jdbc.execute();   
                    return true;  
                }
                catch(java.sql.SQLIntegrityConstraintViolationException e ){
             //    JOptionPane.showMessageDialog(new (), "Unique Constrain Violated");
                  return false;
                        }
                catch(Exception e){
                   e.printStackTrace();   
                   return false;
               }

    }

    public boolean isExist(EquipmentDto Equipment) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_Equipment_EXIST);
            jdbcRs.setString(1, Equipment.getCode());
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
    
    public List<EquipmentDto> searchEquipments(String code){
        List<EquipmentDto> equip = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.Equipment_SEARCH);
            jdbcRs.setString(1, '%' + code.toLowerCase().trim() + '%');

            jdbcRs.execute();


            while (jdbcRs.next()) {
                if (equip == null)
                    equip = new ArrayList<>();
               EquipmentDto equip_search = new EquipmentDto();
                equip_search.setEquipment_id(jdbcRs.getInt(1));
                equip_search.setCode(jdbcRs.getString(2));
                equip_search.setType(jdbcRs.getString(3)); 
                equip_search.setLifSpan(jdbcRs.getInt(4));    
                equip_search.setStartingTime(jdbcRs.getString(5));
                 
                equip.add(equip_search);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return equip;
    }
}
