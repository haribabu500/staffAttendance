package com.hari.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hari.model.Schedule;
import com.hari.model.Staff;
import com.hari.model.StaffType;
import com.hari.service.EasServiceManager;

@Controller
public class AdministrationController {	
	private EntityManager entityManager=Persistence.createEntityManagerFactory("STAFF_ATTENDANCE").createEntityManager();
	@RequestMapping("administration/adminDashboard")
	public ModelAndView adminDashboard(){
		ModelAndView mav=new ModelAndView("administration/adminDashboard");
		return mav;	
	}
	@RequestMapping("administration/addStaff")
	public ModelAndView addStaff(@ModelAttribute("staff")Staff staff){
		ModelAndView mav=new ModelAndView("administration/addStaff");
		List<StaffType> types=entityManager.createQuery("select t from StaffType t",StaffType.class).getResultList();
		mav.addObject("types",types);
		return mav;
	}
	@RequestMapping("administration/addStaffAction")
	public ModelAndView addStaffAction(@ModelAttribute("staff")Staff staff){
		System.out.println("entered");
		ModelAndView mav=new ModelAndView("administration/addStaff");
		EasServiceManager.save(staff);
		return mav;
	}
	@RequestMapping("administration/removeStaff")
	public ModelAndView removeStaff(){
		ModelAndView mav=new ModelAndView("administration/removeStaff");
		List staffs=EasServiceManager.select("select s from Staff s", Staff.class);
		String resultTable=EasServiceManager.getRemoveStaffTable(staffs);
		mav.addObject("resultTable", resultTable);
		return mav;
	}
	@RequestMapping("administration/removeStaffAction")
	public ModelAndView removeStaffAction(@RequestParam("oid")String oid){
		ModelAndView mav=new ModelAndView("administration/removeStaff");
		EasServiceManager.remove(oid);
		return mav;
	}
	@RequestMapping("administration/viewStaff")
	public ModelAndView viewStaff(){
		ModelAndView mav=new ModelAndView("administration/viewStaff");
		List staffList=EasServiceManager.select("select s from Staff s", Staff.class);
		String resultTable=EasServiceManager.getStaffTable(staffList);
		mav.addObject("resultTable",resultTable);
		return mav;
	}
	@RequestMapping("administration/updateStaff")
	public ModelAndView updateStaff(@RequestParam(value="oid",required=false)String id,@ModelAttribute("staff")Staff staff){
		ModelAndView mav=new ModelAndView("administration/updateStaff");
		List staffList=EasServiceManager.select("select s from Staff s", Staff.class);
		String resultTable=EasServiceManager.getStaffTable(staffList);
		if(id!=null){
			staff=EasServiceManager.getSingleStaff(Integer.parseInt(id));
			mav.addObject("staff", staff);
			List<StaffType> types=entityManager.createQuery("select t from StaffType t",StaffType.class).getResultList();
			mav.addObject("types",types);
		}
		mav.addObject("resultTable",resultTable);
		return mav;
	}
	@RequestMapping("administration/updateStaffAction")
	public ModelAndView updateStaffAction(@ModelAttribute("staff")Staff staff){
		ModelAndView mav=new ModelAndView("administration/updateStaff");
		System.out.println(staff.getId());
		EasServiceManager.update(staff);
		System.out.println("entered"+staff.getContact());
		return mav;
	}
	@RequestMapping("administration/staffRoutine")
	public ModelAndView staffRoutine(@RequestParam("oid")String oid){
		ModelAndView mav=new ModelAndView("administration/staffRoutine");
		Staff staff= EasServiceManager.getSingleStaff(Integer.parseInt(oid));
		mav.addObject("staff", staff);
		Schedule schedule=staff.getSchedule();
		mav.addObject("schedule",schedule);
		return mav;
	}
	@RequestMapping("administration/addStaffRoutine")
	public ModelAndView addStaffRoutine(@RequestParam("oid")String oid,@ModelAttribute("schedule")Schedule schedule){
		ModelAndView mav=new ModelAndView("administration/addStaffRoutine");
		Staff staff= EasServiceManager.getSingleStaff(Integer.parseInt(oid));
		mav.addObject("staff", staff);
		if(staff.getSchedule()!=null)
		mav.addObject(staff.getSchedule());
		return mav;
	}
	@RequestMapping("administration/addStaffRoutineAction")
	public ModelAndView addStaffRoutineAction(@RequestParam("oid")String oid,@ModelAttribute("schedule")Schedule schedule){
		ModelAndView mav=new ModelAndView("administration/addStaffRoutineAction");
		System.out.println(oid+">>>>"+schedule.getSundayFrom()+">>"+schedule.getSundayTo());
		Staff staff= EasServiceManager.getSingleStaff(Integer.parseInt(oid));
		staff.setSchedule(schedule);
		EasServiceManager.update(staff);
//		mav.addObject("staff", staff);
		return mav;
	}
}
