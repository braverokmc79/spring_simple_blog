package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhncorp.lucy.security.xss.XssPreventer;

import test.domain.MessageVO;
import test.service.MessageService;

@Controller
public class XssTestController {

	@Autowired
	private MessageService service;
	
	
	@RequestMapping(value="xssform",method=RequestMethod.GET)
	public String xssTest() throws Exception{
		return "test/xss";
	}
	
	@RequestMapping(value="xssform", method=RequestMethod.POST)
	public String xssTes2(Model model, MessageVO vo) throws Exception{
		
		vo.setMessage(XssPreventer.unescape(vo.getMessage()));
		service.create(vo);
		model.addAttribute("message", service.listMessage());
		
		return "test/xssresult";
	}
		
	
	
	
	
	
}
