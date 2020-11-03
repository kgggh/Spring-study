package com.spring.delivery.coupon.service;

import java.util.List;



public interface CouponService {
	void couponIns(CouponVO vo); //쿠폰등록
	void couponDel(CouponVO vo); //쿠폰삭제
	List<CouponVO> couponList(); //쿠폰리스트(관리자)
	List<CouponBoxVO> myCoupon(CouponBoxVO vo); //My 쿠폰함(고객용)
	void couponIssuance(CouponBoxVO vo); //쿠폰발급
	CouponVO couponView(CouponVO vo); //쿠폰상세 
}






