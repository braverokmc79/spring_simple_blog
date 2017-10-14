package net.macaronics.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import net.macaronics.web.controller.SampleController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SampleControllerTest {

	private static final Logger logger= LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		//실행전 매번 mockMvc 객체를 생성 한다.
		this.mockMvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("setUp ----");
	}
	
	@Test
	public void test() throws Exception{
		//perform 은 get. post 방식의 호출을 사용해 테스트할  url 값을 넣으면 된다.
		mockMvc.perform(MockMvcRequestBuilders.get("/doJSON"));
	}
	
	
	
}


