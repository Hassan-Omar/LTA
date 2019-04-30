
package com.fym.lta.dao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dto.UserDto;

import java.util.List;

public interface UserDao {

    // this behavior to get all Users data
    public List<UserDto> getAll_Users();

    // this behavior to search for Users
    public List<UserDto> search_Users(String email);

    // this behavior to delete User data
    public boolean delete_User(String email);

    // this method to check if the user exist or not
    public boolean isExists(String username ,String email);

    // this to  insert  User data
    public boolean insert_User(UserDto user) throws LTAException;

    // update user data
    public boolean updateUser(UserDto user) throws LTAException;

    // method to check if the entered user and pass is correct
    public boolean loginCheck(String password, String username);
    
    // this method to check if the username logged is  right exist
    public boolean isUsernameExists(String username );

}
