package com.yedam.board.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.control.BoardList;
import com.yedam.common.Controller;

public class FrontController extends HttpServlet {

	HashMap<String, Controller> menu;

	public FrontController() {
		menu = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init.");
		menu.put("/main.do", new MainControl());
		menu.put("/boardList.do", new BoardList());
		menu.put("/member.do", new MemberControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String cpath = req.getContextPath(); // application 이름.
		String path = uri.substring(cpath.length());
		System.out.println("uri: " + uri);
		System.out.println("cpaht: " + cpath);
		System.out.println("path: " + path);

		Controller msg = menu.get(path);
		msg.exec(req, resp);
	}

}
