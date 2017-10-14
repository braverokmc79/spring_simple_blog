package net.macaronics.web.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.macaronics.web.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private static final String namespace="net.macaronics.mapper.o.memberMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	//DB 시간정보 물러오기
	@Override
	public String getTime() {	
		return sqlSession.selectOne(namespace+"getTime");
	}

	//멤버 생성
	@Override
	public void createMember(MemberVO vo) {
		sqlSession.insert(namespace+"createMember", vo);
	}
	
	
	//회원 한명 정보 불러오기 
	@Override
	public MemberVO getReadMember(String userid, String userpw) {
		Map<String, Object> map=new HashMap<>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		return sqlSession.selectOne(namespace+"getReadMember", map);
	}
	
	
	//회원 목록 출력
	@Override
	public List<MemberVO> readListMember() {
		return sqlSession.selectList(namespace+"readListMember");
	}
	
	
	//회원 업데이트
	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update(namespace+"updateMember", vo);
	}
	
	
	//회원 삭제
	@Override
	public void deleteMember(String userid) {
		sqlSession.delete(namespace+"deleteMember", userid);
	}

	
	//회원수
	@Override
	public Integer getCount() {
	  return sqlSession.selectOne(namespace+"getCount");
	}

	
	

}
