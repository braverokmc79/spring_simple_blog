/**
* <pre>
* 1. 패키지명 : net.macaronics.join.service
* 2. 타입명 : UsersJoinServiceImpl.java
* 3. 작성일 : 2017. 12. 27. 오후 11:09:09
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package net.macaronics.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.macaronics.join.domain.UsersVO;
import net.macaronics.join.persistence.UsersJoinDAO;

@Service
public class UsersJoinServiceImpl implements UsersJoinService {

	@Autowired
	private UsersJoinDAO usersJoinDAO;
	
	// usersname 중복 체크
	@Override
	public boolean usersNameCheck(String username) throws Exception {    
		boolean isCheck=false;
		int check=usersJoinDAO.usersNameCheck(username);
		// 0보다 크면 중복이 존재 true 반환
		if(check>0) {
			isCheck=true;
		}else {
			// 0이면 중복 없음.
			isCheck=false;
		}
		return isCheck;
	}

	
	//등록
	@Override
	public void usersRegister(UsersVO usersVO) throws Exception {
		usersJoinDAO.usersRegister(usersVO);		
	}
	
	

	
}
