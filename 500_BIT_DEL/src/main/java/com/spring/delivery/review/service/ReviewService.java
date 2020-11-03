package com.spring.delivery.review.service;

import java.util.List;
import java.util.Map;

import com.spring.delivery.orders.service.SalseVO;

public interface ReviewService {
	public List<ReviewVO> getAvg(int s_id);
	public List<ReviewVO> getC_Avg(String c_classification);
	public List<Skr_ReviewVO> getSReview(int s_id);
	public List<Skr_ReviewVO> getSReviewN(int s_id);
	public void skr_content(Skr_ReviewVO srvo);
	public List<ReviewVO> storeAllReview(Map<String, Integer> map);
	public int storeAllReviewCount(int s_id);
	public List<ReviewVO> ReviewAdmin(Map<String, Integer> map);
	public int ReviewCount(int m_id);	
	public List<ReviewVO> AllReviewAdmin(int m_id);
	public int insertReview(ReviewVO vo);
	public int reviewDelete(int r_id);
	public int USAvg(int s_id);
	public int reviewTot(int s_id);
	public int skrReviewTot(int s_id);
}
