package net.macaronics.web.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import config.paging.PageMaker;
import config.paging.PageMakerAndSearch;
import net.macaronics.web.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);

	// private static final String
	// namespace="net.macaronics.mapper.o.memberMapper.";
	private static final String namespace = "net.macaronics.mapper.memberMapper.";

	@Autowired
	private SqlSession sqlSession;

	// DB 시간정보 물러오기
	@Override
	public String getTime()  throws Exception{
		return sqlSession.selectOne(namespace + "getTime");
	}

	// 멤버 생성
	@Override
	public void createMember(MemberVO vo) throws Exception {
		sqlSession.insert(namespace + "createMember", vo);
	}

	// 회원 한명 정보 불러오기
	@Override
	public MemberVO getReadMember(String userid, String userpw)  throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		return sqlSession.selectOne(namespace + "getReadMember", map);
	}

	// 회원 목록 출력
	@Override
	public List<MemberVO> readListMember(PageMaker pageMaker) throws Exception {
		return sqlSession.selectList(namespace + "readListMember", pageMaker);
	}

	
	
	// 회원 업데이트
	@Override
	public void updateMember(MemberVO vo) throws Exception{
		sqlSession.update(namespace + "updateMember", vo);
	}

	// 회원 삭제
	@Override
	public void deleteMember(String userid) throws Exception{
		sqlSession.delete(namespace + "deleteMember", userid);
	}

	// 회원수
	@Override
	public Integer getCount() throws Exception {
		return sqlSession.selectOne(namespace + "getCount");
	}

	
	//회원 목록 출력 페이징 처리 및 검색처리
	@Override
	public List<MemberVO> listPageSearch(PageMakerAndSearch pmas) throws Exception{
		return sqlSession.selectList(namespace + "listPageSearch", pmas);
	}

	@Override
	public Integer listPageCount(PageMakerAndSearch pageMaker) throws Exception {
		
		return sqlSession.selectOne(namespace +"listPageCount", pageMaker);
	}
	
	

}
