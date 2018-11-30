package com.niit.service;

import com.niit.model.AdminModel;

import java.util.List;

public interface AdminService {
    boolean login(AdminModel adminModel);

    List<AdminModel> getAll();
}
