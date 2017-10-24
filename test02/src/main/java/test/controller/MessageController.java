/**
* <pre>
* 1. 패키지명 : net.macaronics.web.controller
* 2. 타입명 : test2.java
* 3. 작성일 : 2017. 10. 24. 오후 7:40:39
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.domain.MessageVO;
import test.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService service;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo){
		ResponseEntity<String> entity=null;
		try{
			service.create(vo);
			entity =new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity; 
	}
	
	
}
