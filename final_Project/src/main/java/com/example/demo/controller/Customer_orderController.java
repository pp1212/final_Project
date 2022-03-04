package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CustomerOrder_detailDAO;
import com.example.demo.dao.CustomerOrder_refundDAO;
import com.example.demo.dao.Customer_orderDAO;
import com.example.demo.vo.CustomerOrder_refundVO;
import com.example.demo.vo.CustomerVO;
import com.example.demo.vo.ListDetailVO;
import com.example.demo.vo.OrderCancelVO;

import lombok.Setter;

@Controller
@Setter
public class Customer_orderController {
	
	@Autowired
	private Customer_orderDAO dao;
	
	@Autowired
	private CustomerOrder_detailDAO codDAO;
	
	@Autowired
	private CustomerOrder_refundDAO rDAO;

	@RequestMapping("/mypage/orderList")
	public void list(HttpSession session, Model model) {
		CustomerVO member = (CustomerVO)session.getAttribute("member");
		model.addAttribute("list",dao.listOrder(member.getCust_id()));
	}
	
	@RequestMapping("/mypage/orderDetail")
	public void detail(Model model,int order_no) {
		List<ListDetailVO> list = codDAO.listDetail(order_no);
//		System.out.println("주문상세내역:"+list);
		model.addAttribute("list",list);
		model.addAttribute("o",list.get(0));
		
		model.addAttribute("totalDetail",codDAO.totalDetail(order_no));
		ListDetailVO ld = new ListDetailVO();
	}
	
	@RequestMapping(value = "/mypage/orderCancelPage", method = RequestMethod.GET)
	public void orderCancelPage(Model model,int order_no) {
		List<OrderCancelVO> list = dao.orderCancelPage(order_no);
//		System.out.println("주문상세내역:"+list);
		model.addAttribute("list",list);
		model.addAttribute("o",list.get(0));
		
		model.addAttribute("totalDetail",codDAO.totalDetail(order_no));
	}
	
	@RequestMapping(value = "/mypage/orderCancelPage", method = RequestMethod.POST)
	public ModelAndView orderCancelPage_submit(Model model,int order_no, CustomerOrder_refundVO cr) {
		ModelAndView mav = new ModelAndView();
		int re = rDAO.insertRefund(cr);
	
		if(re == 1) {
			dao.orderCancelCheck(order_no);
			mav.setViewName("redirect:/mypage/orderList");
		}else {
			mav.addObject("msg", "주문취소에 실패하였습니다.");
			mav.setViewName("redirect:/common/error");
		}
		return mav;
	}
	
}
	
	
	
	
	
	
	
	
	
