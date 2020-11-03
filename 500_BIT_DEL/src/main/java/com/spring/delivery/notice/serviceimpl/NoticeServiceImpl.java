package com.spring.delivery.notice.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.delivery.notice.service.NoticeService;
import com.spring.delivery.notice.service.NoticeVO;

// @Service : @Component 상속확장 어노테이션
//     비즈니스 로직처리 서비스 영역에 사용
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired //타입이 일치하는 객체(인스턴스) 주입
	//private NoticeDAO noticeDAO;
	//private NoticeDAOSpring noticeDAO;
	private NoticeDAOMybatis noticeDAO;
	
	public NoticeServiceImpl() {
		System.out.println(">> NoticeServiceImpl() 객체생성");
	}
	
	@Override
	public void insertNotice(NoticeVO vo) {
		noticeDAO.insertNotice(vo);
	}

	@Override
	public void updateNotice(NoticeVO vo) {
		noticeDAO.updateNotice(vo);
	}

	@Override
	public void deleteNotice(NoticeVO vo) {
		noticeDAO.deleteNotice(vo);
	}

	@Override
	public NoticeVO getNotice(NoticeVO vo) {
		return noticeDAO.getNotice(vo);
	}

	@Override
	public List<NoticeVO> getNoticeList() {
		return noticeDAO.getNoticeList();
	}

	@Override
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		System.out.println("2222");
		return noticeDAO.getNoticeList(vo);
	}

	@Override
	public void updateNoticeHit(int n_id) {
		noticeDAO.updateNoticeHit(n_id);
	}

	@Override
	public int getNoticeCount() {
		return noticeDAO.getNoticeCount();
	}


	@Override
	public List<NoticeVO> getNoticePageList(Map<String, Integer> map) {
		return noticeDAO.getNoticePageList(map);
	}

	@Override
	public List<NoticeVO> getNoticeList_T(NoticeVO notice) {
		return noticeDAO.getNoticeList_T(notice);
	}


	@Override
	public int getNoticeCount_T(NoticeVO notice) {
		// TODO Auto-generated method stub
		return noticeDAO.getNoticeCount_T(notice);
	}

}
