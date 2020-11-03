package com.spring.delivery.coupon.serviceimpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.coupon.service.CouponBoxVO;
import com.spring.delivery.coupon.service.CouponVO;
import com.spring.delivery.event.service.EventVO;


@Repository("CouponDAOMybatis")
public class CouponDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	//쿠폰 등록
	public void couponIns(CouponVO vo) {
		System.out.println("===> 쿠폰등록 실행");
		mybatis.insert("CouponDAO.couponIns", vo);
	}
	
	// 쿠폰 리스트
	public List<CouponVO> couponList() {
		System.out.println("===> 쿠폰 리스트 실행");
		
		return mybatis.selectList("CouponDAO.couponList");
	}	
	
	//쿠폰 박스(My 쿠폰함)
	public List<CouponBoxVO> myCoupon(CouponBoxVO vo){
		System.out.println(">>>>>쿠폰 박스 실행 ㅎㅎㅎ ");
		
		return mybatis.selectList("CouponDAO.myCoupon",vo);
	}
	
	//쿠폰 발급
	public void couponIssuance(CouponBoxVO vo) {
		System.out.println("===> 쿠폰발급 실행ㅎ");
		mybatis.insert("CouponDAO.couponIssuance", vo);
	}
	
	//쿠폰삭제
	public void couponDel(CouponVO vo) {
		System.out.println("===>>>>>> 쿠폰삭제 ㅎㅎㅎ");
		mybatis.delete("CouponDAO.couponDel", vo);
	}
	// 쿠폰 상세 조회(상세조회)
		public CouponVO couponView(CouponVO vo) {
			System.out.println("===> MyBatis로 getBoard() 실행");
			return mybatis.selectOne("CouponDAO.couponView", vo);
	}
}








