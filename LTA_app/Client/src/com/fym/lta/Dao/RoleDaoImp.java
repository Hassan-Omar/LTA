package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.RoleDto;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RoleDaoImp implements RoleDao {
    public List<RoleDto> getAll_Roles() {

        List<RoleDto> roles = null;
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_ALL_ROLES);
            jdbcRs.execute();
            roles = new ArrayList<>();
            RoleDto role = null;
            while (jdbcRs.next()) {

                role = new RoleDto(jdbcRs.getString(2));
                role.setDescription(jdbcRs.getString(3));
                role.setRole_id(jdbcRs.getInt(1));

                role.setInsertedBy(jdbcRs.getString(4));
                role.setUpdatedBy(jdbcRs.getString(7));
                role.setInertion_Date(jdbcRs.getDate(5));
                role.setUpdate_Date(jdbcRs.getDate(6));
                roles.add(role);
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    public boolean delete_Role(String code) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DELETE_ROLE);
            jdbcRs.setString(1, code);
            jdbcRs.execute();
            return true;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean insert_Role(RoleDto role)throws LTAException
    {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSER_NEW_ROLE);
            jdbcRs.setString(1, role.getCode());
            jdbcRs.setString(2, role.getDescription());


            // check if the person who inserte  is not setted we we will set it empty
            if (role.getInsertedBy() != null)
                jdbcRs.setString(3, role.getInsertedBy());
            else
                jdbcRs.setNull(3, Types.VARCHAR);

            if (role.getUpdatedBy() != null)
                jdbcRs.setString(4, role.getUpdatedBy());
            else
                jdbcRs.setNull(4, Types.VARCHAR);

            // check if the inserted date is not setted we we will set it
            if (role.getInertion_Date() != null)
                jdbcRs.setDate(5, new java.sql.Date(role.getInertion_Date().getTime()));
            else
                jdbcRs.setNull(5, java.sql.Types.DATE);

            // check if the update date is not setted we we will set it
            if (role.getUpdate_Date() != null)
                jdbcRs.setDate(6, new java.sql.Date(role.getUpdate_Date().getTime()));
            else
                jdbcRs.setNull(6, java.sql.Types.DATE);


            jdbcRs.execute();
            return true;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean Update_Role(RoleDto role) throws LTAException {

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.UPDATE_ROLE);

            jdbcRs.setString(1, role.getDescription());

            if (role.getUpdatedBy() != null)
                jdbcRs.setString(2, role.getUpdatedBy());
            else
                jdbcRs.setNull(2, Types.VARCHAR);

            // check if the update date is not setted we we will set it
            if (role.getUpdate_Date() != null)
                jdbcRs.setDate(3, new java.sql.Date(role.getUpdate_Date().getTime()));
            else
                jdbcRs.setNull(3, java.sql.Types.DATE);

            jdbcRs.setString(4, role.getCode());

            jdbcRs.execute();

            return true;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isExist(String code) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_ROLE_EXIST);
            jdbcRs.setString(1, code);
            jdbcRs.execute();
            while (jdbcRs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<RoleDto> search_forRole(String code) {
        List<RoleDto> roles = null;
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.ROLE_SEARCH);
            jdbcRs.setString(1, "%" + code.toLowerCase() + "%");
            jdbcRs.execute();
            RoleDto role = null;
            while (jdbcRs.next()) {
                roles = new ArrayList<>();

                role = new RoleDto(jdbcRs.getString(1));
                role.setDescription(jdbcRs.getString(2));
                role.setRole_id(jdbcRs.getInt(3));

                roles.add(role);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public int getCurrenRoleID(String username) {
        int roleID = 0;
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.CURRENT_ROLE);
            jdbcRs.setString(1, username);
            jdbcRs.execute();

            while (jdbcRs.next()) {
                roleID = jdbcRs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleID;

    }
}
