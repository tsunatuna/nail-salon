package com.project.nail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopController {
		@RequestMapping(value="/", method=RequestMethod.GET)
		public String root() {
			return "index";
		}

		@RequestMapping(value="/top", method=RequestMethod.GET)
		public String index() {
			return "index";
		}
}
