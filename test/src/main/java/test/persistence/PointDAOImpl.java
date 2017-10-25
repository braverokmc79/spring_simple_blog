package test.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO {
	
	@Autowired
	private SqlSession session;
	
	private static String namespace ="net.macaronics.mapper.pointMapper.";
	
	@Override
	public void updatePoint(String userid, int point) throws Exception {
		
		Map<String, Object> paramMap= new HashMap<>();
		paramMap.put("userid",userid);
		paramMap.put("point", point);
		session.update(namespace+ "updatePoint", paramMap);
	}

	
	
}
