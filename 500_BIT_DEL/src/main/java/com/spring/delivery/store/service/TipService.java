package com.spring.delivery.store.service;

import java.util.List;

public interface TipService {
	public List<TipVO> getTip(int s_id);
	public int getStoreCount(String dong);
	public List<Integer> getS_id(String dong);
	public TipVO getDongTip(TipVO tip);
}
