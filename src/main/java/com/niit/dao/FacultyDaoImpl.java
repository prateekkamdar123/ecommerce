package com.niit.dao;

import com.niit.model.FacultyModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class FacultyDaoImpl implements FacultyDao{

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    HibernateTransactionManager transactionManager;

    public List<FacultyModel> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(FacultyModel.class).list();
    }

    public FacultyModel login(FacultyModel facultyModel) {
        Session session=sessionFactory.getCurrentSession();
        CriteriaBuilder builder =session.getCriteriaBuilder();
        CriteriaQuery<FacultyModel> query = builder.createQuery(FacultyModel.class);
        Root<FacultyModel> root = query.from(FacultyModel.class);
        query.select(root).where(builder.equal(root.get("username"), facultyModel.getUsername()));
        query.select(root).where(builder.equal(root.get("password"), facultyModel.getPassword()));
        query.select(root).where(builder.equal(root.get("status"), 1));
        Query<FacultyModel> q=session.createQuery(query);
        FacultyModel model=q.getSingleResult();
        return model;
    }

    public void update(FacultyModel facultyModel) {
        sessionFactory.getCurrentSession().update(facultyModel);
    }

    @Override
    public List<FacultyModel> getAllFacultyDetails() {
        return sessionFactory.getCurrentSession().createCriteria(FacultyModel.class).list();

    }

    @Override
    public boolean save(FacultyModel facultyModel) {
        boolean status=false;
        if(facultyModel!=null){
            sessionFactory.getCurrentSession().saveOrUpdate(facultyModel);
            status=true;
        }
        return status;
    }
}
