package com.project.nail.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.nail.interfaces.ReserveBean;

@Controller
public class ReserveController {
	@RequestMapping(value="/reserve", method=RequestMethod.GET)
	public String reserve() {
		return "reserve";
	}

	@RequestMapping(value="/reserve/register", method=RequestMethod.POST)
	public ModelAndView  InsertReserve(@Valid @ModelAttribute ReserveBean reserveBean,  BindingResult result, ModelAndView mav) {
		if (result.hasErrors()) {
			//バインドエラー時
			mav.setViewName("error");
			return mav;
		}
		mav.setViewName("reserve");
		return mav;
	}
}
