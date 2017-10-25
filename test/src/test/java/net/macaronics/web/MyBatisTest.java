package net.macaronics.web;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MyBatisTest {

	
	private static final Logger log = LoggerFactory.getLogger(MyBatisTest.class);

	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	
	private SqlSession sqlSession;
	
	@Test
	public void testSqlSessionFactory(){
		log.info("testSqlSessionFactory , {}   " ,sqlSessionFactory);
	}
	
	@Test
	public void testSession() throws Exception{
		try(SqlSession session=sqlSessionFactory.openSession()){
			log.info("testSession() , {}   " ,session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
   @Test
	public void testSqlSession(){
	   log.info("testSqlSession() , {}   " ,sqlSession);
	}
	
	
	
}
