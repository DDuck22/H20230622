package com.yedam.member.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Controller;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberInfoControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id =(String) session.getAttribute("loginId");
		
		// service(getMember) / mapper(select)/ jsp 등록.
		MemberService service = new MemberServiceImpl();
		MemberVO member = service.getMember(id);
		
//		MemberVO member = new MemberVO();
//		member.setUserId("user1");
//		member.setUserName("홍길동");
//		member.setUserBirth(new Date());
//		member.setUserImg("pig.jpg");
//		
		req.setAttribute("info", member);
		req.getRequestDispatcher("WEB-INF/jsp/member/memberInfo.jsp").forward(req, resp);
		
	}

}
