package net.macaronics.web.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.macaronics.web.domain.ProductVO;

@Controller
public class SampleController {

	private static final Logger logger =LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public void doA(){
		logger.info("doA called...............");
	}
	

	@RequestMapping("doB")
	public void doB(){
		logger.info("doB called ...............");
	}
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg" ) String msg, String msg2 ){
		if(msg==null){
			logger.info(" msg - null");
		}else{
			logger.info(" msg -- \" \" ");
		}
		if(msg.equals("")) logger.info("msg : '''''");
		logger.info(" msg2 :  {} " , msg2);
		
		logger.info("doC called ............ msg - {}", msg);
		return "result";
	}
	
	
	@RequestMapping("/doD")
	public String doD(Model model){
		
		ProductVO product=new ProductVO("Sample Product", 1000);
		
		logger.info("doD");
		
		model.addAttribute(product);
		
		return "result";
		
	}
	
	@RequestMapping("/doE")
	public String doE(ProductVO vo){
		return "result";	
	}
	
	@RequestMapping("/doF")
	public String doF(RedirectAttributes rttr){
		logger.info("doF call Redirect");
		rttr.addAttribute("msg1", " msg1 ");
		rttr.addFlashAttribute("msg2", "this is msg2");
		return "redirect:/doG";
	}
	
	@RequestMapping("/doG")
	public void doG(String msg2, HttpServletRequest request){
		
		logger.info("msg1 :  {} " , request.getAttribute("msg1"));
		//logger.info("msg1 :  {} " , msg1);
		logger.info("msg2 :  {} " , msg2);
	}
	
	@RequestMapping("/doJson")
	public @ResponseBody ProductVO doJson(){
		ProductVO vo =new ProductVO("상품 2", 70000);
		return vo;
	}
	
	@RequestMapping("/doJSON")
	public @ResponseBody Map<String, Object> doJSON(){
		Map<String, Object> map=new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", "21");
		logger.info(" doJSON ( )  -  {} " , map.toString()); 
		return map;
	}
	
	
	
}









