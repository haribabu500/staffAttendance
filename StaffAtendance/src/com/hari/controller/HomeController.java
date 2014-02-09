package com.hari.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hari.model.Staff;
import com.hari.service.EasServiceManager;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public ModelAndView home(){
		ModelAndView mav=new ModelAndView("/home");
		List staffs=EasServiceManager.select("select s from Staff s", Staff.class); 
		for (Object staff : staffs) {
//			System.out.println(staff);
		}
		String stafftable=EasServiceManager.getAttendanceStaffTable(staffs);
		mav.addObject("staffs", stafftable);
		return mav;
	}
	@RequestMapping("/submitAttendanceAction")
	public ModelAndView submitAttendanceAction(@RequestParam("attendance")String attendance){
		ModelAndView mav=new ModelAndView("/home");
		Map<Staff, String> attendances=new HashMap<Staff,String>();
//		System.out.println(attendance);
		String staffAttendance[]=attendance.split("\\$\\$");
		for (String string : staffAttendance) {
			String temp[]=string.split("@@");
			attendances.put(EasServiceManager.getSingleStaff(Integer.parseInt(temp[0])), temp[1]);
		}
		return null;
	}
}
