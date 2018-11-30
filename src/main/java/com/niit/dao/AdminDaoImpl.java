package com.niit.dao;

import com.niit.model.AdminModel;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository("AdminDao")
public class AdminDaoImpl implements AdminDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTransactionManager transactionManager;


    public AdminModel login(AdminModel adminModel) {
        AdminModel model=(AdminModel) sessionFactory.getCurrentSession().createQuery("from AdminModel where Username='"+adminModel.getUsername()+"' and Password='"+adminModel.getPassword()+"'").uniqueResult();
        return model;
    }

    public List<AdminModel> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(AdminModel.class).list();
    }
}
