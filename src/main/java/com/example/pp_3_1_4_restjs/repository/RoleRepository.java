package com.example.pp_3_1_4_restjs.repository;

import com.example.pp_3_1_4_restjs.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
