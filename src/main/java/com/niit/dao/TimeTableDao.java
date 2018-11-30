package com.niit.dao;

import java.util.List;

import com.niit.model.TimeTableModel;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface TimeTableDao {
	
	public List<TimeTableModel> getFacultyTimeTable(int id);

	public void saveTimeTable(TimeTableModel model);

    void delete(TimeTableModel tm);
}
