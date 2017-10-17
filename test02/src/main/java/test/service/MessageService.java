package test.service;

import test.domain.MessageVO;

public interface MessageService {

	public void create(MessageVO vo) throws Exception;
	
	public MessageVO readMessage(String userid, Integer mid) throws Exception;
	

	
}
