/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Course;
import com.group04.entities.Role;
import com.group04.entities.User;
import java.util.List;

/**
 *
 * @author HP
 */
public interface UserRepository {
    boolean checkLogin(String username, String password);
    User login(String username, String password);
    void register(User user);
    List<User> getAllUser();
    User getListUserHaveUsernameLike(String username);
    Role getRole(String id);
    void updateUser(User user);
    void deleteUser(Long id);
    User getUserById(Long userID);
    void updatePassword(String password, String newpassword);
    void SendMail(String email);
    void resetPassword(String usermail, String newpassword);
    boolean checkUsernameExist(String username);
}
