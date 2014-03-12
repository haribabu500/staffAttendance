package com.hari.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hari.model.Attendance;
import com.hari.model.Staff;
import com.hari.model.StaffTotalAttendance;
import com.hari.report.CreateReport;
import com.hari.report.DynamicReportTest;
import com.hari.report.SingleStaffReport;
import com.hari.service.EasServiceManager;

@Controller
public class ReportController {
	@RequestMapping("reports/staffReport")
	public ModelAndView staffReport(){
		ModelAndView mav=new ModelAndView("reports/staffReport");
		SingleStaffReport obj=new SingleStaffReport();
		obj.getStaffData();
		
		
		List<StaffTotalAttendance> staffTotalAttendances=new ArrayList<StaffTotalAttendance>();
		List staffs=EasServiceManager.select("select s from Staff s", Staff.class);
		for (Object object : staffs) {
			Staff staff=(Staff) object;
			List list=EasServiceManager.select("select a from Attendance a where a.staff.firstName='"+staff.getFirstName()+"'", Attendance.class);
			System.out.println(list.size());
			List present=EasServiceManager.select("select a from Attendance a where a.staff.firstName='"+staff.getFirstName()+"' and a.status='P'", Attendance.class);
			List absent=EasServiceManager.select("select a from Attendance a where a.staff.firstName='"+staff.getFirstName()+"' and a.status='A'", Attendance.class);
			System.out.println(list.size()+"::"+present.size()+"::::"+absent.size());
			StaffTotalAttendance staffTotalAttendance=new StaffTotalAttendance(staff, present.size(), absent.size());
			staffTotalAttendances.add(staffTotalAttendance);
		}
		DynamicReportTest dynamicReportTest=new DynamicReportTest(staffTotalAttendances);
		return mav;
	}
}
