package com.spring.delivery.favorite.service;

import java.util.List;
import java.util.Map;

public interface FavoriteService {
	
	public List<FavoriteVO> selectFavorite(int m_id);
	public void deleteFavorite(Map<String, Integer> map);
	public void insertFavorite(Map<String, Integer> map);
}
