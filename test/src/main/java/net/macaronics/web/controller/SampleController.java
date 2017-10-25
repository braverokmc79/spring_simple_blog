package net.macaronics.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import config.paging.PageMaker;
import config.paging.PageMakerAndSearch;
import config.paging.oracle.OraclePageMakerAndSearch;
import net.macaronics.web.domain.MemberVO;
import net.macaronics.web.domain.ProductVO;
import net.macaronics.web.service.MemberService;

@Controller
public class SampleController {

	private static final Logger logger =LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private MemberService service;
	
	
	@RequestMapping("doA")
	public void doA()  throws Exception{
		logger.info("doA called...............");
	}
	

	@RequestMapping("doB")
	public void doB()  throws Exception{
		logger.info("doB called ...............");
	}
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg" ) String msg, String msg2 )  throws Exception{
		logger.info("doC called ............ msg - {}", msg);
		if(msg==null){
			logger.info(" msg - null");
		}else{
			logger.info(" msg -- \" \" ");
		}
		if(msg.equals("")) logger.info("msg : '''''");
		logger.info(" msg2 :  {} " , msg2);
		
		return "result";
	}
	
	
	@RequestMapping("/doD")
	public String doD(Model model)  throws Exception{
		logger.info("doD");
		ProductVO product=new ProductVO("Sample Product", 1000);
		
		model.addAttribute(product);
		
		return "result";
		
	}
	
	@RequestMapping("/doE")
	public String doE(ProductVO vo) throws Exception{
		return "result";	
	}
	
	@RequestMapping("/doF")
	public String doF(RedirectAttributes rttr) throws Exception{
		logger.info("doF call Redirect");
		rttr.addAttribute("msg1", " msg1 ");
		rttr.addFlashAttribute("msg2", "this is msg2");
		return "redirect:/doG";
	}
	
	@RequestMapping("/doG")
	public void doG(String msg2, HttpServletRequest request)  throws Exception{
		
		logger.info("msg1 :  {} " , request.getAttribute("msg1"));
		//logger.info("msg1 :  {} " , msg1);
		logger.info("msg2 :  {} " , msg2);
	}
	
	@RequestMapping("/doJson")
	public @ResponseBody ProductVO doJson()  throws Exception{
		ProductVO vo =new ProductVO("상품 2", 70000);
		return vo;
	}
	
	
	
	
	@RequestMapping("/doJSON")
	public @ResponseBody Map<String, Object> doJSON()  throws Exception{
		Map<String, Object> map=new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", "21");
		logger.info(" doJSON ( )  -  {} " , map.toString()); 
		return map;
	}
	
	
	@RequestMapping("/testError")
	public String errorTest() throws Exception{
		logger.info(" errorTest ( )  - start " ); 
		int a=1;
		int b=a/0;
		logger.info(" errorTest ( )  -  {} " , b); 
		return "home";
	}
	
	
	@RequestMapping("/ajaxError")
	public @ResponseBody String ajaxErrorTest() throws Exception{
		logger.info(" ajaxError ( )  - start " ); 
		int a=1;
		int b=a/0;
		logger.info(" ajaxError ( )  -  {} " , b); 
		return "home";
	}
	
	@RequestMapping("/memberList")
	public String errorReadListMember() throws Exception{
		logger.info(" errorReadListMember() " ); 
		Integer list =service.errorReadListMember();
		
		return "home";
	}
	
	
	
	//페이징 테스트
	@RequestMapping(value="/memberList", method=RequestMethod.GET)
	public String listMemberPage(PageMaker pageMaker, Model model) throws Exception{	
	
		//전체 페이지 개수 구한후 하단 페이징 처리 하기
		pageMaker.setTotalCount(1000);
		//페이지 메이커 attribute 로 저장  
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", service.readListMember(pageMaker));
		
		return "test/memberList";
	}
	
	
	//페이징 and Search 
	@RequestMapping(value="/memberListSearch", method=RequestMethod.GET)
	public String listPageSearch(@ModelAttribute("pageMaker") PageMakerAndSearch pageMaker, Model model) throws Exception{
		
		//전체 페이지 개수 구한후 하단 페이징 처리 하기
		pageMaker.setTotalCount(service.listPageCount(pageMaker));
		//페이지 메이커 attribute 로 저장  
		model.addAttribute("pageMaker", pageMaker);	
		model.addAttribute("list", service.listPageSearch(pageMaker));
		
		return "test/memberList";
	}
	
	
	
	//페이징 and Search 
	@RequestMapping(value="/oracleMemberListSearch", method=RequestMethod.GET)
	public String oracleListPageSearch(@ModelAttribute("pageMaker") OraclePageMakerAndSearch pageMaker, Model model) throws Exception{
		
		//전체 페이지 개수 구한후 하단 페이징 처리 하기
		pageMaker.setTotPage(service.oralcleLlistPageCount(pageMaker));
		//페이지 메이커 attribute 로 저장  
		
		model.addAttribute("pageMaker", pageMaker);	
		model.addAttribute("list", service.oralcleListPageSearch(pageMaker));
		
		return "test/oracleMemberList";
	}
	
	
	
	
	
	
}









