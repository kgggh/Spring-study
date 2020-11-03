package com.spring.delivery.review.serviceimpl;



import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.review.service.ReviewVO;
import com.spring.delivery.review.service.Skr_ReviewVO;


@Repository
public class ReviewDAO {
	@Autowired
	private SqlSessionTemplate review;
	
	public List<ReviewVO> getAvg(int s_id) {
		System.out.println("s_id:" + s_id);
		
		return review.selectList("ReviewDAO.getAvg", s_id);
	}
	
	public List<ReviewVO> getC_Avg(String s_classification) {
		System.out.println("s_classification:" + s_classification);
		return review.selectList("ReviewDAO.getC_Avg", s_classification);
	}
	
	public List<Skr_ReviewVO> getSReview(int s_id) {
		
		return review.selectList("ReviewDAO.getSReview", s_id);
	}
	
	public List<Skr_ReviewVO> getSReviewN(int s_id) {
		
		return review.selectList("ReviewDAO.getSReviewN", s_id);
	}
	
	public void skr_content(Skr_ReviewVO srvo) {
		
		review.update("ReviewDAO.skr_content", srvo);
	}
	
	
	public List<ReviewVO> storeAllReview(Map<String, Integer> map) {	
		return review.selectList("ReviewDAO.storeAllReview", map);
	}
	
	public int storeAllReviewCount(int s_id) {	
		return review.selectOne("ReviewDAO.storeAllReviewCount", s_id);
	}
	public List<ReviewVO> ReviewAdmin(Map<String, Integer> map) {	
		return review.selectList("ReviewDAO.ReviewAdmin", map);
	}
	
	public int ReviewCount(int m_id) {	
		return review.selectOne("ReviewDAO.ReviewCount", m_id);
	}
	public List<ReviewVO> AllReviewAdmin(int m_id) {	
		return review.selectList("ReviewDAO.AllReviewAdmin", m_id);
	}
	
	public int insertReview(ReviewVO vo) {	
		return review.insert("ReviewDAO.insertReview", vo);
	}
	public int reviewDelete(int r_id) {	
		return review.delete("ReviewDAO.reviewDelete", r_id);
	}
	//리뷰보기 평점 
	public int USAvg(int s_id) {
		return review.selectOne("ReviewDAO.USAvg", s_id);
	}
	//리뷰갯수
	public int reviewTot(int s_id) {
		return review.selectOne("ReviewDAO.reviewTot", s_id);
	}
	//답글갯수
	public int skrReviewTot(int s_id) {
		return review.selectOne("ReviewDAO.skrReviewTot", s_id);
	}	
}
