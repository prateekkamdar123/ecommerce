package com.niit.service;

import com.niit.dao.FacultyDao;
import com.niit.dao.TimeTableDao;
import com.niit.model.FacultyModel;
import com.niit.model.TimeTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("FacultyService")
@Transactional
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    FacultyDao facultyDao;

    @Autowired
    TimeTableDao timeTableDao;

    public List<FacultyModel> getAll() {
        return facultyDao.getAll();
    }

    public FacultyModel login(FacultyModel facultyModel) {
        return facultyDao.login(facultyModel);
    }

    public void updateProfile(FacultyModel facultyModel) {
        facultyDao.update(facultyModel);
    }

    @Override
    public void uploadTimeTable(List<TimeTableModel> ttlist, int id) {

            List<TimeTableModel> existingTT=timeTableDao.getFacultyTimeTable(id);
            if(existingTT.size()>0){
                for(TimeTableModel tm:existingTT){
                    timeTableDao.delete(tm);
                }
                for(TimeTableModel tt:ttlist){
                    timeTableDao.saveTimeTable(tt);
                }
            }else{
                for(TimeTableModel tt:ttlist){
                    timeTableDao.saveTimeTable(tt);
                }
            }

    }

    @Override
    public List<TimeTableModel> getTimeTable(int id) {
        return timeTableDao.getFacultyTimeTable(id);
    }

    @Override
    public List<TimeTableModel> checkTTofAllFaculty(String time) {
        List<TimeTableModel> schedulelist=new ArrayList<TimeTableModel>();
        List<FacultyModel> facultyList=facultyDao.getAllFacultyDetails();
        for(FacultyModel model:facultyList) {
            List<TimeTableModel> ttlist=timeTableDao.getFacultyTimeTable(model.getId());

            for(TimeTableModel ttmodel:ttlist) {

                try {
                    String string1 = ttmodel.getStarttime();
                    Date inTime = new SimpleDateFormat("HH:mm").parse(string1);
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.setTime(inTime);

                    //Current Time
                    Date checkTime = new SimpleDateFormat("HH:mm").parse(time);
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.setTime(checkTime);

                    //End Time
                    String endtime=ttmodel.getEndtime();
                    Date finTime = new SimpleDateFormat("HH:mm").parse(endtime);
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTime(finTime);

                    Date x = calendar3.getTime();
                    if (endtime.compareTo(string1) < 0)
                    {
                        calendar2.add(Calendar.DATE, 1);
                        calendar3.add(Calendar.DATE, 1);
                    }

                    java.util.Date actualTime = calendar3.getTime();
                    if ((actualTime.after(calendar1.getTime()) ||
                            actualTime.compareTo(calendar1.getTime()) == 0) &&
                            actualTime.before(calendar2.getTime()))
                    {
                        schedulelist.add(ttmodel);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }
        return schedulelist;

    }

    @Override
    public boolean save(FacultyModel facultyModel) {
        return facultyDao.save(facultyModel);
    }
}
