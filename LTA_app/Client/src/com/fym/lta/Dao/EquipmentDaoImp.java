package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.EquipmentDto;
import com.fym.lta.dto.LocationDto;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class EquipmentDaoImp implements EquipmentDao {
    
    //this function is to list all equipments on the specific location
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
                     equipment.setStartingTime(jdbc.getDate(5)); 
                     equipment.setLocation_equipment(new LocationDto(jdbc.getString("Location")));   
                     equipment.setInsertedBy(jdbc.getString(7));
                     equipment.setUpdatedBy(jdbc.getString(8)); 
                     equipment.setInertion_Date(jdbc.getDate(9));
                     equipment.setUpdate_Date(jdbc.getDate(10));  
                      
                     equip.add(equipment);
                  }
              }
              catch(Exception e){
                  e.printStackTrace();      
              }
              
              return equip;
    }
    //this is to delete an equipment using its ID
    public boolean delete_Equipment(EquipmentDto Equipment) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                        jdbc.setUrl(ConnectionFactory.getUrl());
                        jdbc.setUsername(ConnectionFactory.getUsername());
                        jdbc.setPassword(ConnectionFactory.getPassword());
                    jdbc.setCommand(Queries.DELETE_Equipment);   
                    jdbc.setString(1, Equipment.getCode());
                    jdbc.execute();
                    return true;
                    }catch(Exception e){
                       e.printStackTrace();   
                        return false;
                    }
    }
    //this is to insert an equipment using its ID into a specific location
    public boolean insert_Equipment(EquipmentDto Equipment) throws LTAException {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                    jdbc.setUrl(ConnectionFactory.getUrl());
                    jdbc.setUsername(ConnectionFactory.getUsername());
                    jdbc.setPassword(ConnectionFactory.getPassword());
                    jdbc.setCommand(Queries.INSER_NEW_Equipment);
 
                    jdbc.setString(1, Equipment.getCode());
                    jdbc.setString(2, Equipment.getType());
                    jdbc.setInt(3, Equipment.getLifSpan());
 
                  //  jdbc.setDate(4, new java.sql.Date(Equipment.getStartingTime().getTime()));
                    jdbc.setString(4, Equipment.getInsertedBy());
                    jdbc.setDate(5, new java.sql.Date(Equipment.getInertion_Date().getTime()));
                    jdbc.setInt(6, Equipment.getLocation_equipment().getLocation_id());
                    jdbc.execute(); 
                    return true;
                }
        catch(java.sql.SQLIntegrityConstraintViolationException e ){
          JOptionPane.showMessageDialog(null, "Unique Constrain Violated, please insert unique ID");
          
                }
        //     catch(java.sql.SQLException e){
        //     JOptionPane.showMessageDialog( null , "Database Failed");
        //     }
                catch(Exception e){
                    e.printStackTrace();      
                }
        return false;    
    }
    //this is to update an equipment using its ID
    public boolean Update_Equipment(EquipmentDto Equipment) throws LTAException {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                    jdbc.setUrl(ConnectionFactory.getUrl());
                    jdbc.setUsername(ConnectionFactory.getUsername());
                    jdbc.setPassword(ConnectionFactory.getPassword());
                    jdbc.setCommand(Queries.UPDATE_Equipment);
            
                    jdbc.setString(6, Equipment.getCode());
                    jdbc.setString(1, Equipment.getType());
                    jdbc.setInt(2,Equipment.getLifSpan());
                      //no need to update starting Time!   
                   // jdbc.setDate(4, new java.sql.Date(Equipment.getStartingTime().getTime()));
                    jdbc.setString(3, Equipment.getUpdatedBy());
                    jdbc.setDate(4, new java.sql.Date(Equipment.getUpdate_Date().getTime()));
                    jdbc.setInt(5,Equipment.getLocation_equipment().getLocation_id());


                    jdbc.execute();   
                    return true;  
                }
                catch(java.sql.SQLIntegrityConstraintViolationException e ){
                 JOptionPane.showMessageDialog(null, "Unique Constrain Violated, please insert unique ID");
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
    //this is to search for equipment using code letters
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
                equip_search.setLocation_equipment(new LocationDto(jdbcRs.getString("Location")));  
                equip_search.setLifSpan(jdbcRs.getInt(5));    
                equip_search.setStartingTime(jdbcRs.getDate(6));
                equip_search.setInsertedBy(jdbcRs.getString(7));
                equip_search.setUpdatedBy(jdbcRs.getString(8)); 
                equip_search.setInertion_Date(jdbcRs.getDate(9));
                equip_search.setUpdate_Date(jdbcRs.getDate(10));    
                equip.add(equip_search);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return equip;
    }
    
    
}
