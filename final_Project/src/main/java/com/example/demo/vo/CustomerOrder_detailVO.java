package com.example.demo.vo;

import lombok.Data;

@Data
public class CustomerOrder_detailVO {
	private int detail_no;
	private int order_no;
	private int product_no;
	private int detail_price;
	private int detail_cnt;
}
