/**
* <pre>
* 1. 패키지명 : net.macaronics.join.persistence
* 2. 타입명 : UsersJoinDAOImpl.java
* 3. 작성일 : 2018. 1. 1. 오후 6:11:46
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package net.macaronics.join.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.macaronics.join.domain.UsersVO;

@Repository
public class UsersJoinDAOImpl implements UsersJoinDAO {

	private static final String namespace = "net.macaronics.mapper.joinMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public Integer usersNameCheck(String username) throws Exception  {
		
		return sqlSession.selectOne(namespace+"usersNameCheck", username);
	}

	//등록
	@Override
	public void usersRegister(UsersVO usersVO) {
		sqlSession.insert(namespace+"usersRegister", usersVO);
	}
	
	
	
	
	
}
