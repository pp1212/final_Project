package com.example.demo.db;

import java.io.Reader;
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
	
	public static List<ProductVO> listProduct(String category_code){
		SqlSession session = factory.openSession();
		List<ProductVO> list = session.selectList("product.listProduct", category_code);
		session.close();
		return list;
	}
	
	public static List<Product_categoryVO> listCategory(){
		SqlSession session = factory.openSession();
		List<Product_categoryVO> list = session.selectList("product_category.listCategory");
		session.close();
		return list;
	}
}
