package com.hari.report;

import java.util.ArrayList;
import java.util.List;

import com.hari.model.Attendance;
import com.hari.model.Staff;
import com.hari.model.StaffTotalAttendance;
import com.hari.service.EasServiceManager;

public class CreateReport {

	public static void main(String[] args) {
		System.out.println("-----begin--------------");
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
//		List list=EasServiceManager.select("select a from Attendance a where a.staff.firstName='hari'", Attendance.class);
//		System.out.println(list.size());
//		List present=EasServiceManager.select("select a from Attendance a where a.staff.firstName='hari' and a.status='P'", Attendance.class);
//		List absent=EasServiceManager.select("select a from Attendance a where a.staff.firstName='hari' and a.status='A'", Attendance.class);
//		System.out.println(list.size()+"::"+present.size()+"::::"+absent.size());
//		for (int i = 0; i < list.size(); i++) {
//			Staff staff=((Attendance)list.get(0)).getStaff();
//			int p=present.size();
//			int a=absent.size();
//			
//			staffTotalAttendances.add(new StaffTotalAttendance(staff, p, a));
//		}
		DynamicReportTest report=new DynamicReportTest(staffTotalAttendances);
		
//		List<StaffTotalAttendance> staffTotalAttendances=new ArrayList<StaffTotalAttendance>();
//		for (int i = 0; i < staffTotalAttendances.size(); i++) {
//			Staff staff=new Staff();
//			staff.setFirstName("Hari"+i);
//			staff.setLastName("Shrestha");
//			staffTotalAttendances.add(new StaffTotalAttendance(staff, i*10, i));
//		}
//		DynamicReportTest report=new DynamicReportTest(staffTotalAttendances);
	}

}
