package com.project.backend.dto;

import com.project.backend.entities.UserEntity;

public class UserDTO {

    private Long id;
    private String name;
    private String login;
    private String password;
    private String email;

    public UserDTO() { }

    private UserDTO(Long id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
    }

    private UserDTO(Long id, String name, String login, String password, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    // Entity to DTO
    public static UserDTO toUserDTO(UserEntity user) {
        // BeanUtils.copyProperties(user, this);
        return new UserDTO(user.getId(), user.getName(), user.getLogin(), user.getEmail());
    }

    public static UserDTO toUserEntityWithPassword(UserEntity user) {
        return new UserDTO(user.getId(), user.getName(), user.getLogin(), user.getPassword(), user.getEmail());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
