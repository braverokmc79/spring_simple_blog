package net.macaronics.web.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.macaronics.web.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(MemberServiceTest.class);

	@Autowired
	private MemberService memberService;
	
    Integer count=0;
	
	@Test
	public void testGetTime() throws Exception  {
		log.info("testGetTime  {} ", memberService.getTime());
	}
	
	@Test
	public void testCreateMember() throws Exception {
		count =memberService.getCount();			
		MemberVO  vo=new MemberVO();
		
		 if(count==0){	    	
		    	vo.setUserid("user0");
				vo.setUserpw("1111");
				vo.setUsername("name0");
				vo.setEmail("0@macaronics.net");
				memberService.createMember(vo);		
		}
		++count;				  
		vo.setUserid("user"+count);
		vo.setUserpw("1111");
		vo.setUsername("name"+count);
		vo.setEmail(count+"@macaronics.net");
		memberService.createMember(vo);
	}


	@Test
	public void testReadListMember() throws Exception {
		List<MemberVO> list =memberService.readListMember();
		log.info("testReadListMember - {}" , list.toString());
	}

	@Test
	public void testUpdateMember() throws Exception  {
		MemberVO  vo =new MemberVO();
		vo.setUserid("user0");
		vo.setUserpw("1111");
		vo.setUsername("2222name0");
		vo.setEmail("update0@macaronics.net");
		memberService.updateMember(vo);
		
	
	}

	@Test
	public void testDeleteMember() throws Exception {
		memberService.deleteMember("user0");
	}

	
	@Test
	public void testGetReadMember() throws Exception {
		MemberVO vo=memberService.getReadMember("user1", "1111");
		log.info("testGetReadMember - {}" , vo.toString());
	}

	
	//@Test
	public void errorReadListMemberTest() throws Exception{
		memberService.errorReadListMember();
	}

	
}
