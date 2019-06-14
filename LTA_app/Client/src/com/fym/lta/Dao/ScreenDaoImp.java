
package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.ScreenDto;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ScreenDaoImp implements ScreenDao {


    @Override
    public boolean insertScreenRoles(List<ScreenDto> screens, RoleDto role) throws LTAException {

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());


            for (int i = 0; i < screens.size(); i++) {

                if (is_ScreenRole_Exist(screens.get(i), role.getRole_id())) {
                    updateScreenRole(screens.get(i), role);
                } else {
                    jdbcRs.setCommand(Queries.ROLE_SCREEN_INSERT);
                    jdbcRs.setInt(1, role.getRole_id());
                    jdbcRs.setInt(2, screens.get(i).getScreen_id());
                    if (screens.get(i).getRole_Screen() != null)
                        jdbcRs.setInt(3, screens.get(i).getRole_Screen().getPermissionType());
                    else
                        jdbcRs.setNull(3, Types.INTEGER);
                    jdbcRs.execute();
                }

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public int getCurrentPermission(int roleID, int screenID) {
        int resultPermission = 0;
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.GET_CURRENT_PERMISSION);
            jdbcRs.setInt(1, roleID);
            jdbcRs.setInt(2, screenID);
            jdbcRs.execute();

            while (jdbcRs.next()) {
                resultPermission = jdbcRs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultPermission;
    }

    @Override
    public List<ScreenDto> list_Of_AavailableScreens(int roleID) {
        List<ScreenDto> screens = null;
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.GET_AVAILABLE_SCREENS);
            jdbcRs.setInt(1, roleID);
            jdbcRs.execute();

            while (jdbcRs.next()) {
                if (screens == null)
                    screens = new ArrayList<>();

                ScreenDto screen = new ScreenDto(jdbcRs.getInt(1));
                screens.add(screen);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return screens;
    }


    // check if the role To Screen is existe
    public boolean updateScreenRole(ScreenDto screen, RoleDto role) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.UPDATESCREEN_ROLE);

            int id = screen.getScreen_id();

            if (screen.getRole_Screen() != null)
                jdbcRs.setInt(1, screen.getRole_Screen().getPermissionType());
            else
                jdbcRs.setNull(1, Types.INTEGER);
            jdbcRs.setInt(2, role.getRole_id());
            jdbcRs.setInt(3, id);
            jdbcRs.execute();
            return true;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    // check if the role To Screen is existe
    public boolean is_ScreenRole_Exist(ScreenDto Screen, int roleID) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.SCREEN_ROLE_ISEXIST);
            jdbcRs.setInt(1, roleID);
            jdbcRs.setInt(2, Screen.getScreen_id());
            jdbcRs.execute();

            if (jdbcRs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean delete(int screenID, int roleID) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DELETE_SCREEN_ROLE);
            jdbcRs.setInt(1, screenID);
            jdbcRs.setInt(2, roleID);
            jdbcRs.execute();

            return true;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }


    @Override
    public List<ScreenDto> getAll_Screen(String roleCode) {
        List<ScreenDto> screens = null;
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_SCREEN);
            jdbcRs.setString(1, roleCode);
            jdbcRs.execute();
            while (jdbcRs.next()) {
                ScreenDto screen = new ScreenDto(jdbcRs.getInt(1));
                screen.setDescription(jdbcRs.getString(2));
                RoleDto role = new RoleDto(roleCode);
                role.setPermissionType(jdbcRs.getInt(3));
                screen.setRole_Screen(role);
                if (screens == null)
                    screens = new ArrayList<>();
                screens.add(screen);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return screens;
    }
}
