package com.yedam.board.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Controller;

public class BoardList implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("index 컨트롤입니다.");
	}

}
