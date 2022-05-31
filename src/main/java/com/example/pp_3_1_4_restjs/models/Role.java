package com.example.pp_3_1_4_restjs.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@Table(name = "roles")
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}