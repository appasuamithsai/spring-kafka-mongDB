package com.amith.librarymanagementsystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class User {
    @Id
    private int id;

    @Field(name = "name")
    private String userName;
    @Field(name = "role")
    private String userRole;
    @Field(name = "password")
    private String password;

    public User(){}
    @PersistenceConstructor
    public User(int id, String userName, String userRole, String password) {
        this.id = id;
        this.userName = userName;
        this.userRole = userRole;
        this.password = password;
    }

    public User(String userName, String userRole, String password) {
        this.userName = userName;
        this.userRole = userRole;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
