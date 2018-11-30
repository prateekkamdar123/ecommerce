package com.niit.service;

import com.niit.dao.AdminDao;
import com.niit.model.AdminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service("AdminService")
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminDao adminDao;

    public boolean login(AdminModel adminModel) {
        boolean flag=false;
        AdminModel model=adminDao.login(adminModel);
        if(model!=null){
            flag=true;
        }
        return flag;
    }

    public List<AdminModel> getAll() {
        return adminDao.getAll();
    }
}
