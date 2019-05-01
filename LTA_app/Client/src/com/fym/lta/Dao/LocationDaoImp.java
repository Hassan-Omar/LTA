package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.LocationDto;
import com.fym.lta.ui.DefineLocation;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class LocationDaoImp implements LocationDao {
    
    public List<LocationDto> getAll_Locations() {
        List<LocationDto>  locat = null;
              try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                  
                      jdbc.setUrl(ConnectionFactory.getUrl());
                      jdbc.setUsername(ConnectionFactory.getUsername());
                      jdbc.setPassword(ConnectionFactory.getPassword());
                  jdbc.setCommand(Queries.LIST_ALL_LOCATION);
                  jdbc.execute();
                  LocationDto location = null; 
                  while(jdbc.next()){
                      if(locat == null)
                      locat = new ArrayList<>();
                     location = new LocationDto();
                     location.setLocation_id(jdbc.getInt(1));
                     location.setCode(jdbc.getString(2));
                     location.setDescription(jdbc.getString(3));
                     location.setCapacity(jdbc.getInt(5));           
                     locat.add(location);
                  }
              }
              catch(Exception e){
                  e.printStackTrace();      
              }
              
              return locat;
    }

    public boolean delete_Location(LocationDto Location) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                        jdbc.setUrl(ConnectionFactory.getUrl());
                        jdbc.setUsername(ConnectionFactory.getUsername());
                        jdbc.setPassword(ConnectionFactory.getPassword());
                    jdbc.setCommand(Queries.DELETE_LOCATION);   
                    jdbc.setInt(1, Location.getLocation_id());
                    jdbc.execute();
                    return true;
                    }catch(Exception e){
                       e.printStackTrace();   
                        return false;
                    }
                   
            }


    public boolean insert_Location(LocationDto Location) {
        
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                    jdbc.setUrl(ConnectionFactory.getUrl());
                    jdbc.setUsername(ConnectionFactory.getUsername());
                    jdbc.setPassword(ConnectionFactory.getPassword());
                    jdbc.setCommand(Queries.INSER_NEW_LOCATION);
                    jdbc.setInt(1, Location.getLocation_id());
                    jdbc.setString(2, Location.getCode());
                    jdbc.setString(3, Location.getDescription());
                    jdbc.setInt(4, Location.getCapacity());
                    jdbc.execute(); 
                   
                    return true;
                }
                catch(java.sql.SQLIntegrityConstraintViolationException e ){
               //  JOptionPane.showMessageDialog(new DefineLocation(), "Unique Constrain Violated");
                  
                        }
            //     catch(java.sql.SQLException e){
              //     JOptionPane.showMessageDialog( new DefineLocation() , "Database Failed");
           //     }
                catch(Exception e){
                    e.printStackTrace();      
                }
        return false;    
    }

    public boolean Update_Location(LocationDto Location) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                    jdbc.setUrl(ConnectionFactory.getUrl());
                    jdbc.setUsername(ConnectionFactory.getUsername());
                    jdbc.setPassword(ConnectionFactory.getPassword());
                    
                    jdbc.setCommand(Queries.UPDATE_LOCATION);
                    
                    jdbc.setInt(4, Location.getLocation_id());
                    jdbc.setString(1, Location.getCode());
                    jdbc.setString(2, Location.getDescription());
                    jdbc.setInt(3, Location.getCapacity());
             //System.out.println("-------->"+Location.getLocation_id());
                    jdbc.execute();   
                    return true;  
                }
                catch(java.sql.SQLIntegrityConstraintViolationException e ){
                 JOptionPane.showMessageDialog(new DefineLocation(), "Unique Constrain Violated");
                  return false;
                        }
            //     catch(java.sql.SQLException e){
              //     JOptionPane.showMessageDialog( new DefineLocation() , "Database Failed");
           //     }
                catch(Exception e){
                   e.printStackTrace();   
                   return false;
               }

    }

    public boolean isExist(LocationDto Location) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_LOCATION_EXIST);
            jdbcRs.setString(1, Location.getCode());
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

    @Override
    public List<LocationDto> searchLocations(String code) {
        List<LocationDto> locations = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LOCATION_SEARCH);
            jdbcRs.setString(1, '%' + code.toLowerCase().trim() + '%');

            jdbcRs.execute();


            while (jdbcRs.next()) {
                if (locations == null)
                    locations = new ArrayList<>();

               LocationDto lSerch = new LocationDto();
                lSerch.setCode(jdbcRs.getString(2));
                lSerch.setLocation_id(jdbcRs.getInt(1));
                lSerch.setDescription(jdbcRs.getString(3));
                lSerch.setCapacity(jdbcRs.getInt(5));
                 
                locations.add(lSerch);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return locations;
    }
    
   // public List<LocationDto> filter(String LocationTypeCode,String BuildingCode){
        
        
     //   return 
  //  }
}
