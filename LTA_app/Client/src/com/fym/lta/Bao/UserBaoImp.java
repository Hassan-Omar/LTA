package com.fym.lta.bao;

import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.UserDao;
import com.fym.lta.common.LTAException;
import com.fym.lta.dto.UserDto;

import java.util.List;

public class UserBaoImp implements UserBao {
    UserDao userDaoObject = new DaoFactory().createUserDao();

    public UserBaoImp() {
        super();
    }

    @Override
    public boolean saveUser(UserDto user) throws LTAException 
    {

        // i will  check if the user is exist so i will update this user else i will insert new user
        boolean status = false;
        if (userDaoObject.isExists(user.getUserName())) 
        { 
                status = userDaoObject.updateUser(user);
            
        } else {
            
                status = userDaoObject.insert_User(user);
             
        }

        return status;
    }

    @Override
    public List<UserDto> listAll() { 
        
        return userDaoObject.getAll_Users();
    }

   // i will check if there are no data entered i will return all users
    @Override
    public List<UserDto> seachForUsers(String email) {
        
        if (email==null)
            return userDaoObject.getAll_Users() ; 
        
        return userDaoObject.search_Users(email);
    }

    @Override
    public boolean deleteUser(String email) {
      // delegate to dao method 
      return userDaoObject.delete_User(email);
    
    }


    // this method delegate the dao user to check if the entered password as same as  stored password
    public boolean checkLogin(String username, String password) {
        return userDaoObject.loginCheck(password,username );
    }


    @Override
    public boolean isExists(String username) {
        // delegate to dao method 
        return userDaoObject.isExists(username);
        
        
        
        
        
    }

    @Override
    public String getCurrentUserEmail(String username) {
        return userDaoObject.getCurrentUserEmail(username);
    }
}
