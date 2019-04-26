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
    public boolean insertUser(UserDto user) {
        // i will  check if the user is exist so i will update this user else i will insert new user

        boolean statusOfInsertion = false;
        if (!userDaoObject.isExists(user)) {
            try {
                statusOfInsertion = userDaoObject.insert_User(user);
            } catch (LTAException e) {
                // not handeled
            }
        } else { return false;
            //report ui this user is exist
        }

        return statusOfInsertion;
    }
    
    @Override
    public List<UserDto> listAll()
    {// this means this is a user i  need to search for similar to it .
          return    userDaoObject.getAll_Users();
         }

    @Override
    public List<UserDto> seachForUsers(UserDto user) {


        return  userDaoObject.search_Users(user);
    }

    @Override
    public boolean deleteUser(UserDto user) {
        boolean deleteStatus;
        if (userDaoObject.isExists(user)) {
            deleteStatus = userDaoObject.delete_User(user);
        } else { //report this not found
            deleteStatus = false;
        }
        return deleteStatus;
    }

    @Override
    public boolean updateUser(UserDto user) {
        boolean statusOfUpdate = false;
        try {
            statusOfUpdate = userDaoObject.Update_User(user);
        } catch (LTAException e) {
        }
        return statusOfUpdate;
    }
}
