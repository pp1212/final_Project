package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CustomerOrder_detailDAO;
import com.example.demo.dao.CustomerOrder_refundDAO;
import com.example.demo.dao.Customer_orderDAO;
import com.example.demo.vo.CustomerOrder_refundVO;
import com.example.demo.vo.CustomerVO;
import com.example.demo.vo.ListDetailVO;
import com.example.demo.vo.MonthTotalVO;
import com.example.demo.vo.OrderCancelVO;

import lombok.Setter;

@Controller
@Setter
public class Customer_orderController {
	
	@Autowired
	private Customer_orderDAO dao;
	
	@Autowired
	private CustomerOrder_detailDAO codDAO;
	
	@Autowired
	private CustomerOrder_refundDAO rDAO;

	@RequestMapping("/mypage/orderList")
	public void list(HttpSession session, Model model) {
		CustomerVO member = (CustomerVO)session.getAttribute("member");
		model.addAttribute("list",dao.listOrder(member.getCust_id()));
	}
	
	@RequestMapping("/mypage/orderDetail")
	public void detail(Model model,int order_no) {
		List<ListDetailVO> list = codDAO.listDetail(order_no);
//		System.out.println("주문상세내역:"+list);
		model.addAttribute("list",list);
		model.addAttribute("o",list.get(0));
		
		model.addAttribute("totalDetail",codDAO.totalDetail(order_no));
		ListDetailVO ld = new ListDetailVO();
	}
	
	@RequestMapping(value = "/mypage/orderCancelPage", method = RequestMethod.GET)
	public void orderCancelPage(Model model,int order_no) {
		List<OrderCancelVO> list = dao.orderCancelPage(order_no);
//		System.out.println("주문상세내역:"+list);
		model.addAttribute("list",list);
		model.addAttribute("o",list.get(0));
		
		model.addAttribute("totalDetail",codDAO.totalDetail(order_no));
	}
	
	@RequestMapping(value = "/mypage/orderCancelPage", method = RequestMethod.POST)
	public ModelAndView orderCancelPage_submit(Model model,int order_no, CustomerOrder_refundVO cr) {
		ModelAndView mav = new ModelAndView();
		int re = rDAO.insertRefund(cr);
	
		if(re == 1) {
			dao.orderCancelCheck(order_no);
			mav.setViewName("redirect:/mypage/orderList");
		}else {
			mav.addObject("msg", "주문취소에 실패하였습니다.");
			mav.setViewName("redirect:/common/error");
		}
		return mav;
	}
	
//	@RequestMapping("/admin/monthTotal")
//	@ResponseBody
//	public String monthTotal(HttpServletRequest request, MonthTotalVO mt) {
//		List<MonthTotalVO> list = dao.monthTotal();
//		request.setAttribute("list", list);
//		HashMap map = new HashMap();
//		map.put("list", list);
//		String json = null;
//		try {
//			json = new ObjectMapper().writeValueAsString(map);
//		}catch (Exception e) {
//			System.out.println("예외발생:"+e.getMessage());
//		}
//		System.out.println(list);
//		return json;
//		
//	}
//	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/admin/monthTotal" ,method=RequestMethod.GET)
	public ResponseEntity<JSONObject> money_list(){
		ResponseEntity<JSONObject>  entity=null;
		List<MonthTotalVO>  items=  dao.monthTotal();
		//리스트 형태를 json 형태로 만들어서 리턴
		JSONObject data =new JSONObject();
		
		//컬럼객체
		JSONObject col1 =new JSONObject();
		JSONObject col2 =new JSONObject();
		JSONArray title =new JSONArray();
		col1.put("label", "월");
		col1.put("type", "number");
		col2.put("label", "금액");
		col2.put("type" , "number");
		
		title.add(col1);
		title.add(col2);
		
		data.put("cols", title);
/*		
		"rows": [
			        {"c":[{"v":"Mushrooms"},{"v":3}]},
			        {"c":[{"v":"Onions"},{"v":1}]},
			       ]
			       
		rows : [ 배열 (객체 :배열[객체])]
		
*/ 	

		//들어갈 형태  ->  rows 객체 에 배열  <- 
		//  <- [  c 라는 객체에 배열 <- 객체
		//  data 객체 -> rows 배열 <-  c 객체  ->배열  <- v 객체 2개/
	
		JSONArray  body =new JSONArray();
		for(MonthTotalVO  mt : items){
			JSONObject month =new JSONObject();
			month.put("month", mt.getMonth()); //월이름
			JSONObject price =new JSONObject(); 
			price.put("price", mt.getTotal()); //금액

			//  v객체를 row 배열을 만든후 추가한다.
			JSONArray row =new JSONArray();
			row.add(month);
			row.add(price);   
 
			//   c 객체 를 만든후 row 배열을 담는다.
			JSONObject c =new JSONObject();
			c.put("c", row);		
			// c 객체를 배열 형태의 body 에 담는다.
			body.add(c);		
		}
		// 배열 형태의 body 를 rows 키값으로 객체 data 에 담는다.
		data.put("rows", body);
		try{
			 entity =new ResponseEntity<JSONObject>(data, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(" 에러            -- ");
			entity =new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
}
	
	
	
	
	
	
	
	
	
