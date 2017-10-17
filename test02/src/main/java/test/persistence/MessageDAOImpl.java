package test.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO{

	@Autowired
	private SqlSession session;
	
	private static String namespace="net.macaronics.mapper.messageMapper.";
	
	@Override
	public void create(MessageVO vo) throws Exception {
		session.insert(namespace+"create", vo);
		
	}

	@Override
	public MessageVO readMessage(Integer mid) throws Exception {
		
		return session.selectOne(namespace+"readMessage", mid);
	}

	@Override
	public void updateState(Integer mid) throws Exception {
		session.update(namespace+"updateState", mid);
	}

	
	
	
}


