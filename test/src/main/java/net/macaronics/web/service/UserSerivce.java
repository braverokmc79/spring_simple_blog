/**
* <pre>
* 1. 패키지명 : net.macaronics.web.service
* 2. 타입명 : UserSerivce.java
* 3. 작성일 : 2017. 11. 24. 오후 7:28:15
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package net.macaronics.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.macaronics.web.domain.UserVO;
import net.macaronics.web.persistence.UserDAO;

@Service
public class UserSerivce{

	@Autowired
	private UserDAO userDAO;
	
	public UserVO loadUserByUsername(String username) throws Exception {
		UserVO userVO = null; 
		 // ... DB 등을 통해 사용자 정보를 셋팅
		try {
			 userVO=userDAO.getLoginUser(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO;
	}

	
}





