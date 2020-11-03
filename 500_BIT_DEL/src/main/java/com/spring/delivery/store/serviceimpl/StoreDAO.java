package com.spring.delivery.store.serviceimpl;



import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.spring.delivery.store.service.StoreVO;

@Repository
public class StoreDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public StoreVO selectOneStore(int m_id) {
		return mybatis.selectOne("delivery.selectOneStore", m_id);
	}

	public void resumption(int s_id) {
		mybatis.update("delivery.resumption", s_id);
	}
	

	public int Closing_Apply(int s_id) {
		return mybatis.update("delivery.Closing_Apply", s_id);
	}
	
	public StoreVO getStoreInfo(int s_id) {
		return mybatis.selectOne("delivery.getStoreInfo", s_id);
	}
		
	public int StoreCount(StoreVO storePut) {
		return mybatis.selectOne("delivery.StoreCount", storePut);
	}
	
	public List<StoreVO> getStore(StoreVO storePut) {
		return mybatis.selectList("delivery.getStore", storePut);
	}
}
