package com.example.pp_3_1_4_restjs.service;

import com.example.pp_3_1_4_restjs.models.Role;
import com.example.pp_3_1_4_restjs.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Collection<Role> getRoleList() {
        return roleRepository.findAll();
    }

    public Role getRoleById(int id) {
        return roleRepository.getReferenceById(id);
    }


}
