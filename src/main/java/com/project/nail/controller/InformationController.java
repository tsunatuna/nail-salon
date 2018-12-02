package com.project.nail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InformationController {
		@RequestMapping(value="/information", method=RequestMethod.GET)
		public String information() {
			return "information";
		}
}
