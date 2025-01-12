package com.project.backend.controller;

import com.project.backend.dto.UserDTO;
import com.project.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> listAll() {
        return userService.listAll();
    }

    @PostMapping
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        // search about ResponseEntity<T>
        return ResponseEntity.ok().build();
    }

}
