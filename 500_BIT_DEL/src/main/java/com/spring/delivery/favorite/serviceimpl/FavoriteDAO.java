package com.spring.delivery.favorite.serviceimpl;



import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.delivery.favorite.service.FavoriteVO;
import com.spring.delivery.store.service.StoreVO;

@Repository
public class FavoriteDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	

	public List<FavoriteVO> selectFavorite(int m_id) {
		return mybatis.selectList("FavoriteDAO.selectFavorite", m_id);
	}
	
	
	public void deleteFavorite(Map<String, Integer> map) {
		mybatis.delete("FavoriteDAO.deleteFavorite", map);
	}	
		
	
	public void insertFavorite(Map<String, Integer> map) {
		mybatis.insert("FavoriteDAO.insertFavorite", map);
	}
}
