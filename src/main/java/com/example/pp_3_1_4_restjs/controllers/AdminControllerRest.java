package com.example.pp_3_1_4_restjs.controllers;

import com.example.pp_3_1_4_restjs.models.User;
import com.example.pp_3_1_4_restjs.service.RoleServiceImpl;
import com.example.pp_3_1_4_restjs.service.UserService;
import com.example.pp_3_1_4_restjs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminControllerRest {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public AdminControllerRest(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> allUsersRest() {
        return new ResponseEntity<>(userServiceImpl.listUser(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<User> navBar() {
        return new ResponseEntity<>(userServiceImpl.findByUsername(userServiceImpl.getCurrentUsername()), HttpStatus.OK);
    }

    @PutMapping("/admin")
    public ResponseEntity<User> update(@RequestBody User user) {
        userServiceImpl.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("admin/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id) {
        userServiceImpl.removeUser(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/admin")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userServiceImpl.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


}
