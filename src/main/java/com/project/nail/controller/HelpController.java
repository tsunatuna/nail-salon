package com.project.nail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelpController {
		@RequestMapping(value="/help", method=RequestMethod.GET)
		public String help() {
			return "help";
		}

		@RequestMapping(value="/help/contract", method=RequestMethod.GET)
		public String contract() {
			return "contract";
		}

		@RequestMapping(value="/help/policy", method=RequestMethod.GET)
		public String policy() {
			return "policy";
		}

		@RequestMapping(value="/help/company", method=RequestMethod.GET)
		public String company() {
			return "company";
		}
}
