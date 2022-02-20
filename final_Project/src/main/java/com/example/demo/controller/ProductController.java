package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductDAO;
import com.example.demo.dao.Product_categoryDAO;
import com.example.demo.vo.ProductVO;
import com.example.demo.vo.Product_categoryVO;

import lombok.Setter;

@Controller
@Setter
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	@Autowired
	private Product_categoryDAO cdao;
	
	@RequestMapping("/totalProduct")
	public void listCategory(Model model){
		model.addAttribute("category", cdao.listCategory());
	}
	
	@RequestMapping("/listProduct/{category_code}")
	@ResponseBody
	public List<ProductVO> listProduct(@PathVariable String category_code){
		return dao.listProduct(category_code);
	}
	
	
	
}
