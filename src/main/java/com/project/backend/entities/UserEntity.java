package com.project.backend.entities;

import com.project.backend.dto.UserDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity // hibernate reads this to create an entity in a DB
@Table(name = "mvo_user") // appoints the table in a DB, without this, the table receive the name of the Class
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // similar to autoincrement of a DB
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;

    // DTO to Entity
    public UserEntity(UserDTO user) {
        BeanUtils.copyProperties(user, this);
    }

    public UserEntity() { }

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        UserEntity that = (UserEntity) obj;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}