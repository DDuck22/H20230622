package com.yedam.member.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.member.persistence.MemberMapper;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	
	@Override
	public MemberVO login(String id, String pw) {
//		MemberVO vo = new MemberVO();
//		vo.setUserId(id);
//		vo.setUserPw(pw);
		return mapper.login(id,pw);
	}


	@Override
	public boolean addMember(MemberVO member) {
		return mapper.insert(member)==1;
	}


	@Override
	public MemberVO getMember(String id) {
		return mapper.uInfo(id);
	}


	@Override
	public boolean modifyMember(MemberVO member) {
		return mapper.updateMember(member)==1;
	}

}
