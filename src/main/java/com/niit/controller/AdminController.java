package com.niit.controller;

import com.niit.constants.MessageConstant;
import com.niit.constants.UrlConstants;
import com.niit.constants.ViewConstants;
import com.niit.model.AdminModel;
import com.niit.model.FacultyModel;
import com.niit.model.TimeTableModel;
import com.niit.service.AdminService;
import com.niit.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = UrlConstants.ADMIN_LOGIN, method = RequestMethod.POST)
    public ModelAndView adminLogin(@ModelAttribute("admin") AdminModel adminModel, RedirectAttributes redirectAttributes, HttpSession session) {
        boolean flag = adminService.login(adminModel);
        Map<String, Object> map = new HashMap<String, Object>();
        if (flag == true) {
            session.setAttribute("adminSession", adminModel);
            ModelAndView model=new ModelAndView();
            model.addObject("faculty",new FacultyModel());
            map.put("facultyList", facultyService.getAll());
            model.addObject("data",map);
            model.setViewName(ViewConstants.SHOW_FACULTY);
            redirectAttributes.addFlashAttribute("msg", MessageConstant.ADMINLOGIN_SUCCESS);
            return model;
        } else {
            redirectAttributes.addFlashAttribute("msg", MessageConstant.ADMINLOGIN_FAIL);
            return new ModelAndView(ViewConstants.ADMIN_LOGIN);
        }
    }

    @RequestMapping(value = "/showtimetable", method = RequestMethod.GET)
    public ModelAndView showTT(HttpServletRequest request, HttpSession session) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<TimeTableModel> ttlist = facultyService.getTimeTable(id);
        Map<String, Object> map = new HashMap<>();
        map.put("ttlist", ttlist);
        return new ModelAndView(ViewConstants.SHOW_TIMETABLE, "data", map);
    }

   /* @RequestMapping(value = "/freeslot", method = RequestMethod.POST)
    public ModelAndView freeSlot(@ModelAttribute("faculty") FacultyModel facultyModel, HttpServletRequest request, HttpSession session) {
        String time=request.getParameter("time");
        List<TimeTableModel> ttlist=facultyService.checkTTofAllFaculty(time);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("ttdata", ttlist);
        return new ModelAndView(ViewConstants.FREE_SLOT,"data",map);
    }*/

    @RequestMapping(value = "/addfaculty",method = RequestMethod.GET)
    public ModelAndView add(ModelAndView model){
        model.addObject("faculty",new FacultyModel());
        model.setViewName(ViewConstants.ADD_FACULTY);
        return model;
    }

    @RequestMapping(value = "/savefaculty",method = RequestMethod.GET)
    public ModelAndView save(@ModelAttribute("faculty")FacultyModel facultyModel){
        Map<String,Object> map=new HashMap<>();
        boolean status=facultyService.save(facultyModel);
        if(status==true){
            map.put("facultyList",facultyService.getAll());
            return new ModelAndView(ViewConstants.SHOW_FACULTY,"data",map);
        }else {
            return new ModelAndView(ViewConstants.ADD_FACULTY);
        }
    }
}
