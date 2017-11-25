/**
* <pre>
* 1. 패키지명 : net.macaronics.web.persistence
* 2. 타입명 : UserDAOImpl.java
* 3. 작성일 : 2017. 11. 25. 오후 1:53:53
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package net.macaronics.web.persistence;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.macaronics.web.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	//private static final String namespace="net.macaronics.mapper.o.memberMapper.";
	private static final String namespace = "net.macaronics.mapper.loginMapper.";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserVO getLoginUser(String username) throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getLoginUser", username);
	}
	
	

}


