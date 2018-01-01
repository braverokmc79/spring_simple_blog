/**
* <pre>
* 1. 패키지명 : net.macaronics.web.controller
* 2. 타입명 : MemberJoinController.java
* 3. 작성일 : 2017. 12. 25. 오후 3:30:47
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package net.macaronics.join.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.macaronics.join.domain.UsersVO;
import net.macaronics.join.service.UsersJoinService;

@Controller
@RequestMapping("/member/*")
public class UsersJoinController {

	private static final Logger logger  =LoggerFactory.getLogger(UsersJoinController.class);
	
	private static final String ViewPage="memberJoin/joinForm";
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	@Autowired
	private UsersJoinService usersJoinService;
	
	
	@RequestMapping(value="joinForm.do", method=RequestMethod.GET)
	public String memberForm(UsersVO usersVO) throws Exception{		
		return ViewPage;
	}
	
	
	//bindResult 다음에 Model 이 와야 한다. 순서가 틀리면 에러가 발생한다.
	@RequestMapping(value="join.do", method=RequestMethod.POST)
	public String memberInsert(@ModelAttribute(name="usersVO") @Valid UsersVO usersVO, BindingResult bindResult, Model model ) throws Exception{
		
		if(bindResult.hasErrors()) {
			return ViewPage;
		}
		
		//username 중복 체크
		if(usersJoinService.usersNameCheck(usersVO.getUsername())) {
			// 0보다 크면 중복이 존재 true 반환
			logger.info("중복된 아이디 입니다.");
			model.addAttribute("idCheck", "중복된 아이디 입니다." );
			return ViewPage;
		}
		
		//비밀번호 체크
		if(!usersVO.passwordCheck()) {
			logger.info("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			model.addAttribute("pwCheck", "비밀번호와 비밀번호 확인이 일치하지 않습니다." );
			return ViewPage;
		}
		
		//비밀번호 암오화 작업
		if(StringUtils.hasText(usersVO.getPassword())) {
			String bCryptString=bCryptPasswordEncoder.encode(usersVO.getPassword());
			usersVO.setPassword(bCryptString);
		}
		
		usersJoinService.usersRegister(usersVO);
		return "redirect:/";
	}
	
	
	
	
}


