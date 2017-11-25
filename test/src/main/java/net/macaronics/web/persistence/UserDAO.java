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
package net.macaronics.web.persistence;

import net.macaronics.web.domain.UserVO;


public interface UserDAO {

	public UserVO getLoginUser(String username) throws Exception;
	
}
