package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Controller;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class ModfiyMemberControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id, phone, addr
		
		// service/ mapper/ jsp 전송.
		// modifyMember/ update/ 게시글 목록으로 이동.
		String id = req.getParameter("id");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		
		MemberVO member = new MemberVO();
		member.setUserAddr(addr);
		member.setUserPhone(phone);
		member.setUserId(id);
		
		MemberService service = new MemberServiceImpl();
		service.modifyMember(member);
		
		resp.sendRedirect("boardList.do");
	}

}
