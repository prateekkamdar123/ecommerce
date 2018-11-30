package com.niit.dao;

import com.niit.model.FacultyModel;

import java.util.List;

public interface FacultyDao {

    List<FacultyModel> getAll();

    FacultyModel login(FacultyModel facultyModel);

    void update(FacultyModel facultyModel);

    List<FacultyModel> getAllFacultyDetails();

    boolean save(FacultyModel facultyModel);
}
