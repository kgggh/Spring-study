package com.spring.delivery.store.serviceimpl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.delivery.store.service.StoreService;
import com.spring.delivery.store.service.StoreVO;

@Service("storeService")
public class StoreServiceImpl implements StoreService{
	@Autowired
	private StoreDAO storeDAO;

	@Override
	public StoreVO selectOneStore(int m_id) {
		
		return storeDAO.selectOneStore(m_id);
	}

	@Override
	public void resumption(int s_id) {
		storeDAO.resumption(s_id);
		
	}

	@Override
	public int Closing_Apply(int s_id) {
		return storeDAO.Closing_Apply(s_id);
		
	}

	@Override
	public StoreVO getStoreInfo(int s_id) {
		return storeDAO.getStoreInfo(s_id);
	}

	@Override
	public int StoreCount(StoreVO storePut) {
		return storeDAO.StoreCount(storePut);
	}

	@Override
	public List<StoreVO> getStore(StoreVO storePut) {
		return storeDAO.getStore(storePut);
	}


}
