package com.spring.delivery.store.service;

import java.util.List;
import java.util.Map;

public interface StoreService {
	public StoreVO selectOneStore(int m_id);
	public void resumption(int s_id);
	public int Closing_Apply(int s_id);
	public StoreVO getStoreInfo(int s_id);
	public int StoreCount(StoreVO storePut); 
	public List<StoreVO> getStore(StoreVO storePut);
}
