package com.example.demo.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.ProductVO;
import com.example.demo.vo.Product_categoryVO;

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
}
