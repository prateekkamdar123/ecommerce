package com.niit.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_admin_model")
public class AdminModel {
    private int id,status;
    private String username,password,createddate,email,phone;

    public AdminModel() {
    }

    public AdminModel(int id, int status, String username, String password, String createddate, String email, String phone) {
        this.id = id;
        this.status = status;
        this.username = username;
        this.password = password;
        this.createddate = createddate;
        this.email = email;
        this.phone = phone;
    }

    public AdminModel(int status, String username, String password, String createddate, String email, String phone) {
        this.status = status;
        this.username = username;
        this.password = password;
        this.createddate = createddate;
        this.email = email;
        this.phone = phone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "created_date")
    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
