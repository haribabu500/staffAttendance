package com.hari.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hari.model.Staff;
import com.hari.model.StaffType;
import com.hari.service.EasServiceManager;

@Controller
public class AdministrationController {
	private EntityManager entityManager=Persistence.createEntityManagerFactory("STAFF_ATTENDANCE").createEntityManager();
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
}
