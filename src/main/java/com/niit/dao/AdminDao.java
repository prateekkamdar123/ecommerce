package com.niit.dao;

import com.niit.model.AdminModel;

import java.util.List;

public interface AdminDao {
    AdminModel login(AdminModel adminModel);

    List<AdminModel> getAll();
}
