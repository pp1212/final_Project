package com.example.demo.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.CustomerOrder_refundVO;
import com.example.demo.vo.CustomerVO;
import com.example.demo.vo.ListDetailVO;
import com.example.demo.vo.ListOrderVO;
import com.example.demo.vo.MonthTotalVO;
import com.example.demo.vo.OrderCancelVO;
import com.example.demo.vo.QnaVO;

public class DBManager {

	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader
			=Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}		
	}
	
	public static int insertCustomer(CustomerVO c) {
		SqlSession session = factory.openSession();
		int re = session.insert("customer.insertCustomer",c);
		session.commit();
		session.close();
		return re;
	}
	
	public static int doubleCheck_id(String cust_id) {
		SqlSession session = factory.openSession();
		int re = session.selectOne("customer.doubleCheck_id",cust_id);
		session.close();
		return re;
	}
	
	public static int doubleCheck_email(String cust_email) {
		SqlSession session = factory.openSession();
		int re = session.selectOne("customer.doubleCheck_email",cust_email);
		session.close();
		return re;
	}
	
	public static String login(int cust_id) {
		SqlSession session = factory.openSession();
		String str = session.selectOne("customer.login",cust_id);
		session.close();
		return str;
	}
	
	public static HashMap findId(String cust_name, String cust_phone) {
		SqlSession session = factory.openSession();
		HashMap map = new HashMap();
		map.put("cust_name", cust_name);
		map.put("cust_phone", cust_phone);
		session.selectOne("customer.findId",map);
		session.close();
		return map;
	}
	
	public static HashMap findPwd(String cust_id, String cust_phone) {
		SqlSession session = factory.openSession();
		HashMap map = new HashMap();
		map.put("cust_id", cust_id);
		map.put("cust_phone", cust_phone);
		session.selectOne("customer.findId",map);
		session.close();
		return map;
	}
	
	public static CustomerVO detailCustomer(int cust_id) {
		SqlSession session = factory.openSession();
		CustomerVO c = session.selectOne("customer.detailCustomer",cust_id);
		session.close();
		return c;
	}
	
	public static int updateCustomer(CustomerVO c) {
		SqlSession session = factory.openSession();
		int re = session.update("customer.updateCustomer",c);
		session.commit();
		session.close();
		return re;
	}
	
	public static CustomerVO showCustomer(int cust_id) {
		SqlSession session = factory.openSession();
		CustomerVO c = session.selectOne("customer.showCustomer",cust_id);
		session.close();
		return c;
	}
	
	//===================================================
	//qna
	
	public static QnaVO detailQna(int qna_no) {
		SqlSession session = factory.openSession();
		QnaVO q = session.selectOne("qna.detailQna",qna_no);
		session.close();
		return q;
	}
	
	public static int updateQna(QnaVO q) {
		SqlSession session = factory.openSession();
		int re = session.update("qna.updateQna",q);
		session.commit();
		session.close();
		return re;
	}
	
	public static int deleteQna(int qna_no) {
		SqlSession session = factory.openSession();
		int re = session.delete("qna.deleteQna",qna_no);
		session.commit();
		session.close();
		return re;
	}
	
	public static int getNextNo() {
		SqlSession session = factory.openSession();
		int no = session.selectOne("qna.getNextNo");
		session.close();
		return no;
	}
	
	public static List<QnaVO> listQna() {
		SqlSession session = factory.openSession();
		List<QnaVO> list = session.selectList("qna.listQna");
		session.close();
		return list;
	}
	
	public static int insertQna(QnaVO q) {
		SqlSession session = factory.openSession();
		q.setQna_no(getNextNo());
		int re = session.insert("qna.insertQna",q);
		session.commit();
		session.close();
		return re;
	}
	
	//===========================================
	//customer_order
	public static List<ListOrderVO> listOrder(String cust_id) {
		SqlSession session = factory.openSession();
		List<ListOrderVO> list = session.selectList("customer_order.listOrder",cust_id);
		session.close();
		return list;
	}
	
	public static List<OrderCancelVO> orderCancelPage(int order_no) {
		SqlSession session = factory.openSession();
		List<OrderCancelVO> list = session.selectList("customer_order.orderCancelPage", order_no);
		session.close();
		return list;
	}
	
	public static int orderCancelCheck(int order_no) {
		SqlSession session = factory.openSession();
		int re = session.update("customer_order.orderCancelCheck",order_no);
		session.commit();
		session.close();
		return re;
	}
	
	public static List<MonthTotalVO> monthTotal() {
		SqlSession session = factory.openSession();
		List<MonthTotalVO> list = session.selectList("customer_order.monthTotal");
		session.close();
		return list;
	}
	
	//=========================================
	//customerOrder_detail
	public static List<ListDetailVO> listDetail(int order_no) {
		SqlSession session = factory.openSession();
		List<ListDetailVO> list = session.selectList("customerOrder_detail.listDetail", order_no);
		session.close();
		return list;
	}
	
	public static int totalDetail(int order_no) {
		SqlSession session = factory.openSession();
		int re = session.selectOne("customerOrder_detail.totalDetail", order_no);
		session.close();
		return re;
	}
	
	//===========================================
	//customerOrder_refund
	public static int insertRefund(CustomerOrder_refundVO cr) {
		cr.setRefund_no(getNextNo());
		SqlSession session = factory.openSession();
		int re = session.insert("customerOrder_refund.insertRefund", cr);
		session.close();
		return re;
	}
}





















