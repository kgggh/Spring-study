package com.spring.delivery.store.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.store.service.DayoffService;
import com.spring.delivery.store.service.DayoffVO;


@Service("DayoffService")
public class DayoffServiceImpl implements DayoffService{
	@Autowired
	private DayoffDAO dayoffDAO;

	@Override
	public DayoffVO getDayoff(int s_id) {
		return dayoffDAO.getDayoff(s_id);
	}

	

}
