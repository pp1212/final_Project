package com.example.demo.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ReviewDAO;
import com.example.demo.vo.ListReviewVO;

import lombok.Setter;

@Controller
@Setter
public class ReviewController {
	
	@Autowired
	private ReviewDAO dao;
	
	@RequestMapping("/mypage/listReviewWrite")
	public void listReviewWrite(Model model){
		String cust_id = "pagy1218";
		model.addAttribute("list", dao.listReviewWrite(cust_id));
	}
	
	@RequestMapping("/mypage/listReviewComplete")
	public void listReviewComplete(Model model) {
		String cust_id = "pagy1218";
		model.addAttribute("list", dao.listReviewComplete(cust_id));
	}
	
	@RequestMapping("/mypage/deleteReview/{review_no}")
	public ModelAndView deleteReview(HttpServletRequest request,@PathVariable int review_no) {
		ModelAndView mav = new ModelAndView("redirect:/mypage/listReviewComplete");
		String oldFname = dao.contentReview(review_no).getReview_img();
		System.out.println("oldFname:"+oldFname);
		
		int re = dao.deleteReview(review_no);
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "상품 삭제에 실패하였습니다.");
		}else {
			String path = request.getRealPath("images");
			System.out.println("path:"+path);
			File file = new File(path + "/" + oldFname);
			file.delete();
		}
		return mav;
	}
	
	@RequestMapping(value = "/mypage/updateReview/{review_no}",method = RequestMethod.GET)
	public void updateReview_form(@PathVariable int review_no,Model model) {
		model.addAttribute("review_no", review_no);
		model.addAttribute("r", dao.contentReview(review_no));
	}
	
	
}
