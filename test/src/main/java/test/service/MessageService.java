package test.service;

import java.util.List;

import test.domain.MessageVO;

public interface MessageService {

	public void create(MessageVO vo) throws Exception;
	
	public MessageVO readMessage(String userid, Integer mid) throws Exception;

	public List<MessageVO> listMessage() throws Exception;
	

	
}
