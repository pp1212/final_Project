package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CartDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.dao.QnaDAO;
import com.example.demo.dao.ReviewDAO;
import com.example.demo.vo.CartVO;
import com.example.demo.vo.ContentReviewVO;
import com.example.demo.vo.ListQnaVO;
import com.example.demo.vo.ProductVO;

import lombok.Setter;

@Controller
@Setter
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	@Autowired
	private ReviewDAO reviewDao;
	
	@Autowired
	private QnaDAO qnaDao;
	
	@Autowired
	private CartDAO cartDao;
	
	
	@RequestMapping("/market/listProduct")
	public void listProduct(String category_code,String orderType,Model model,HttpSession session,@RequestParam(defaultValue = "1") int pageNUM){
		if(category_code == null) {
			category_code = (String)session.getAttribute("category_code");
		}
		
		if(orderType == null && session.getAttribute("orderType") != null) {
			orderType = (String)session.getAttribute("orderType");
		}
		
		System.out.println("정렬컬럼:"+orderType);
		System.out.println("pageNUM:"+pageNUM);
		
		int start = (pageNUM-1)*dao.pageSIZE +1;
		int end = start + dao.pageSIZE -1;
		System.out.println("start:"+start);
		System.out.println("end:"+end);
		
		HashMap map = new HashMap();
		map.put("orderType", orderType);
		map.put("category_code", category_code);
		map.put("start", start);
		map.put("end",end);
		System.out.println("category_code:"+category_code);
		
		model.addAttribute("list", dao.listProduct(map));
		model.addAttribute("totalPage", dao.totalPage);
		
		if(category_code != null) {
			session.setAttribute("category_code", category_code);
		}
		
		
		if(orderType != null) {
			session.setAttribute("orderType", orderType);
		}
	}
	
	@RequestMapping("/market/recentProduct")
	public void recentProduct(String orderType,Model model) {
		System.out.println("orderType:"+orderType);
		model.addAttribute("list", dao.recentProduct(orderType));
	}
	
	@RequestMapping("/market/detailProduct")
	public void detailProduct(int product_no,Model model,HttpSession session) {
		String cust_id = (String)session.getAttribute("cust_id");
		ProductVO p = dao.detailProduct(product_no);
		p.setProduct_no(product_no);
		model.addAttribute("p", p);
		System.out.println("p:"+p);
		
		List<ContentReviewVO> reviewList = reviewDao.findAllReview(product_no);
		model.addAttribute("reviewList", reviewList);
		System.out.println("reviewList:"+reviewList);
		
		List<ListQnaVO> qnaList = qnaDao.findAllQna(product_no);
		model.addAttribute("qnaList", qnaList);
		System.out.println("qnaList:"+qnaList);
	}
	
	@RequestMapping(value = "/market/insertCart",method = RequestMethod.POST)
	@ResponseBody
	public String insertCart(@RequestBody String data) {
		String[] arr = data.split(",");
		System.out.println("arr1:"+arr[0]);
		System.out.println("arr2:"+arr[1]);
		System.out.println("arr3:"+arr[2]);
		
		String cust_id = arr[0].substring(12, arr[0].length()-1);
		int product_no = Integer.parseInt(arr[1].substring(14, arr[1].length()-1));
		int product_cnt = Integer.parseInt(arr[2].substring(15,arr[2].length()-2 ));
		System.out.println("cust_id:"+cust_id);
		System.out.println("product_no:"+product_no);
		System.out.println("product_cnt:"+product_cnt);
		int re = 0;
		

		if(cartDao.findByProduct(cust_id,product_no) == 1) {
			re = -1;
		}else {
			CartVO c = new CartVO(cartDao.cartGetNextNo(), product_cnt, cust_id, product_no);
			re = cartDao.insertCart(c);
		}
		
		return re>0?"true":"false";
	}
}
