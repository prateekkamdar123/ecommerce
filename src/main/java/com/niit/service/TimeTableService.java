package com.niit.service;

import java.util.List;

import com.niit.model.TimeTableModel;

public interface TimeTableService {
	
	public List<TimeTableModel> getFacultyTimeTable(int id);

}
