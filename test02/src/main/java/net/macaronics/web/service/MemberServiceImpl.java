package net.macaronics.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.macaronics.web.domain.MemberVO;
import net.macaronics.web.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private MemberDAO dao;
	
	
	@Override
	public String getTime() throws Exception{
		return dao.getTime();
	}

	@Override
	public void createMember(MemberVO vo) throws Exception{
		dao.createMember(vo);
	}

	
	@Override
	public MemberVO getReadMember(String userid, String userpw) throws Exception{ 
		return dao.getReadMember(userid, userpw);
	}

	@Override
	public List<MemberVO> readListMember() throws Exception {
	
		return dao.readListMember();
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception{
		dao.updateMember(vo);

	}

	@Override
	public void deleteMember(String userid) {
		dao.deleteMember(userid);

	}

	@Override
	public Integer getCount() throws Exception {
		return dao.getCount();
	}
	
	@Override
	public List<MemberVO> errorReadListMember() throws Exception {
		int a=1;
		int b=a/0;
		logger.info(" ajaxError ( )  -  {} " , b);
		return dao.readListMember();
	}

}
