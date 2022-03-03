package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.CustomerOrder_detailDAO;
import com.example.demo.dao.Customer_orderDAO;
import com.example.demo.vo.CustomerVO;

import lombok.Setter;

@Controller
@Setter
public class Customer_orderController {
	
	@Autowired
	private Customer_orderDAO dao;
	
	@Autowired
	private CustomerOrder_detailDAO codDAO;

	@RequestMapping("/mypage/orderList")
	public void list(HttpSession session, Model model) {
		CustomerVO member = (CustomerVO)session.getAttribute("member");
		model.addAttribute("list",dao.listOrder(member.getCust_id()));
	}
	
	@RequestMapping("/mypage/orderDetail")
	public void detail(Model model,int order_no) {
		System.out.println(order_no);
		model.addAttribute("o",codDAO.listDetail(order_no));
		model.addAttribute("totalDetail",codDAO.totalDetail(order_no));
	}
}
