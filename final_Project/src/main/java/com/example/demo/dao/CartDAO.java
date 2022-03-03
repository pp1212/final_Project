package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.CartProductVO;
import com.example.demo.vo.CartVO;

@Repository
public class CartDAO {
	public int insertCart(CartVO c) {
		return DBManager.insertCart(c);
	}
	
	public List<CartProductVO> cartProduct(String cust_id){
		return DBManager.cartProduct(cust_id);
	}
	
	public int updateCart(CartVO c) {
		return DBManager.updateCart(c);
	}
	
	public int deleteCart(int cart_no) {
		return DBManager.deleteCart(cart_no);
	}
	
	public CartProductVO cartOrder(CartVO c) {
		return DBManager.cartOrder(c);
	}
}
