package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.UserDto;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class UserDaoImp implements UserDao {


    public UserDaoImp() {
        super();
    }

    @Override
    public List<UserDto> getAll_Users() {

        List<UserDto> users = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_ALL_USER);
            jdbcRs.execute();

            UserDto user = null;
      
            while (jdbcRs.next()) {
                if (users == null)
                    users = new ArrayList<>();
                user = new UserDto();
                // getting the full name 
                user.setFName(jdbcRs.getString(1));
                user.setSName(jdbcRs.getString(2));
                user.setLName(jdbcRs.getString(3));
                user.setFamilyName(jdbcRs.getString(4));
                
    
                user.setUserName(jdbcRs.getString(5));
                user.setEmail(jdbcRs.getString(10));
                
                // getting the historical data
                user.setInertion_Date(jdbcRs.getDate(6));
                user.setUpdate_Date(jdbcRs.getDate(7));
                user.setInsertedBy(jdbcRs.getString(8));
                user.setUpdatedBy(jdbcRs.getString(9));
               
               // getting it's role 
                user.setUserRole(new RoleDto(jdbcRs.getString(11)));
               
                users.add(user);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<UserDto> search_Users(String email) {
        List<UserDto> users = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.USER_SEARCH);
            jdbcRs.setString(1, '%' + email.toLowerCase().trim() + '%');

            jdbcRs.execute();


            while (jdbcRs.next()) {
                if (users == null)
                    users = new ArrayList<>();

                UserDto userSerch = new UserDto();
              
                // getting the full name 
                userSerch.setFName(jdbcRs.getString(1));
                userSerch.setSName(jdbcRs.getString(2));
                userSerch.setLName(jdbcRs.getString(3));
                userSerch.setFamilyName(jdbcRs.getString(4));
                
                
                userSerch.setUserName(jdbcRs.getString(5));
                userSerch.setEmail(jdbcRs.getString(10));
                
                // getting the historical data
                userSerch.setInertion_Date(jdbcRs.getDate(6));
                userSerch.setUpdate_Date(jdbcRs.getDate(7));
                userSerch.setInsertedBy(jdbcRs.getString(8));
                userSerch.setUpdatedBy(jdbcRs.getString(9));
                
                // getting it's role
                userSerch.setUserRole(new RoleDto(jdbcRs.getString(11)));
                users.add(userSerch);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }


    @Override
    public boolean delete_User(String email) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DELETE_USER);
            jdbcRs.setString(1, email);
            jdbcRs.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isExists(String username , String  email)
    {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_USER_EXIST);
            jdbcRs.setString(1,  email );
            jdbcRs.setString(2,  username );
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

    @Override
    public boolean insert_User(UserDto user) throws LTAException {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) 
        {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSER_NEW_USER);
           
           
            jdbcRs.setString(1, user.getUserName()); //set username
            jdbcRs.setString(2, user.getPassword()); // setpassword

            jdbcRs.setInt(3,user.getUserRole().getRole_id()); // set it's role

            // check if the inserted date is not setted we we will set it
            if (user.getInertion_Date() != null)
                jdbcRs.setDate(4, new java.sql.Date(user.getInertion_Date().getTime()));
            else
                jdbcRs.setNull(4, java.sql.Types.DATE);

            // check if the update date is not setted we we will set it
            if (user.getUpdate_Date() != null)
                jdbcRs.setDate(5, new java.sql.Date(user.getUpdate_Date().getTime()));
            else
                jdbcRs.setNull(5, java.sql.Types.DATE);

            // check if the person who imserte  is not setted we we will set it empty
            if (user.getInsertedBy()!= null)
                jdbcRs.setString(6, user.getInsertedBy());
            else
                jdbcRs.setNull(6, Types.VARCHAR);


            if (user.getUpdatedBy() != null)
                jdbcRs.setString(7, user.getUpdatedBy());
            else
                jdbcRs.setNull(7, Types.VARCHAR);

            // setting email
            jdbcRs.setString(8, user.getEmail());
           
            // setting EMP_ID
            jdbcRs.setInt(9, user.getUser_Employee().getEmp_id() );

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

    @Override
    public boolean updateUser(UserDto user) throws LTAException {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.UPDATE_USER);


            jdbcRs.setString(1, user.getUserName()); //put username to update it
            jdbcRs.setString(2, user.getPassword()); //put password to update it
            jdbcRs.setInt(3,user.getUserRole().getRole_id());
            // putting the full name to update it
            // by logic i can not understantd  why i  need to update the name but i assumed that
            // one of names entered with error
            if (user.getUpdatedBy() != null)
                jdbcRs.setString(4, user.getUpdatedBy());
            else
                jdbcRs.setNull(4, Types.VARCHAR);

            // check if the update date is not setted we we will set it
            if (user.getUpdate_Date() != null)
                jdbcRs.setDate(5, new java.sql.Date(user.getUpdate_Date().getTime()));
            else
                jdbcRs.setNull(5, java.sql.Types.DATE);

            jdbcRs.setString(6, user.getEmail()); // this is a key we will use it to update

            jdbcRs.execute();
            return true;
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            LTAException ex = new LTAException();
            ex.setExactMessage("Error in Update May be not exist !");
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean loginCheck(String password, String username) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LOGIN_CHECK);
            jdbcRs.setString(1,username);
            jdbcRs.setString(2,password); 
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

    @Override
    public boolean isUsernameExists(String username) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_USERNAME_EXIST);
            jdbcRs.setString(1,username);
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
}
