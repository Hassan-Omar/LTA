package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.ScreenDto;

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
                    return true ;
                } catch (Exception e) {
            e.printStackTrace();
            }
          // return true ; 



        return false;
    }
    
    
    // add is exist , update method , another method which return a list of screen on role 
    
    
    
}
