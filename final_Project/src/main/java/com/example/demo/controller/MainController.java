package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.ProductDAO;
import com.example.demo.vo.ProductVO;

import lombok.Setter;

@Controller
@Setter
public class MainController {
	
	@Autowired
	private ProductDAO dao;
	
	@RequestMapping("/main")
	public void main(Model model) {
		model.addAttribute("bList", dao.bestProduct());
	}
}
