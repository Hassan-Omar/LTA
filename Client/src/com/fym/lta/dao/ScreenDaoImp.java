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
    public boolean insertScreenRoles(List<ScreenDto> screens, RoleDto role) {

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());


            for (int i = 0; i < screens.size(); i++) {

                if (is_ScreenRole_Exist(screens.get(i) ,role.getRole_id()))
                { 
                 updateScreenRole(screens.get(i) ,role);
                }
                else {
                jdbcRs.setCommand(Queries.ROLE_SCREEN_INSERT);
                jdbcRs.setInt(1, role.getRole_id());
                jdbcRs.setInt(2, screens.get(i).getScreen_id());
                    
                if (i<7 && role.getPermissions().get(0)!=null)
                    jdbcRs.setString(3, role.getPermissions().get(0));
                if (i>6&&i<9&&(role.getPermissions().get(1)!=null) )
                    jdbcRs.setString(3, role.getPermissions().get(1));
                if (i>8&&i<12 &&(role.getPermissions().get(2)!=null))
                    jdbcRs.setString(3, role.getPermissions().get(2));
                if (i>11&& role.getPermissions().get(3)!= null)
                    jdbcRs.setString(3, role.getPermissions().get(3));

                    
                
                jdbcRs.execute();
            }
         
               }
      return true;  } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


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

    // check if the role To Screen is existe 
    public boolean isScreenRole_Exist(ScreenDto Screen, int roleID)
    {
            try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
                jdbcRs.setUrl(ConnectionFactory.getUrl());
                jdbcRs.setUsername(ConnectionFactory.getUsername());
                jdbcRs.setPassword(ConnectionFactory.getPassword());
                jdbcRs.setCommand(Queries.SCREEN_ROLE_ISEXIST);
                jdbcRs.setInt(1, roleID);
                jdbcRs.setInt(2 ,Screen.getScreen_id());
                jdbcRs.execute();
                if(jdbcRs.next())
                {
                    return true ;
                 }
                
            } catch(Exception e)
            {
                e.printStackTrace();
                }
        return false ;
        
        }
    
    // check if the role To Screen is existe 
    public boolean updateScreenRole(ScreenDto screen, RoleDto role)
    {
            try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
                jdbcRs.setUrl(ConnectionFactory.getUrl());
                jdbcRs.setUsername(ConnectionFactory.getUsername());
                jdbcRs.setPassword(ConnectionFactory.getPassword());
                jdbcRs.setCommand(Queries.UPDATESCREEN_ROLE);

                int id  =  role.getRole_id() ; 
                if (id<7 && role.getPermissions().get(0)!=null)
                    jdbcRs.setString(3, role.getPermissions().get(0));
                if (id>6&&id<9&&(role.getPermissions().get(1)!=null) )
                    jdbcRs.setString(3, role.getPermissions().get(1));
                if (id>8&&id<12 &&(role.getPermissions().get(2)!=null))
                    jdbcRs.setString(3, role.getPermissions().get(2));
                if (id>11&& role.getPermissions().get(3)!= null)
                    jdbcRs.setString(3, role.getPermissions().get(3));


                jdbcRs.setInt(2,id );
                jdbcRs.setInt(3,screen.getScreen_id());
                jdbcRs.execute();
                if(jdbcRs.next())
                {
                    return true ;
                 }
                
            } catch(Exception e)
            {
                e.printStackTrace();
                }
        return false ;
        
        }
 
    // check if the role To Screen is existe 
    public boolean is_ScreenRole_Exist(ScreenDto Screen, int roleID)
    {
            try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
                jdbcRs.setUrl(ConnectionFactory.getUrl());
                jdbcRs.setUsername(ConnectionFactory.getUsername());
                jdbcRs.setPassword(ConnectionFactory.getPassword());
                jdbcRs.setCommand(Queries.SCREEN_ROLE_ISEXIST);
                jdbcRs.setInt(1, roleID);
                jdbcRs.setInt(2 ,Screen.getScreen_id());
                jdbcRs.execute();
                
                if(jdbcRs.next())
                {
                  return true ;
                }
                
                } catch(Exception e)
                {
                e.printStackTrace();
                }
        return false ;
        
        }
   
}
