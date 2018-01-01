/**
* <pre>
* 1. 패키지명 : net.macaronics.join.persistence
* 2. 타입명 : UsersDAO.java
* 3. 작성일 : 2017. 12. 27. 오후 11:00:44
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package net.macaronics.join.persistence;

import net.macaronics.join.domain.UsersVO;

public interface UsersJoinDAO {

	public Integer usersNameCheck(String username) throws Exception;

	//등록
	public void usersRegister(UsersVO usersVO);
	
}
