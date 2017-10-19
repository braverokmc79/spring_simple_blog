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
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import config.paging.PageMaker;
import net.macaronics.web.domain.MemberVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOImplTest {

	private static final Logger log = LoggerFactory.getLogger(MemberDAOImplTest.class);
	
	@Autowired
	private MemberDAO dao;
	
	Integer count=0;
	
	//@Test
	public void testGetTime() throws Exception{
		log.info("testGetTime  {} ", dao.getTime());
	}
	

	//@Test
	public void testCreateMember() throws Exception {
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


	//@Test
	public void testReadListMember() throws Exception{
		PageMaker pageMaker =new PageMaker();
		pageMaker.setPage(2);
		pageMaker.setPerPageNum(20);
		
		List<MemberVO> list =dao.readListMember(pageMaker);
		for(MemberVO member : list){
			log.info("testReadListMember - {},  {}" ,  member.getMid() ,member.getUserid());
		}
		
	}

	
	//@Test
	public void testUpdateMember() throws Exception{
		MemberVO  vo =new MemberVO();
		vo.setUserid("user0");
		vo.setUserpw("1111");
		vo.setUsername("2222name0");
		vo.setEmail("update0@macaronics.net");
		dao.updateMember(vo);
		
	
	}

	//@Test
	public void testDeleteMember() throws Exception{
		dao.deleteMember("user0");
	}

	
	//@Test
	public void testGetReadMember() throws Exception{
		MemberVO vo=dao.getReadMember("user1", "1111");
		log.info("testGetReadMember - {}" , vo.toString());
	}

	
	@Test
	public void testURI() throws Exception{
		UriComponents uriComponents=
				UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		log.info("/board/read?bno=12&perPageNum=20");
		log.info(uriComponents.toString());
	}
	
	
	@Test
	public void testURI2() throws Exception{
		
		UriComponents uriComponents=
				UriComponentsBuilder.newInstance()
				.path("/{module}/{page}")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build()
				.expand("board", "read")
				.encode();
		log.info("/board/read?bno=12&perPageNum=20");
		log.info(uriComponents.toString());
	}
	
	
	
	
}




