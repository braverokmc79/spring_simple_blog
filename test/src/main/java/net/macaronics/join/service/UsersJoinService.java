/**
* <pre>
* 1. 패키지명 : net.macaronics.join.service
* 2. 타입명 : UsersService.java
* 3. 작성일 : 2017. 12. 27. 오후 11:00:21
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package net.macaronics.join.service;

import net.macaronics.join.domain.UsersVO;

public interface UsersJoinService {

	//usersname 중복 체크
	public boolean usersNameCheck(String username) throws Exception;

	//등록
	public void usersRegister(UsersVO usersVO) throws Exception;
	
	
}
