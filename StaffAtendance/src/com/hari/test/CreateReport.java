package com.hari.test;

import com.hari.model.Staff;
import com.hari.model.StaffTotalAttendance;

public class CreateReport {

	public static void main(String[] args) {
		DynamicReportTest report=new DynamicReportTest();
		StaffTotalAttendance[] staffTotalAttendances=new StaffTotalAttendance[5];
		for (int i = 0; i < staffTotalAttendances.length; i++) {
			Staff staff=new Staff();
			staff.setFirstName("Hari"+i);
			staff.setLastName("Shrestha");
			staffTotalAttendances[i]=new StaffTotalAttendance(staff, i*10, i);
		}
		report.setStaffTotalAttendances(staffTotalAttendances);
		report.build();
	}

}
