package com.hari.model;

public class StaffTotalAttendance {
	private Staff staff;
	private int totalPresentDays;
	private int totalAbsentDays;
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public int getTotalPresentDays() {
		return totalPresentDays;
	}
	public void setTotalPresentDays(int totalPresentDays) {
		this.totalPresentDays = totalPresentDays;
	}
	public int getTotalAbsentDays() {
		return totalAbsentDays;
	}
	public void setTotalAbsentDays(int totalAbsentDays) {
		this.totalAbsentDays = totalAbsentDays;
	}
	public StaffTotalAttendance(Staff staff, int totalPresentDays,
			int totalAbsentDays) {
		super();
		this.staff = staff;
		this.totalPresentDays = totalPresentDays;
		this.totalAbsentDays = totalAbsentDays;
	}
	public StaffTotalAttendance() {
		
	}
}
