package com.spring.delivery.favorite.serviceimpl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.favorite.service.FavoriteService;
import com.spring.delivery.favorite.service.FavoriteVO;
import com.spring.delivery.store.service.StoreService;
import com.spring.delivery.store.service.StoreVO;

@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService{
	@Autowired
	private FavoriteDAO favoriteDAO;

	@Override
	public List<FavoriteVO> selectFavorite(int m_id) {
		return favoriteDAO.selectFavorite(m_id);
	}

	@Override
	public void deleteFavorite(Map<String, Integer> map) {
		favoriteDAO.deleteFavorite(map);
		
	}

	@Override
	public void insertFavorite(Map<String, Integer> map) {
		favoriteDAO.insertFavorite(map);
		
	}



}
