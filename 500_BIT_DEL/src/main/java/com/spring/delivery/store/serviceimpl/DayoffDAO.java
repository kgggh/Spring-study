package com.spring.delivery.store.serviceimpl;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.store.service.DayoffVO;
import com.spring.delivery.store.service.StoreVO;

@Repository
public class DayoffDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public DayoffVO getDayoff(int s_id) {
		return mybatis.selectOne("DayoffDAO.getDayoff", s_id);
	}
	
	
}
