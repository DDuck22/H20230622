package com.yedam.common;

import java.util.List;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;

public class TestMain {
	public static void main(String[] args) {
		BoardService service = new BoardServiceMybatis();
		System.out.println(service.totalCnt());
	}
}
