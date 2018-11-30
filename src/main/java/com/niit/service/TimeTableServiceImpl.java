package com.niit.service;

import java.util.List;

import com.niit.dao.TimeTableDao;
import com.niit.model.TimeTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("TimeTableService")
@Transactional
public class TimeTableServiceImpl implements TimeTableService{

	@Autowired
	TimeTableDao timeTableDao;
	
	public List<TimeTableModel> getFacultyTimeTable(int id) {
		return timeTableDao.getFacultyTimeTable(id);
	}

}
