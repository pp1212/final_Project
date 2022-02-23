package com.example.demo.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.ContentReviewVO;
import com.example.demo.vo.ListReviewVO;
import com.example.demo.vo.ProductVO;
import com.example.demo.vo.Product_categoryVO;
import com.example.demo.vo.ReviewVO;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static List<ProductVO> listProduct(HashMap map){
		SqlSession session = factory.openSession();
		List<ProductVO> list = session.selectList("product.listProduct", map);
		System.out.println(list);
		System.out.println("데이터수:"+list.size());
		session.close();
		return list;
	}
	
	public static List<Product_categoryVO> listCategory(){
		SqlSession session = factory.openSession();
		List<Product_categoryVO> list = session.selectList("product_category.listCategory");
		session.close();
		return list;
	}
	
	public static int getTotalRecord(HashMap map) {
		SqlSession session = factory.openSession();
		int no = session.selectOne("product.getTotalRecord", map);
		session.close();
		return no;
	}
	
	public static List<ListReviewVO> listReviewWrite(String cust_id){
		SqlSession session = factory.openSession();
		List<ListReviewVO> list = session.selectList("review.listReviewWrite",cust_id);
		session.close();
		return list;
	}
	
	public static List<ContentReviewVO> listReviewComplete(String cust_id){
		SqlSession session = factory.openSession();
		List<ContentReviewVO> list = session.selectList("review.listReviewComplete", cust_id);
		session.close();
		return list;
	}
	
	public static int deleteReview(int review_no) {
		SqlSession session = factory.openSession();
		int re = session.delete("review.deleteReview", review_no);
		session.commit();
		session.close();
		return re;
	}
	
	public static ContentReviewVO contentReview(int review_no) {
		SqlSession session = factory.openSession();
		ContentReviewVO c = session.selectOne("review.contentReview", review_no);
		session.close();
		return c;
	}
	
	public static int updateReview(ReviewVO r) {
		SqlSession session = factory.openSession();
		int re = session.update("review.updateReview", r);
		session.commit();
		session.close();
		return re;
	}
	
	public static ReviewVO findByNo(int review_no) {
		SqlSession session = factory.openSession();
		ReviewVO r = session.selectOne("review.findByNo", review_no);
		session.close();
		return r;
	}
}
