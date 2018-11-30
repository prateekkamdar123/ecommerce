package com.niit.controller;


import com.niit.constants.UrlConstants;
import com.niit.constants.ViewConstants;
import com.niit.model.FacultyModel;
import com.niit.model.TimeTableModel;
import com.niit.service.FacultyService;
import com.niit.service.TimeTableService;
import com.niit.support.GeneralSupport;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @Autowired
    TimeTableService timeTableService;

    @RequestMapping(value = UrlConstants.USER_LOGIN,method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("faculty")FacultyModel facultyModel, RedirectAttributes attributes, HttpSession session){
        Map<String,Object> map=new HashMap<String, Object>();
        FacultyModel facultyModel1=facultyService.login(facultyModel);
        if(facultyModel1!=null) {
            map.put("faculty", facultyModel1);
            session.setAttribute("user", facultyModel1);
            return new ModelAndView(ViewConstants.USER_HOME,"data",map);
        }else{
            return new ModelAndView(ViewConstants.USER_LOGIN);
        }
    }

    @RequestMapping(value = UrlConstants.USER_UPDATE_PROFILE,method = RequestMethod.POST)
    public ModelAndView updateProfile(@ModelAttribute("faculty")FacultyModel facultyModel,RedirectAttributes attributes,HttpSession session){
        FacultyModel model= (FacultyModel) session.getAttribute("user");
        facultyModel.setId(model.getId());
        facultyModel.setAge(model.getAge());
        facultyModel.setBirthdate(model.getBirthdate());
        facultyModel.setCreateddate(model.getCreateddate());
        facultyModel.setEmail(model.getEmail());
        facultyModel.setFirstname(model.getFirstname());
        facultyModel.setGender(model.getGender());
        facultyModel.setLastname(model.getLastname());
        facultyModel.setMarried(model.getMarried());
        facultyModel.setPassword(model.getPassword());
        facultyModel.setPhone(model.getPhone());
        facultyModel.setUsername(model.getUsername());
        facultyModel.setStatus(model.getStatus());
        facultyService.updateProfile(facultyModel);
        return new ModelAndView(ViewConstants.USER_HOME);
    }

    @RequestMapping(value = "/updateprofile",method = RequestMethod.GET)
    public ModelAndView updateProfile1(@ModelAttribute("faculty")FacultyModel facultyModel,RedirectAttributes attributes,HttpSession session){
        FacultyModel faculty= (FacultyModel) session.getAttribute("user");
        ModelAndView model=new ModelAndView();
        model.addObject("faculty",faculty);
        model.setViewName("/user/updateprofile");
        return model;
    }

    @RequestMapping(value = "/uploadtimetable",method = RequestMethod.POST)
    public String uploadTimeTable(@ModelAttribute("faculty")FacultyModel facultyModel,@RequestParam("file") MultipartFile file,RedirectAttributes ra) throws IOException {
        int id=facultyModel.getId();
        List<TimeTableModel> ttlist=new ArrayList<TimeTableModel>();
        SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
        int i = 0;
        // Creates a workbook object from the uploaded excelfile
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        // Creates a worksheet object representing the first sheet
        XSSFSheet worksheet = workbook.getSheetAt(0);
        // Reads the data in excel file until last row is encountered
        while (i <= worksheet.getLastRowNum()) {
            // Creates an object for the UserInfo Model
            TimeTableModel model=new TimeTableModel();
            // Creates an object representing a single row in excel
            XSSFRow row = worksheet.getRow(i);
            // Sets the Read data to the model class
            model.setFacultyid(id);
            model.setClassnumber(String.valueOf(i));
            String timedata=row.getCell(1).getStringCellValue();
            String[] timearray=timedata.split("to");
            String starttime=timearray[0];
            String endtime=timearray[1];
            model.setStarttime(starttime);
            model.setEndtime(endtime);
            model.setMondaydetails(row.getCell(2).getStringCellValue());
            model.setTuesdaydetails(row.getCell(3).getStringCellValue());
            model.setWednesdaydetails(row.getCell(4).getStringCellValue());
            model.setThursdaydetails(row.getCell(5).getStringCellValue());
            model.setFridaydetails(row.getCell(6).getStringCellValue());
            model.setSaturdaydetails(row.getCell(7).getStringCellValue());
            model.setSundaydetails(row.getCell(8).getStringCellValue());
            model.setStatus("pending");
            model.setDatetime(GeneralSupport.getTimeStamp().toString());
            ttlist.add(model);
            i++;
        }
        facultyService.uploadTimeTable(ttlist,id);
        workbook.close();
        ra.addFlashAttribute("msg","Time Table Uploaded Successfully...!!!");
        return "redirect:/showtt";
    }

    @RequestMapping(value = "/showtt",method = RequestMethod.GET)
    public ModelAndView showTT(HttpServletRequest request,HttpSession session){
        FacultyModel facultyModel= (FacultyModel) session.getAttribute("user");
        int id=facultyModel.getId();
        Map<String,Object> map=new HashMap<>();
        List<TimeTableModel> ttlist=timeTableService.getFacultyTimeTable(id);
        map.put("ttlist",ttlist);
        return new ModelAndView(ViewConstants.SHOW_FACULTY_TT,"data",map);
    }





}
