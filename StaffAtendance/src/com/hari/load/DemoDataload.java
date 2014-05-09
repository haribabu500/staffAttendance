package com.hari.load;

import java.util.Date;

import com.hari.model.Attendance;
import com.hari.model.Staff;
import com.hari.service.EasServiceManager;

public class DemoDataload {
	public static void main(String[] args) {
		int arr[]={251,252,253,254,255,256,257,551};
		int n=0;
		for (int i = 0; i < arr.length; i++) {
			Staff staff=EasServiceManager.getSingleStaff(arr[i]);
			for(int j=1;j<=12;j++){
				for(int k=1;k<=30;k++){
					Attendance attendance=new Attendance();
					Date date=new Date(2013, j, k);
					attendance.setDate(date);
					attendance.setStaff(staff);
					char status;
					int random=(int)(Math.random()*10);	
					if(random%2==0)
						status='P';
					else
						status='A';
					attendance.setStatus(status);
					n++;
					EasServiceManager.save(attendance);
					System.out.println("Done==>"+staff.getFirstName()+" "+staff.getLastName()+"==>>"+date+"==>"+status+"======"+n);
				}
			}
		}
		
	}
}
