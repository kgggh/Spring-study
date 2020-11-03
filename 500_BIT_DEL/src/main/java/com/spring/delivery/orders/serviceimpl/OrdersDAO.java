package com.spring.delivery.orders.serviceimpl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.orders.service.OrdersVO;
import com.spring.delivery.orders.service.SalseVO;
import com.spring.delivery.store.service.StoreVO;

@Repository
public class OrdersDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<SalseVO> salse_Management(int s_id) {
		List<OrdersVO> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();

		List<SalseVO> slist = new ArrayList<>();
		String dt = "";
		int tot = 0;
		int total = 0;
		for(int i=0; i <= 6; i++) {
			System.out.println("------------------------------------------------------");
			dt = mybatis.selectOne("delivery.sysdate", i);
			map.put("s_id", Integer.toString(s_id));
			map.put("dt", dt);
			list = mybatis.selectList("delivery.salse_Management", map);
			System.out.println(list.toString());
			map.clear();
			tot = 0;
			for (int j = 0; j <= list.size() -1; j++) {
				tot = tot + list.get(j).getO_price();
			}
			total = total + tot;
			SalseVO svo = new SalseVO();
			svo.setDt(dt);
			svo.setDayTotal(tot);
			System.out.println("dtot:" + dt+", " + tot);
			slist.add(svo);
			System.out.println("svo: "+ svo);
			System.out.println("slist:" + slist.toString());
			System.out.println("--------------------------------------------------");
				if(i == 6) {
					SalseVO svoo = new SalseVO();
					svoo.setDt("합 계");
					svoo.setDayTotal(total);
					slist.add(svoo);
				}
		}
		return slist;
	}
	
	public Integer getOrderCount(int s_id) {
		return mybatis.selectOne("OrdersDAO.getOrderCount", s_id);
	}
	
	public Integer OrderCount(int m_id) {
		return mybatis.selectOne("OrdersDAO.OrderCount", m_id);
	}
		
	public List<OrdersVO> OrderReview(Map<String, Integer> map) {
		return mybatis.selectList("OrdersDAO.OrderReview", map);
	}	
	
	public void insertOrder(OrdersVO order) {
		mybatis.insert("OrdersDAO.insertOrder", order);
	}
	
	public Integer maxScoNum(int m_id) {
		return mybatis.selectOne("OrdersDAO.maxScoNum", m_id);
	}
		
}
