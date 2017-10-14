package net.macaronics.web.service;

import java.util.List;

import net.macaronics.web.domain.MemberVO;

public interface MemberService {
		//DB 시간정보 물러오기
		public String getTime();
		//멤버 생성
		public void createMember(MemberVO vo);
		//회원 한명 정보 불러오기 
		public MemberVO getReadMember(String userid, String userpw);
		//회원 목록 출력
		public List<MemberVO> readListMember();
		//회원 업데이트
		public void updateMember(MemberVO vo);
		//회원 삭제
		public void deleteMember(String userid);
		//회원수
		public Integer getCount();
		//에러 테스트
		public List<MemberVO> errorReadListMember();
}
