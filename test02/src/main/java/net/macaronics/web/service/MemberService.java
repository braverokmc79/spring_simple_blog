package net.macaronics.web.service;

import java.util.List;

import config.paging.PageMaker;
import config.paging.PageMakerAndSearch;
import net.macaronics.web.domain.MemberVO;

public interface MemberService {
		//DB 시간정보 물러오기
		public String getTime() throws Exception;
		//멤버 생성
		public void createMember(MemberVO vo) throws Exception;
		//회원 한명 정보 불러오기 
		public MemberVO getReadMember(String userid, String userpw) throws Exception;
		//회원 목록 출력
		public List<MemberVO> readListMember(PageMaker cri) throws Exception;
				
				
		//회원 업데이트
		public void updateMember(MemberVO vo) throws Exception;
		//회원 삭제
		public void deleteMember(String userid) throws Exception;
		//회원수
		public Integer getCount() throws Exception;
		//에러 테스트
		public Integer errorReadListMember() throws Exception;
		
		//회원 목록 출력 페이징 처리 및 검색처리
		public List<MemberVO> listPageSearch(PageMakerAndSearch pmas) throws Exception;;
		
		public int listPageCount(PageMakerAndSearch pageMaker) throws Exception;;
		
		
}
