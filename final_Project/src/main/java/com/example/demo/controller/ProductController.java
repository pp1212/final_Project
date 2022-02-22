package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductDAO;
import com.example.demo.dao.Product_categoryDAO;
import com.example.demo.vo.ProductVO;
import com.example.demo.vo.Product_categoryVO;
import com.example.demo.vo.ResultVO;

import lombok.Setter;

@Controller
@Setter
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	@Autowired
	private Product_categoryDAO cdao;
	
	@RequestMapping("/market/totalProduct")
	public void listCategory(Model model){
		model.addAttribute("category", cdao.listCategory());
	}
	
	@RequestMapping("/market/listProduct/{category_code}/{pageNUM}")
	@ResponseBody
	public ResultVO listProduct(@PathVariable String category_code, @PathVariable int pageNUM, HttpSession session){
//		if(orderColumn == null && session.getAttribute("orderColumn") != null) {
//			orderColumn = (String)session.getAttribute("orderColumn");
//		}
//		
//		System.out.println("정렬컬럼:"+orderColumn);
		System.out.println("pageNUM:"+pageNUM);
		
		int start = (pageNUM-1)*dao.pageSIZE +1;
		int end = start + dao.pageSIZE -1;
		System.out.println("start:"+start);
		System.out.println("end:"+end);
		
		
		HashMap map = new HashMap();
		//map.put("orderColumn", orderColumn);
		map.put("category_code", category_code);
		map.put("start", start);
		map.put("end",end);
		System.out.println("category_code:"+category_code);
		
		ResultVO r = new ResultVO();
		r.setList(dao.listProduct(map));
		r.setTotalPage(dao.totalPage);
		System.out.println("totalPage:"+dao.totalPage);
		
		return r;
		
//		model.addAttribute("list", dao.listProduct(map));
//		model.addAttribute("totalPage", dao.totalPage);
		
//		if(orderColumn != null) {
//			session.setAttribute("orderColumn", orderColumn);
//		}
	}
	
	
	
}
