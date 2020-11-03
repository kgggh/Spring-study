package com.spring.delivery.coupon.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.coupon.service.CouponBoxVO;
import com.spring.delivery.coupon.service.CouponService;
import com.spring.delivery.coupon.service.CouponVO;
import com.spring.delivery.event.service.EventVO;



// @Service : @Component 상속확장 어노테이션
//     비즈니스 로직처리 서비스 영역에 사용
@Service("couponService")
public class CouponServiceImpl implements CouponService {
	@Autowired 
	
	private CouponDAOMybatis CouponDAO;
	
	public CouponServiceImpl() {
		System.out.println(">> CouponServiceImpl() 객체생성");
	}

	//쿠폰 등록
	@Override
	public void couponIns(CouponVO vo) {
		CouponDAO.couponIns(vo);
	}

	//쿠폰 리스트(관리자)
	@Override
	public List<CouponVO> couponList() {
		return CouponDAO.couponList();
		
	} 
	//쿠폰 발급 ㅎㅎ
	@Override
	public void couponIssuance(CouponBoxVO vo) {
		CouponDAO.couponIssuance(vo);

	} 
	//쿠폰 삭제 ㅎㅎ
	@Override
	public void couponDel(CouponVO vo) {
		CouponDAO.couponDel(vo);
	}
	

	//쿠폰 상세뷰
	@Override
	public CouponVO couponView(CouponVO vo) {
		return CouponDAO.couponView(vo);
	}
	
	//My 쿠폰함(고객용)
	@Override
	public List<CouponBoxVO> myCoupon(CouponBoxVO vo) {
		return CouponDAO.myCoupon(vo);
	}



	
}
