package com.project.nail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
		@RequestMapping(value="/login", method=RequestMethod.GET)
		public String login() {
			return "login";
		}
// AuthenticationFailureHandler実装クラスで処理
//		// SpringConfigで設定したログインできなかった場合の処理を定義する
//		@RequestMapping(value = "/login-error")
//		public String loginError(Model model) {
//			model.addAttribute("loginError", true);
//			return "login";
//	}
//		@RequestMapping(value="/logout", method=RequestMethod.GET)
//		public String logout() {
//			return "top";
//		}
}
