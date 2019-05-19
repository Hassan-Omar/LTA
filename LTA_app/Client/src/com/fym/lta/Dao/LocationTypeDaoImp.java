package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.LocationTypeDto;


import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class LocationTypeDaoImp implements LocationTypeDao {
/** get all location types  */
    public List<LocationTypeDto> getAll_LocationTypes() {
        List<LocationTypeDto> LocationTypes = null;
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_ALL_LOCATION_TYPES);
            jdbcRs.execute();

            LocationTypeDto LocationType = null;

            while (jdbcRs.next()) {
                if (LocationTypes == null)
                    LocationTypes = new ArrayList<>();
                LocationType = new LocationTypeDto();
                LocationType.setLocationType_id(jdbcRs.getInt(1));
                LocationType.setCode(jdbcRs.getString(8));
                LocationType.setDescription(jdbcRs.getString(3));
                
                
                LocationTypes.add(LocationType);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LocationTypes;
        }


/**insert location type  */
    public boolean insert_LocationType(LocationTypeDto LocationType)throws LTAException {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSER_NEW_LOCATION_TYPE);
            jdbcRs.setString(1, LocationType.getCode());
            jdbcRs.setString(2, LocationType.getDescription());
            
            if (LocationType.getUpdate_Date()!= null)
                jdbcRs.setDate(6, new java.sql.Date(LocationType.getUpdate_Date().getTime()));
            else
                jdbcRs.setNull(6, java.sql.Types.DATE);

            if (LocationType.getInertion_Date() != null)
                jdbcRs.setDate(5, new java.sql.Date(LocationType.getInertion_Date().getTime()));
            else
                jdbcRs.setNull(5, java.sql.Types.DATE);


            // check if the person who imserte  is not setted we we will set it empty
            if (LocationType.getInsertedBy() != null)
                jdbcRs.setString(3, LocationType.getInsertedBy());
            else
                jdbcRs.setNull(3, Types.VARCHAR);


            if (LocationType.getUpdatedBy() != null)
                jdbcRs.setString(4, LocationType.getUpdatedBy());
            else
                jdbcRs.setNull(4, Types.VARCHAR);


            jdbcRs.execute();

            return true;
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            LTAException ex = new LTAException();
            ex.setExactMessage("LocationType Already Exists!!!");
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
        }



    /**Delete location type  */
    public boolean delete_LocationType(LocationTypeDto LocationType) {
    try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
        jdbcRs.setUrl(ConnectionFactory.getUrl());
        jdbcRs.setUsername(ConnectionFactory.getUsername());
        jdbcRs.setPassword(ConnectionFactory.getPassword());
        jdbcRs.setCommand(Queries.DELETE_LOCATION_TYPE);
        jdbcRs.setString(1, LocationType.getCode());
        jdbcRs.execute();
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;

    }
    }
    
 /**Update location type  */
    public boolean Update_LocationType(LocationTypeDto LocationType) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.UPDATE_LOCATION_TYPE);
            jdbcRs.setString(1, LocationType.getDescription());
          
           if (LocationType.getUpdatedBy() != null)
                jdbcRs.setString(2, LocationType.getUpdatedBy());
            else
                jdbcRs.setNull(2, Types.VARCHAR);
            
            if (LocationType.getUpdate_Date() != null)
                jdbcRs.setDate(3, new java.sql.Date(LocationType.getUpdate_Date().getTime()));
            else
                jdbcRs.setNull(3, java.sql.Types.DATE);
            
            jdbcRs.setString(4, LocationType.getCode());

            jdbcRs.execute();
            return true;
        } 

        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        }

/**check if this Location type already exists or not!  */
    public boolean isExist(LocationTypeDto LocationType) {
    try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
        jdbcRs.setUrl(ConnectionFactory.getUrl());
        jdbcRs.setUsername(ConnectionFactory.getUsername());
        jdbcRs.setPassword(ConnectionFactory.getPassword());
        jdbcRs.setCommand(Queries.IS_LOCATION_TYPE_EXIST);
        jdbcRs.setString(1, LocationType.getCode());
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


    /**search LocationType  */
public List<LocationTypeDto> SearchLocationType(String Code){
    List<LocationTypeDto> LocationTypes = null;

    try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
        jdbcRs.setUrl(ConnectionFactory.getUrl());
        jdbcRs.setUsername(ConnectionFactory.getUsername());
        jdbcRs.setPassword(ConnectionFactory.getPassword());
        jdbcRs.setCommand(Queries.LOCATION_TYPE_SEARCH);
        jdbcRs.setString(1, '%' + Code.toLowerCase().trim() + '%');

        jdbcRs.execute();


        while (jdbcRs.next()) {
            if (LocationTypes == null)
                LocationTypes = new ArrayList<>();

            LocationTypeDto lSerch = new LocationTypeDto();
            lSerch.setCode(jdbcRs.getString(8));
            lSerch.setDescription(jdbcRs.getString(2));
           
          
        LocationTypes.add(lSerch);

        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return LocationTypes;


    }
}
    




