package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.ContentReviewVO;
import com.example.demo.vo.ListReviewVO;
import com.example.demo.vo.ReviewVO;

@Repository
public class ReviewDAO {
	
	public static int pageSIZE = 5;
	public static int totalRecord;
	public static int totalPage;
	
	public List<ListReviewVO> listReviewWrite(HashMap map){
		totalRecord = DBManager.review_getTotalRecord(map);
		totalPage = (int)Math.ceil(totalRecord/(double)pageSIZE);
		
		return DBManager.listReviewWrite(map);
	}
	
	public List<ContentReviewVO> listReviewComplete(String cust_id){
		return DBManager.listReviewComplete(cust_id);
	}
	
	public int deleteReview(int review_no) {
		return DBManager.deleteReview(review_no);
	}
	
	public ContentReviewVO contentReview(int review_no) {
		return DBManager.contentReview(review_no);
	}
	
	public int updateReview(ReviewVO r) {
		return DBManager.updateReview(r);
	}
	
	public ReviewVO findByNo(int review_no) {
		return DBManager.findByNo(review_no);
	}
	
	public List<ContentReviewVO> findAllReview(int product_no){
		return DBManager.findAllReview(product_no);
	}
	
	public int review_getNextNo() {
		return DBManager.review_getNextNo();
	}
	
	public int defaultReview(ReviewVO r) {
		return DBManager.defaultReview(r);
	}
}
