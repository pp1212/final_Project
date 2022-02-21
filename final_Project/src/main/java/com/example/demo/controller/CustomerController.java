package com.example.demo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.vo.CustomerVO;

import lombok.Setter;

@Controller
@Setter
public class CustomerController {

	@Autowired
	private CustomerDAO dao;
	
	@RequestMapping(value = "/insertCustomer", method = RequestMethod.GET)
	public void join_form(){
		
	}
	
	@RequestMapping(value = "/insertCustomer", method = RequestMethod.POST)
	public ModelAndView join_submit(CustomerVO c){
		ModelAndView mav = new ModelAndView();
		int re = dao.insertCustomer(c);
		if(re == 1) {
			mav.setViewName("insertCustomerOK");
			mav.addObject("msg",c.getCust_id()+"보글님 회원가입이 완료되었습니다.");
		}else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	
	@RequestMapping(value = "/user/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public int idCheck(@RequestParam("cust_id") String cust_id) {
 
		return dao.doubleCheck_id(cust_id);
		
	}
	
	
}









