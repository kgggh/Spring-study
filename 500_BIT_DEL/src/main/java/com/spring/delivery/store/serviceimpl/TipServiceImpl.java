package com.spring.delivery.store.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.store.service.DayoffService;
import com.spring.delivery.store.service.DayoffVO;
import com.spring.delivery.store.service.TipService;
import com.spring.delivery.store.service.TipVO;


@Service("TipService")
public class TipServiceImpl implements TipService{
	@Autowired
	private TipDAO tipDAO;

	@Override
	public List<TipVO> getTip(int s_id) {
		return tipDAO.getTip(s_id);
	}

	@Override
	public int getStoreCount(String dong) {
		return tipDAO.getStoreCount(dong);
	}

	@Override
	public List<Integer> getS_id(String dong) {
		return tipDAO.getS_id(dong);
	}

	@Override
	public TipVO getDongTip(TipVO tip) {
		return tipDAO.getDongTip(tip);
	}



	

}
