package com.niit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.niit.model.TimeTableModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;


@Repository
public class TimeTableDAOImpl implements TimeTableDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HibernateTransactionManager txManager;

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<TimeTableModel> getFacultyTimeTable(int id) {
		List<TimeTableModel> ttList=sessionFactory.getCurrentSession().createQuery("from TimeTableModel where facultyid="+id).getResultList();
		return ttList;
	}

	@Override
	public void saveTimeTable(TimeTableModel model) {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void delete(TimeTableModel tm) {
		sessionFactory.getCurrentSession().delete(tm);
	}

}
