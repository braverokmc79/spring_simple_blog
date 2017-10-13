package net.macaronics.web.persistence;

import static org.junit.Assert.fail;

import java.util.List;

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
public class MemberDAOImplTest {

	private static final Logger log = LoggerFactory.getLogger(MemberDAOImplTest.class);
	
	@Autowired
	private MemberDAO dao;
	
	Integer count;
	
	@Test
	public void testGetTime() {
		log.info("testGetTime  {} ", dao.getTime());
	}
	

	@Test
	public void testCreateMember() {
		count =dao.getCount();			
		MemberVO  vo=new MemberVO();
		
		 if(count==0){	    	
		    	vo.setUserid("user0");
				vo.setUserpw("1111");
				vo.setUsername("name0");
				vo.setEmail("0@macaronics.net");
				dao.createMember(vo);		
		}
		++count;				  
		vo.setUserid("user"+count);
		vo.setUserpw("1111");
		vo.setUsername("name"+count);
		vo.setEmail(count+"@macaronics.net");
		dao.createMember(vo);
	}


	@Test
	public void testReadListMember() {
		List<MemberVO> list =dao.readListMember();
		log.info("testReadListMember - {}" , list.toString());
	}

	@Test
	public void testUpdateMember() {
		MemberVO  vo =new MemberVO();
		vo.setUserid("user0");
		vo.setUserpw("1111");
		vo.setUsername("2222name0");
		vo.setEmail("update0@macaronics.net");
		dao.updateMember(vo);
		
	
	}

	@Test
	public void testDeleteMember() {
		dao.deleteMember("user0");
	}

	
	@Test
	public void testGetReadMember() {
		MemberVO vo=dao.getReadMember("user1", "1111");
		log.info("testGetReadMember - {}" , vo.toString());
	}

	
	
}
