package com.spring.delivery.coupon.service;

import java.util.List;



public interface CouponService {
	public void couponIns(CouponVO vo); //쿠폰등록
	public void couponDel(CouponVO vo); //쿠폰삭제
	public List<CouponVO> couponList(); //쿠폰리스트(관리자)
	public List<CouponBoxVO> myCoupon(CouponBoxVO vo); //My 쿠폰함(고객용)
	public void couponIssuance(CouponBoxVO vo); //쿠폰발급
	public CouponVO couponView(CouponVO vo); //쿠폰상세 
}






