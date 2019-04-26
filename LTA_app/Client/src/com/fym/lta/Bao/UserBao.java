package com.fym.lta.bao;

import com.fym.lta.dto.UserDto;

import java.util.List;

public interface UserBao {

    /**
     * insert new User if it doesn't exists
     * otherwise it updates the exis. once
     * if flag true operation will done on a staff member
     */
    public boolean insertUser(UserDto user);

    /**
     * Search for  Users . this return a list of users .
     */
    public List<UserDto> seachForUsers(UserDto user);
    
    /**
     *  this return a list of users .
     */
    public List<UserDto> listAll();

    /**
     * delete a User using id
     */
    public boolean deleteUser(UserDto user);
    
    
    public boolean updateUser(UserDto user);
}
