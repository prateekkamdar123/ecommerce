package com.niit.service;

import com.niit.model.FacultyModel;
import com.niit.model.TimeTableModel;

import java.util.List;

public interface FacultyService {

    List<FacultyModel> getAll();

    FacultyModel login(FacultyModel facultyModel);

    void updateProfile(FacultyModel facultyModel);

    void uploadTimeTable(List<TimeTableModel> ttlist, int id);

    List<TimeTableModel> getTimeTable(int id);

    List<TimeTableModel> checkTTofAllFaculty(String time);

    boolean save(FacultyModel facultyModel);
}
