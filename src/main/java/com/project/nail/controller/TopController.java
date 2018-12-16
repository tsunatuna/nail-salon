package com.project.nail.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.nail.service.user.MyUserDetail;

@Controller
public class TopController {
		@RequestMapping(value="/", method=RequestMethod.GET)
		public String root(@AuthenticationPrincipal MyUserDetail userDetail) {
			return "top";
		}

		@RequestMapping(value="/top", method=RequestMethod.GET)
		public String index(@AuthenticationPrincipal MyUserDetail userDetail) {
			return "top";
		}
}
