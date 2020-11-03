package com.spring.delivery.store.serviceimpl;



import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.store.service.DayoffVO;
import com.spring.delivery.store.service.StoreVO;
import com.spring.delivery.store.service.TipVO;

@Repository
public class TipDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<TipVO> getTip(int s_id) {
		return mybatis.selectList("TipDAO.getTip", s_id);
	}
	public int getStoreCount(String dong) {
		return mybatis.selectOne("TipDAO.StoreCount", dong);
	}	
		
	public List<Integer> getS_id(String dong) {
		return mybatis.selectList("TipDAO.getS_id", dong);
	}
	
	public TipVO getDongTip(TipVO tip) {
		return mybatis.selectOne("TipDAO.getDongTip", tip);
	}
}
