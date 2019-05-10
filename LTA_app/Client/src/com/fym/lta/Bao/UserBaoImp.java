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
    public boolean saveUser(UserDto user) {

        // i will  check if the user is exist so i will update this user else i will insert new user
        boolean status = false;
        if (userDaoObject.isExists(user.getUserName() , user.getEmail())) {
            try {
                status = userDaoObject.updateUser(user);
            } catch (LTAException e) {
                // not handeled we should move up to user
                e.printStackTrace();
            }
        } else {
            try {
                status = userDaoObject.insert_User(user);
            } catch (LTAException e) {
                // not handeled we should move up to user
                e.printStackTrace();
            }
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
    public boolean isUsernameExists(String username) {
        // delegate to dao method 
        return userDaoObject.isUsernameExists(username);
    }
}
