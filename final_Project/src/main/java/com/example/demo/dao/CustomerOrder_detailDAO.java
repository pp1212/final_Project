package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.ListDetailVO;

@Repository
public class CustomerOrder_detailDAO {

	public List<ListDetailVO> listDetail(int order_no) {
		return DBManager.listDetail(order_no);
	}
	
	public int totalDetail(int order_no) {
		return DBManager.totalDetail(order_no);
	}
}
