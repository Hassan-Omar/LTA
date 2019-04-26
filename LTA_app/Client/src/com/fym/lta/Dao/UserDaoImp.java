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
                user.setuser_Id(jdbcRs.getInt(13));
                user.setUserRole(new RoleDto(jdbcRs.getInt(3)));
                user.setFName(jdbcRs.getString(9));
                user.setSName(jdbcRs.getString(10));
                user.setLName(jdbcRs.getString(11));
                user.setFamilyName(jdbcRs.getString(12));
                user.setEmail(jdbcRs.getString(8));
                user.setUserName(jdbcRs.getString(1));
                users.add(user);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<UserDto> search_Users(UserDto user) {
        List<UserDto> users = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.USER_SEARCH);
            jdbcRs.setString(1, '%' + user.getEmail().toLowerCase().trim() + '%');

            jdbcRs.execute();


            while (jdbcRs.next()) {
                if (users == null)
                    users = new ArrayList<>();

                UserDto userSerch = new UserDto();
                userSerch.setuser_Id(jdbcRs.getInt(13));
                userSerch.setUserRole(new RoleDto(jdbcRs.getInt(3)));
                userSerch.setFName(jdbcRs.getString(9));
                userSerch.setSName(jdbcRs.getString(10));
                userSerch.setLName(jdbcRs.getString(11));
                userSerch.setFamilyName(jdbcRs.getString(12));
                userSerch.setEmail(jdbcRs.getString(8));
                userSerch.setUserName(jdbcRs.getString(1));
                users.add(userSerch);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }


    @Override
    public boolean delete_User(UserDto user) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DELETE_USER);
            jdbcRs.setInt(1, user.getuser_Id());
            jdbcRs.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isExists(UserDto user) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_USER_EXIST);
            jdbcRs.setString(1, user.getEmail());
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
    public boolean insert_User(UserDto user) throws LTAException {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSER_NEW_USER);


            jdbcRs.setString(1, user.getUserName()); //set username
            jdbcRs.setString(2, user.getPassword()); // setpassword

            jdbcRs.setInt(3, user.getUserRole().getRole_id()); // set it's role

            // check if the inserted date is not setted we we will set it
            if (user.getINSERTION_DATE() != null)
                jdbcRs.setDate(4, new java.sql.Date(user.getINSERTION_DATE().getTime()));
            else
                jdbcRs.setNull(4, java.sql.Types.DATE);

            // check if the update date is not setted we we will set it
            if (user.getUPDATE_DATE() != null)
                jdbcRs.setDate(5, new java.sql.Date(user.getUPDATE_DATE().getTime()));
            else
                jdbcRs.setNull(5, java.sql.Types.DATE);

            // check if the person who imserte  is not setted we we will set it empty
            if (user.getINSERTED_BY() != null)
                jdbcRs.setString(6, user.getINSERTED_BY());
            else
                jdbcRs.setNull(6, Types.VARCHAR);


            if (user.getUPDATED_BY() != null)
                jdbcRs.setString(7, user.getUPDATED_BY());
            else
                jdbcRs.setNull(7, Types.VARCHAR);

            // setting full name ,email
            jdbcRs.setString(8, user.getEmail());
            jdbcRs.setString(9, user.getFName());
            jdbcRs.setString(10, user.getSName());
            jdbcRs.setString(11, user.getLName());
            jdbcRs.setString(12, user.getFamilyName());


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
    public boolean Update_User(UserDto user) throws LTAException {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.UPDATE_USER);


            jdbcRs.setString(1, user.getUserName()); //put username to update it
            jdbcRs.setString(2, user.getPassword()); //put password to update it
            jdbcRs.setString(3, user.getEmail());
            jdbcRs.setInt(4, user.getUserRole().getRole_id());
            // putting the full name to update it
            // by logic i can not understantd  why i  need to update the name but i assumed that
            // one of names entered with error
            jdbcRs.setString(5, user.getFName());
            jdbcRs.setString(6, user.getSName());
            jdbcRs.setString(7, user.getLName());
            jdbcRs.setString(8, user.getFamilyName());
            if (user.getUPDATED_BY() != null)
                jdbcRs.setString(9, user.getUPDATED_BY());
            else
                jdbcRs.setNull(9, Types.VARCHAR);

            // check if the update date is not setted we we will set it
            if (user.getUPDATE_DATE() != null)
                jdbcRs.setDate(10, new java.sql.Date(user.getUPDATE_DATE().getTime()));
            else
                jdbcRs.setNull(10, java.sql.Types.DATE);

            jdbcRs.setInt(11, user.getuser_Id()); // this is a key we will use it to update

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
}
