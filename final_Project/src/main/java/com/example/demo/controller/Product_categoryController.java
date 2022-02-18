package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.Product_categoryDAO;
import com.example.demo.vo.Product_categoryVO;

import lombok.Setter;

@Controller
@Setter
public class Product_categoryController {
	
	@Autowired
	private Product_categoryDAO dao;
	
	@RequestMapping("/listCategory2")
	public List<Product_categoryVO> listCategory(){
		return dao.listCategory();
	}
}
