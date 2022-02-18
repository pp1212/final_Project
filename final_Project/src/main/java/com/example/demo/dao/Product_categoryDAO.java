package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.ProductVO;
import com.example.demo.vo.Product_categoryVO;

@Repository
public class Product_categoryDAO {
	
	public List<Product_categoryVO> listCategory(){
		return DBManager.listCategory();
	}
}
