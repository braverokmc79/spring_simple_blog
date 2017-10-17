package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.domain.MessageVO;
import test.persistence.MessageDAO;
import test.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageDAO messageDAO;
	
	@Autowired
	private PointDAO pointDAO;
	
	@Transactional
	@Override
	public void create(MessageVO vo) throws Exception {
		//메시지 보낸 사람 10 점 추가
		messageDAO.create(vo);
		pointDAO.updatePoint(vo.getSender(), 10);
	
	}

	
	@Override
	public MessageVO readMessage(String userid, Integer mid) throws Exception {
		//메시지를 읽으면 읽은시간을 업데이트
		messageDAO.updateState(mid);
		//포이트 5점 증가
		pointDAO.updatePoint(userid, 5); 
		return messageDAO.readMessage(mid);
	}

	
	
}
