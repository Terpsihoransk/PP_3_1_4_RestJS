package com.example.pp_3_1_4_restjs.service;

import com.example.pp_3_1_4_restjs.models.Role;

import java.util.Collection;

public interface RoleService {

    Collection<Role> getRoleList(); // через list, исключив из html, чтобы была расширяемость
    Role getRoleById(int id);



}
