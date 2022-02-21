package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MonthTotalVO;

@Repository
public class Customer_orderDAO {

	public List<MonthTotalVO> monthTotal() {
		return DBManager.monthTotal();
	}
}
