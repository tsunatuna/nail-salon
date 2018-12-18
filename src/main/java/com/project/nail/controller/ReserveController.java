package com.project.nail.controller;

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

import com.project.nail.entity.TrnReserves;
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
	public String registerReserve(
			@AuthenticationPrincipal MyUserDetail userDetail, @ModelAttribute ReserveBean reserveBean,
			RedirectAttributes attributes) {

		// 予約番号採番
		String reservedId = RandomStringUtils.randomNumeric(10);
		// エンティティへ設定
		TrnReserves trnReserves = new TrnReserves(reservedId, reserveBean.getDesignId(), userDetail.getUserId(),
				reserveBean.getReservedDate(), reserveBean.getReservedTime());

		reserveService.save(trnReserves);
		attributes.addFlashAttribute("msg", "予約が完了しました！");
		return "redirect:/reserve";
	}

	@PostMapping("delete")
	public String updateReserve(
			@AuthenticationPrincipal MyUserDetail userDetail, @RequestParam("reservedId") String reservedId,
			RedirectAttributes attributes) {
		reserveService.delete(reservedId);
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
