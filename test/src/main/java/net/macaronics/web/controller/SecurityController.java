/**
* <pre>
* 1. 패키지명 : net.macaronics.web.controller
* 2. 타입명 : SecurityController.java
* 3. 작성일 : 2017. 11. 24. 오후 7:11:12
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package net.macaronics.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.macaronics.web.domain.UserVO;
import net.macaronics.web.service.UserSerivce;

@Controller
public class SecurityController {

	private static Logger logger  =LoggerFactory.getLogger(SecurityController.class);
	
	@Autowired
	private UserSerivce userService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@GetMapping("/loginInfo")
	public String currentUserName(Authentication authentication, Model model) throws Exception{
		
		if(authentication !=null){
			logger.info("userVO.getUsername()  {} : " , authentication.getName());
			
			//시큐리티에서 UserDetails  이용하여 로그인 정보를 불러온다. 
			UserDetails userDetails = (UserDetails) authentication.getPrincipal(); 
				
			// 아이디를 이용하여 DB 에서 정보를 불러 온다.
			UserVO userVO=userService.loadUserByUsername(authentication.getName());
						
			// DB 에서 불러온 정보를 userVO 객체에 저장한다.
			//권한 저장 및 UserDetails 정보 저장
     		userVO.setAuthorities(userDetails.getAuthorities());
			userVO.setAccountNonExpired(userDetails.isAccountNonExpired());
			userVO.setAccountNonLocked(userDetails.isAccountNonLocked());
			userVO.setCredentialsNonExpired(userDetails.isCredentialsNonExpired());
			userVO.setEnabled(userDetails.isEnabled());
			logger.info(" userDetails 출력 :  {} " , userDetails.toString());
			logger.info("출력 :  {} " , userVO.toString());
			
			model.addAttribute("userVO", userVO);	
		}

		return "home";
	}
	
      @RequestMapping(value="passwordEncoderTest")
      public String passwordEncoder(@RequestParam(value="inputPassword", required=false, defaultValue="") String inputPassword,
			Model model){
		
		if(StringUtils.hasText(inputPassword)){
			//암호화 작업
			String bCryptString= bcryptPasswordEncoder.encode(inputPassword);
			model.addAttribute("inputPassword", inputPassword);
			model.addAttribute("bCryptString",bCryptString);
		}
		
		return "test/bCryptString";
	}
	

      
}







