package net.macaronics.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import config.paging.PageMaker;
import config.paging.PageMakerAndSearch;
import config.paging.oracle.OraclePageMakerAndSearch;
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
	public List<MemberVO> readListMember(PageMaker pageMaker) throws Exception {
		
		return dao.readListMember(pageMaker);
	}

	
	
	@Override
	public void updateMember(MemberVO vo) throws Exception{
		dao.updateMember(vo);

	}

	@Override
	public void deleteMember(String userid) throws Exception {
		dao.deleteMember(userid);

	}

	@Override
	public Integer getCount() throws Exception {
		return dao.getCount();
	}
	
	@Override
	public Integer errorReadListMember() throws Exception {
		int a=1;
		int b=a/0;
		logger.info(" ajaxError ( )  -  {} " , b);
		return dao.getCount();
	}

	
	//회원 목록 출력 페이징 처리 및 검색처리
	@Override
	public List<MemberVO> listPageSearch(PageMakerAndSearch pmas) throws Exception{
		return dao.listPageSearch(pmas);
	}

	@Override
	public int listPageCount(PageMakerAndSearch pageMaker) throws Exception {
		
		return dao.listPageCount(pageMaker);
	}

	
	
	//  오라클 회원 목록 출력 페이징 처리 및 검색처리
	@Override
	public List<MemberVO> oralcleListPageSearch(OraclePageMakerAndSearch pmas) throws Exception {
		return dao.oralcleListPageSearch(pmas);
	}

    //  오라클 회원 목록 출력 페이징 처리 및 검색처리
	@Override
	public int oralcleLlistPageCount(OraclePageMakerAndSearch pageMaker) throws Exception {
		return dao.oralcleLlistPageCount(pageMaker);
	}
	
	

}
