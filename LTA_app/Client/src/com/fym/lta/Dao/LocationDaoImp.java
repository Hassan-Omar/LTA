package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.FloorDto;
import com.fym.lta.dto.LocationDto;
import com.fym.lta.dto.LocationTypeDto;
import com.fym.lta.dto.SlotDto;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class LocationDaoImp implements LocationDao {
    
    /*this function is to list all locations on the specific building , floor
     and has a specific type */
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
                     location.setCapacity(jdbc.getInt(4));
                     location.setStatus(jdbc.getString(5));
                     location.setFloor((new FloorDto(jdbc.getString("floor_code"),new BuildingDto(jdbc.getString("building_code")))));   
                      location.setType(new LocationTypeDto(jdbc.getString("type_code"))); 
                     location.setInsertedBy(jdbc.getString(9)); 
                     location.setInertion_Date(jdbc.getDate(10)); 
                     location.setUpdatedBy(jdbc.getString(11));    
                     location.setUpdate_Date(jdbc.getDate(12));     
                     locat.add(location);
                  }
              }
              catch(Exception e){
                  e.printStackTrace();      
              }
              
              return locat;
    }
 
       //this is to delete location using its ID
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

      /*this is to insert new location in a specific building and floor
      with specific location type*/
    public boolean insert_Location(LocationDto Location) {
        
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                    jdbc.setUrl(ConnectionFactory.getUrl());
                    jdbc.setUsername(ConnectionFactory.getUsername());
                    jdbc.setPassword(ConnectionFactory.getPassword());
                    jdbc.setCommand(Queries.INSER_NEW_LOCATION);

                    jdbc.setString(1, Location.getCode());
                    jdbc.setString(2, Location.getDescription());
                    jdbc.setInt(3, Location.getCapacity());
                    jdbc.setString(4, Location.getStatus());
                    jdbc.setInt(5, Location.getFloor().getFloor_id());
                    jdbc.setInt(6, Location.getType().getLocationType_id());
                    jdbc.setString(7, Location.getInsertedBy());
                    jdbc.setDate(8, new java.sql.Date(Location.getInertion_Date().getTime()));
                 
                    jdbc.execute(); 
                    return true;
                }
                catch(java.sql.SQLIntegrityConstraintViolationException e ){
               e.printStackTrace(); 
                        }
            //     catch(java.sql.SQLException e){
              //     JOptionPane.showMessageDialog( null , "Database Failed");
           //     }
                catch(Exception e){
                    e.printStackTrace();      
                }
        return false;    
    }
      
      //this is to update location
    public boolean Update_Location(LocationDto Location) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                    jdbc.setUrl(ConnectionFactory.getUrl());
                    jdbc.setUsername(ConnectionFactory.getUsername());
                    jdbc.setPassword(ConnectionFactory.getPassword());
                    
                    jdbc.setCommand(Queries.UPDATE_LOCATION);

                    jdbc.setString(1, Location.getDescription());
                    jdbc.setInt(2, Location.getCapacity());
                    jdbc.setString(3, Location.getStatus());
                    jdbc.setInt(4, Location.getFloor().getFloor_id());
                    jdbc.setInt(5, Location.getType().getLocationType_id());
                //    jdbc.setString(8, Location.getInsertedBy());
               //    jdbc.setDate(10, new java.sql.Date(Location.getInertion_Date().getTime()));
                     jdbc.setString(6, Location.getUpdatedBy());
                     jdbc.setDate(7, new java.sql.Date(Location.getUpdate_Date().getTime()));
                    jdbc.setInt(8, Location.getLocation_id());
                   
             //System.out.println("-------->"+Location.getLocation_id());
                    jdbc.execute();   
                    return true;  
                }
                catch(java.sql.SQLIntegrityConstraintViolationException e ){
                e.printStackTrace();
                  return false;
                        }
            //     catch(java.sql.SQLException e){
              //     JOptionPane.showMessageDialog( null , "Database Failed");
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
    
    //this is to search for location using code letters
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
                lSerch.setCapacity(jdbcRs.getInt(4));
                lSerch.setStatus(jdbcRs.getString(5));
                lSerch.setFloor((new FloorDto(jdbcRs.getString("floor_code"),new BuildingDto(jdbcRs.getString("building_code")))));   
                lSerch.setType(new LocationTypeDto(jdbcRs.getString("type_code"))); 
                lSerch.setInsertedBy(jdbcRs.getString(9)); 
                lSerch.setInertion_Date(jdbcRs.getDate(10)); 
                lSerch.setUpdatedBy(jdbcRs.getString(11));    
                lSerch.setUpdate_Date(jdbcRs.getDate(12));     
                 
                locations.add(lSerch);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return locations;
    }
    
    //this is to filter locations based on location type and building
    public List<LocationDto> filter(String LocationTypeCode,String BuildingCode){
        List<LocationDto> locations = null;
        
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LOCATION_FILTER);
            jdbcRs.setString(1, LocationTypeCode);
            jdbcRs.setString(2,  BuildingCode);                
            jdbcRs.execute();
            while (jdbcRs.next()) {
                if (locations == null)
                    locations = new ArrayList<>();
                LocationDto lFilter = new LocationDto();
                lFilter.setCode(jdbcRs.getString(2));
                lFilter.setLocation_id(jdbcRs.getInt(1));
                lFilter.setDescription(jdbcRs.getString(3));
                lFilter.setCapacity(jdbcRs.getInt(4));
                lFilter.setStatus(jdbcRs.getString(5));
                lFilter.setFloor((new FloorDto(jdbcRs.getString("floor_code"),new BuildingDto(jdbcRs.getString("building_code")))));   
                lFilter.setType(new LocationTypeDto(jdbcRs.getString("type_code"))); 
                lFilter.setInsertedBy(jdbcRs.getString(9)); 
                lFilter.setInertion_Date(jdbcRs.getDate(10)); 
                lFilter.setUpdatedBy(jdbcRs.getString(11));    
                lFilter.setUpdate_Date(jdbcRs.getDate(12));     
                 
                locations.add(lFilter);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return locations; 
    }
       
        //this to return a list of available Rooms at each department
    public List<LocationDto> getAvailableRoom(String code){
        List<LocationDto>  Availablelocat = null;
              try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet();) {
        jdbcRs.setUrl(ConnectionFactory.getUrl());
        jdbcRs.setUsername(ConnectionFactory.getUsername());
        jdbcRs.setPassword(ConnectionFactory.getPassword());
        jdbcRs.setCommand(Queries.AVAILABLE_ROOM);
                  System.out.println("       "+code) ;
        jdbcRs.setString(1, code);          
        jdbcRs.execute();
        while (jdbcRs.next()) {
            if (Availablelocat == null)
                Availablelocat = new ArrayList<>();
        LocationDto location = new LocationDto();
        location.setLocation_id(jdbcRs.getInt(1)); 
        // don't forget pref space  ,  ,, in slot    
            
            
        Availablelocat.add(location); 
        }
             for(int i=0 ; i<Availablelocat.size() ; i++)
             {        
        jdbcRs.setUrl(ConnectionFactory.getUrl());
        jdbcRs.setUsername(ConnectionFactory.getUsername());
        jdbcRs.setPassword(ConnectionFactory.getPassword());
        jdbcRs.setCommand(Queries.AVAILABLE_ROOM_SLOT);
        List<SlotDto> slots = null ; 
        jdbcRs.setInt(1, Availablelocat.get(i).getLocation_id());

        
        while (jdbcRs.next()) 
         {
            slots = new ArrayList<>();
            SlotDto slot = new SlotDto () ; 
            slot.setCode(jdbcRs.getString(1));
            slot.setSlot_id(jdbcRs.getInt(2));
            slots.add(slot);
         } 
          Availablelocat.get(i).setAssignedSlots(slots);
                 
                 }
             
              }
        
        catch(Exception e){
            e.printStackTrace();      
        }
        
        return Availablelocat;
        }

    @Override
    public boolean updateLocationSlot(LocationDto loc) {
       
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet();) {
        jdbcRs.setUrl(ConnectionFactory.getUrl());
        jdbcRs.setUsername(ConnectionFactory.getUsername());
        jdbcRs.setPassword(ConnectionFactory.getPassword());
        jdbcRs.setAutoCommit(false);
        List<SlotDto> slots  = loc.getAssignedSlots() ; 
        for(int i=0 ; i<slots.size() ; i++) {
            jdbcRs.setCommand(Queries.UPDATE_LOCATION_SLOT);
            jdbcRs.setInt(1, loc.getLocation_id());    
            jdbcRs.setString(2,loc.getAssignedSlots().get(i).getCode()) ; 
            jdbcRs.setInt(3, loc.getAssignedSlots().get(i).getSlot_id());    
            jdbcRs.execute();
        }
            jdbcRs.commit();
            
        }  catch (SQLException e) {
        }


        return false;
    }
}

