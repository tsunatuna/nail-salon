package com.project.nail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DesignController {
		@RequestMapping(value="/design", method=RequestMethod.GET)
		public String design() {
			return "design";
		}
}
