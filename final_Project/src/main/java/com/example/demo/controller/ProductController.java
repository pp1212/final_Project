package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductDAO;
import com.example.demo.dao.Product_categoryDAO;
import com.example.demo.vo.ProductVO;
import com.example.demo.vo.Product_categoryVO;

import lombok.Setter;

@RestController
@Setter
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	@Autowired
	private Product_categoryDAO dao2;
	
	@RequestMapping("/listProduct/{category_code}")
	public List<ProductVO> listProduct(@PathVariable String category_code){
		return dao.listProduct(category_code);
	}
	
	@RequestMapping("/listCategory")
	public List<Product_categoryVO> listCategory(){
		return dao2.listCategory();
	}
	
}
