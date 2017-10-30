package net.macaronics.web.persistence;

import java.util.List;

import config.paging.PageMaker;
import config.paging.PageMakerAndSearch;
import config.paging.oracle.OraclePageMakerAndSearch;
import net.macaronics.web.domain.MemberVO;

public interface MemberDAO {  
	//DB 시간정보 물러오기
	public String getTime() throws Exception;;
	//멤버 생성
	public void createMember(MemberVO vo) throws Exception;;
	//회원 한명 정보 불러오기 
	public MemberVO getReadMember(String userid, String userpw) throws Exception;;
	//회원 목록 출력
	public List<MemberVO> readListMember(PageMaker cri) throws Exception;;
	//회원 업데이트
	public void updateMember(MemberVO vo) throws Exception;;
	//회원 삭제
	public void deleteMember(String userid) throws Exception;
	//회원수
	public Integer getCount() throws Exception;;
	
	
	//회원 목록 출력 페이징 처리 및 검색처리
	public List<MemberVO> listPageSearch(PageMakerAndSearch pmas) throws Exception;
	public Integer listPageCount(PageMakerAndSearch pageMaker) throws Exception;
	

	
	//  오라클 회원 목록 출력 페이징 처리 및 검색처
	public List<MemberVO> oralcleListPageSearch(OraclePageMakerAndSearch pmas)throws Exception;
	public int oralcleLlistPageCount(OraclePageMakerAndSearch pageMaker) throws Exception;

	
	//아이디 중복 체크
	public Integer idCheck(String userid) throws Exception;;
	
	
	
}
