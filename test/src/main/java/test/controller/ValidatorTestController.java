/**
* <pre>
* 1. 패키지명 : test.controller
* 2. 타입명 : ValidatorTestController.java
* 3. 작성일 : 2017. 10. 26. 오후 1:37:55
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package test.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.macaronics.web.domain.MemberVO;
import net.macaronics.web.service.MemberService;

@Controller
public class ValidatorTestController {
 
	private static Logger logger =LoggerFactory.getLogger(ValidatorTestController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/validTestform", method=RequestMethod.GET)
	public String validTestForm(@ModelAttribute(name="vo") MemberVO memberVO ) throws Exception{
		
		return "test/validMember";
	}
	
	
	//bindResult 다음에 Model 이 와야 한다. 순서가 틀리면 에러가 발생한다.
	@RequestMapping(value="/validTestform", method=RequestMethod.POST)
	public String validTestAction(@ModelAttribute(name="vo") @Valid MemberVO vo,  BindingResult  bindResult, Model model) throws Exception{
	
		if(bindResult.hasErrors()){		
			return "test/validMember";	
		}
		
		//아이디 중복 체크
		if(memberService.idCheck(vo.getUserid())){
			logger.info("중복된 아이디 입니다.");
			model.addAttribute("idCheck", "중복된 아이디 입니다." );
			return "test/validMember";
		}
		
		//비밀번호 체크
		if(!vo.passwordCheck()){		
			logger.info("비밀번호와 비밀번호 확인이 일치하지 않습니다.");

			model.addAttribute("pwCheck", "비밀번호와 비밀번호 확인이 일치하지 않습니다." );
			return "test/validMember";
		}
				
		
		memberService.createMember(vo);	
	    return "redirect:/";
	}
	
	
	
	
	
}



