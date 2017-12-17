/**
* <pre>
* 1. 패키지명 : config.security3_1
* 2. 타입명 : UserService.java
* 3. 작성일 : 2017. 12. 16. 오후 6:29:44
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package config.security_sample_3_1;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import net.macaronics.web.persistence.UserDAOImpl;

//@Repository
public class UserServiceDAO {
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	
	//private static final String namespace="net.macaronics.mapper.o.memberMapper.";
	private static final String namespace = "net.macaronics.mapper.loginMapper.";

	@Autowired
	private SqlSession sqlSession;
	
	public MUser findUserByUsername(String username) throws UsernameNotFoundException{
		return sqlSession.selectOne(namespace+"getLoginUser", username);
	}

	
	
}



