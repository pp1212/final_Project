package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.ProductVO;
import com.example.demo.vo.Product_categoryVO;

@Repository
public class ProductDAO {
	
	public List<ProductVO> listProduct(String category_code){
		return DBManager.listProduct(category_code);
	}
}
