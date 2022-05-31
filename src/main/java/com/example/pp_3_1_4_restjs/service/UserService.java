package com.example.pp_3_1_4_restjs.service;

import com.example.pp_3_1_4_restjs.models.User;

import java.util.List;

public interface UserService {
    List<User> listUser ();
    User getUserById (int id);
    void addUser (User user);
    void removeUser (int id);
    void updateUser (User user);

}
