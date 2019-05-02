package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.ScreenDto;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ScreenDaoImp implements ScreenDao {


    @Override
    public boolean saveScreenRoles(List<ScreenDto> screens, RoleDto role) {

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());


            for (int i = 0; i < screens.size(); i++) {


                jdbcRs.setCommand(Queries.ROLE_SCREEN_INSERT);
                jdbcRs.setInt(1, role.getRole_id());
                jdbcRs.setInt(2, screens.get(i).getScreen_id());
                jdbcRs.setString(3, role.getPermission());
                jdbcRs.execute();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    // add is exist , update method


    @Override
    public String getCurrentPermission(int roleID, int screenID) {
        String resultPermission = null;
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.GET_CURRENT_PERMISSION);
            jdbcRs.setInt(1, roleID);
            jdbcRs.setInt(2, screenID);
            jdbcRs.execute();

            while (jdbcRs.next()) {
                resultPermission = jdbcRs.getString(1);
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
}
