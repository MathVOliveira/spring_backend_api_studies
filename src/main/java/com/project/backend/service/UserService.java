package com.project.backend.service;

import com.project.backend.dto.UserDTO;
import com.project.backend.entities.UserEntity;
import com.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // tells spring that it is a service
public class UserService {

    @Autowired // dependencies injection (auto instantiation)
    private UserRepository userRepository;

    // READ
    public List<UserDTO> listAll() {
        // the DB return is a list of UserEntity
        List<UserEntity> users = userRepository.findAll();
        // converts UserEntity list to UserDTO list
        return users.stream().map(UserDTO::toUserDTO).toList();
    }

    // CREATE
    public void createUser(UserDTO user) {
        // instantiates a userEntity with UserDTO passed as parameter
        UserEntity userEntity = new UserEntity(user);
        userRepository.save(userEntity);
    }

    // UPDATE
    public UserDTO updateUser(UserDTO user) {
        UserEntity userEntity = new UserEntity(user);
        return UserDTO.toUserEntityWithPassword(userRepository.save(userEntity));
    }

    //DELETE
    public void deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
    }

    // FIND BY ID
    public UserDTO listUserById(Long id) {
        return UserDTO.toUserDTO(userRepository.findById(id).get());
    }
}
