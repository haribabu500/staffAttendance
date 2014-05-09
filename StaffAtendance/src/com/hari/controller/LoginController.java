package com.hari.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hari.model.Staff;
import com.hari.service.EasServiceManager;

@Controller
public class LoginController {
	@RequestMapping("login")
	public ModelAndView login(@ModelAttribute("staff")Staff staff,@RequestParam(value="invalid", required=false)String invalidMsg){
		ModelAndView mav=new ModelAndView("login");
		if(invalidMsg!=null){
			mav.addObject("invalid","invalid username or password!!!!");
			System.out.println("Wrong credentials...");
		}
		return mav;
	}
	@RequestMapping("validate")
	public ModelAndView validate(@ModelAttribute("staff")Staff staff){
		ModelAndView mav=new ModelAndView();
		System.out.println("entered==>. validation controller");
		List staffs=EasServiceManager.select("select s from Staff s", Staff.class);
		for (Object object : staffs) {
			Staff s=(Staff) object;
			System.out.println("---->>"+s.getUsernam()+" ==>>"+s.getPassword());
			if(s.getUsernam()!=null && s.getPassword()!=null){
				if(s.getUsernam().equals(staff.getUsernam())&&s.getPassword().equals(staff.getPassword())){
					mav.setViewName("redirect:home.htm");
					return mav;
				}
			}
		}
		mav.setViewName("redirect:login.htm");
		mav.addObject("invalid", "invalid");
		return mav;
	}
}
