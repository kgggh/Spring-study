package com.spring.delivery.paging.service;

public class PagingVO {
	private int nowPage = 1; //현재페이지
	private int nowBlock = 1; //현재 블록(페이지 담는 단위)
	
	private int storenumPerPage = 12; //하나의 페이지에 표시할 게시글 수
	private int noticenumPerPage = 20; //하나의 페이지에 표시할 게시글 수
	private int reviewnumPerPage = 7; //하나의 페이지에 표시할 게시글 수
	
	private int pagePerBlock = 5; //블록당 표시하는 페이지 갯수
	private int noticepagePerBlock = 5; //블록당 표시하는 페이지 갯수, review
	private int totalSearchPage = 0; //전체 페이지 갯수

	private int importRecord = 0;
	private int totalRecord = 0; //총 게시물 갯수(원본 게시글 수)
	private int totalPage = 0; //전체 페이지 갯수
	private int totalBlock = 0; //전체 블록 갯수
	
	private int begin = 0; //현재 페이지상의 시작 글번호
	private int end = 0; //현재 페이지상의 마지막 글번호
	
	private int beginPage = 0; //현재 블록의 시작 페이지 번호
	private int endPage = 0; //현재 블록의 끝 페이지 번호
	
	//전체 페이지 갯수 구하기
	//totalRecord 값을 페이지당 표시할 글의 개수 값을 나누고,
	//나머지가 있으면 페이지 하나 더 추가
	//점포
	public void setStoreTotalPage() {
		totalPage = totalRecord / storenumPerPage;
		if (totalRecord % storenumPerPage > 0) totalPage++;
	}

	public void setReviewTotalPage() {
		totalPage = totalRecord / reviewnumPerPage;
		if (totalRecord % reviewnumPerPage > 0) totalPage++;
	}	
	
	public void setReviewAdminTotalPage() {
		totalPage = totalRecord / (reviewnumPerPage * 2);
		if (totalRecord % reviewnumPerPage > 0) totalPage++;
	}
	
	public void setNoticeTotalPage() {
		totalPage = totalRecord / noticenumPerPage;
		if (totalRecord % noticenumPerPage > 0) totalPage++;
	}
	/*
	 * public void setTotalPage() { totalPage = totalRecord / numPerPage; if
	 * (totalRecord % numPerPage > 0) totalPage++; }
	 */
	public int getImportRecord() {
		return importRecord;
	}
	
	public void setImportRecord(int importRecord) {
		this.importRecord = importRecord;
	}
	
	public int getTotalSearchPage() {
		return totalSearchPage;
	}

	public void setTotalSearchPage(int totalSearchPage) {
		this.totalSearchPage = totalSearchPage;
	}
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getNowBlock() {
		return nowBlock;
	}
	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}

	//점포 페이지 수
	public int getStorenumPerPage() {
		return storenumPerPage;
	}

	public void setStorenumPerPage(int storenumPerPage) {
		this.storenumPerPage = storenumPerPage;
	}

	//공지사항 페이지 수
	public int getNoticenumPerPage() {
		return noticenumPerPage;
	}

	public void setNoticenumPerPage(int noticenumPerPage) {
		this.noticenumPerPage = noticenumPerPage;
	}
	
	public int getReviewnumPerPage() {
		return reviewnumPerPage;
	}

	public void setReviewnumPerPage(int reviewnumPerPage) {
		this.reviewnumPerPage = reviewnumPerPage;
	}

	public int getNoticepagePerBlock() {
		return noticepagePerBlock;
	}


	public void setNoticepagePerBlock(int noticepagePerBlock) {
		this.noticepagePerBlock = noticepagePerBlock;
	}


	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "StorePagingVO [nowPage=" + nowPage + ", nowBlock=" + nowBlock + ", storenumPerPage=" + storenumPerPage
				+ ", pagePerBlock=" + pagePerBlock + ", totalSearchPage=" + totalSearchPage + ", importRecord="
				+ importRecord + ", totalRecord=" + totalRecord + ", totalPage=" + totalPage + ", totalBlock="
				+ totalBlock + ", begin=" + begin + ", end=" + end + ", beginPage=" + beginPage + ", endPage=" + endPage
				+ "]";
	}


	
	
}
