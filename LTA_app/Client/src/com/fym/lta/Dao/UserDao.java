
package com.fym.lta.dao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dto.UserDto;

import java.util.List;

public interface UserDao {

    // this behavior to get all Users data

    public List<UserDto> getAll_Users();

    // this behavior to search for Users

    public List<UserDto> search_Users (UserDto user);

    // this behavior to delete User data
    public boolean delete_User(UserDto user);
    // chek if this data is Exists

    public boolean isExists(UserDto user);

    // this to  insert  User data

    public boolean insert_User(UserDto user)throws LTAException;

    // this behavior to update User data

    public boolean Update_User(UserDto user)throws LTAException;


}
