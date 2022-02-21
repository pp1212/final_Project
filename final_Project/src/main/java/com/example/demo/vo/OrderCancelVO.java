package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCancelVO {

	private Data order_date;
	private int order_no;	
	private String cust_name;	
	private String product_img;	
	private int detail_price;	
	private int detail_cnt;	
	private int payment_code;	
}
