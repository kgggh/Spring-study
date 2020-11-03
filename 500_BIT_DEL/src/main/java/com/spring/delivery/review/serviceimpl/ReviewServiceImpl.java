package com.spring.delivery.review.serviceimpl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.orders.service.SalseVO;
import com.spring.delivery.review.service.ReviewService;
import com.spring.delivery.review.service.ReviewVO;
import com.spring.delivery.review.service.Skr_ReviewVO;
import com.spring.delivery.store.service.StoreService;
import com.spring.delivery.store.service.StoreVO;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewDAO reviewDAO;

	@Override
	public List<ReviewVO> getAvg(int s_id) {
		
		return reviewDAO.getAvg(s_id);
	}

	@Override
	public List<ReviewVO> getC_Avg(String c_classification) {
		
		return reviewDAO.getC_Avg(c_classification);
	}

	@Override
	public List<Skr_ReviewVO> getSReview(int s_id) {
		
		return reviewDAO.getSReview(s_id);
	}

	@Override
	public List<Skr_ReviewVO> getSReviewN(int s_id) {
		return reviewDAO.getSReviewN(s_id);
	}

	@Override
	public void skr_content(Skr_ReviewVO srvo) {
		reviewDAO.skr_content(srvo);
		
	}

	@Override
	public List<ReviewVO> storeAllReview(Map<String, Integer> map) {
		return reviewDAO.storeAllReview(map);
	}

	@Override
	public int storeAllReviewCount(int s_id) {
		return reviewDAO.storeAllReviewCount(s_id);
	}

	@Override
	public List<ReviewVO> ReviewAdmin(Map<String, Integer> map) {
		return reviewDAO.ReviewAdmin(map);
	}

	@Override
	public int ReviewCount(int m_id) {
		return reviewDAO.ReviewCount(m_id);
	}

	@Override
	public List<ReviewVO> AllReviewAdmin(int m_id) {
		return reviewDAO.AllReviewAdmin(m_id);
	}

	@Override
	public int insertReview(ReviewVO vo) {
		return reviewDAO.insertReview(vo);
	}
	@Override
	public int reviewDelete(int r_id) {
		return reviewDAO.reviewDelete(r_id);
	}
	@Override
	public int USAvg(int s_id) {
		return reviewDAO.USAvg(s_id);
	}
	@Override
	public int reviewTot(int s_id ) {
		return reviewDAO.reviewTot(s_id);		
	}
	@Override
	public int skrReviewTot(int s_id ) {
		return reviewDAO.skrReviewTot(s_id);		
	}	
}
