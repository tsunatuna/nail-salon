package com.project.nail.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.nail.entity.Reserve;
import com.project.nail.interfaces.ReserveBean;
import com.project.nail.service.ReserveService;
import com.project.nail.service.user.MyUserDetail;
@Controller
@RequestMapping("/reserve")
public class ReserveController {

	@Autowired
	private ReserveService reserveService;

	@GetMapping
	public String getReserve() {

		return "reserve";
	}

	@GetMapping("confirm")
	public String confirmReserve() {

		return "confirm";
	}

	@PostMapping("register")
	public String  registerReserve(@AuthenticationPrincipal MyUserDetail userDetail, @ModelAttribute ReserveBean reserveBean, RedirectAttributes attributes) throws ParseException {

		// 日付変換
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		String date = reserveBean.getDate().replaceAll("[^0-9]","");
		// 登録パラメータ整形
		String id = RandomStringUtils.randomNumeric(10);
		int userId = userDetail.getUserId();
		dateFormat.parse(date);
		Date reservedDate = dateFormat.parse(date);
		Date reservedTime = timeFormat.parse(reserveBean.getTime());
		// エンティティへ設定
		Reserve reserve = new Reserve();
		reserve.setId(id);
		reserve.setUserId(userId);
		reserve.setReservedDate(reservedDate);
		reserve.setReservedTime(reservedTime);

		reserveService.save(reserve);
		attributes.addFlashAttribute("msg", "予約が完了しました！");
		return "redirect:/reserve";
	}

	@PostMapping("delete")
	public String updateReserve(@AuthenticationPrincipal MyUserDetail userDetail, @RequestParam("id") String id, RedirectAttributes attributes) throws ParseException {
		reserveService.delete(id);
		attributes.addFlashAttribute("msg", "削除が完了しました！");
		return "redirect:/reserve";
	}

//	@PostMapping(value="register")
//	public ModelAndView  InsertReserve(@AuthenticationPrincipal MyUserDetail userDetail, @Valid @ModelAttribute ReserveBean reserveBean, BindingResult result, ModelAndView mav) {
//
//
//		if (result.hasErrors()) {
//			//バインドエラー時
//			mav.setViewName("error");
//			return mav;
//		}
//		mav.setViewName("redirect:/reserve");
//		return mav;
//	}
}
