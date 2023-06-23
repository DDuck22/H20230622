package com.yedam.board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.board.vo.BoardVO;
import com.yedam.common.DAO;

public class BoardDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	private void close() {
		try {
			conn.setAutoCommit(false);
			conn.commit();
			if (conn != null) {
				conn.close();
			} else if (psmt != null) {
				psmt.close();
			} else if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 목록, 단건조회, 등록, 수정, 삭제
	public List<BoardVO> boardList() {
		List<BoardVO> list = new ArrayList<>();
		conn = DAO.getConnect();
		sql = "select * from tbl_board order by brd_no desc";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdNo(rs.getInt("brd_no"));
				vo.setBrdTitle(rs.getString("brd_title"));
				vo.setBrdWriter(rs.getString("brd_writer"));
				vo.setBrdContent(rs.getString("brd_content"));
				vo.setCreateDate(rs.getDate("create_date"));
				vo.setClickCnt(rs.getInt("click_cnt"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}

	public List<BoardVO> boardListPaging(int page) {
		List<BoardVO> list = new ArrayList<>();
		conn = DAO.getConnect();
		sql = "select *\r\n" //
				+ "from (\r\n" //
				+ "    select ROWNUM rn, a.*\r\n" //
				+ "    from(\r\n" //
				+ "        select * from tbl_board\r\n" //
				+ "        order by brd_no desc\r\n" //
				+ "        ) a \r\n" //
				+ "    ) b\r\n" //
				+ "where b.rn > (? -1) * 10\r\n" //
				+ "and b.rn <= ?*10";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, page);
			psmt.setInt(2, page);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdNo(rs.getInt("brd_no"));
				vo.setBrdTitle(rs.getString("brd_title"));
				vo.setBrdWriter(rs.getString("brd_writer"));
				vo.setBrdContent(rs.getString("brd_content"));
				vo.setCreateDate(rs.getDate("create_date"));
				vo.setClickCnt(rs.getInt("click_cnt"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}
	
	//전체 건수 계산.
	public int getTotalCnt() {
		conn=DAO.getConnect();
		sql="select count(1) from tbl_board";
		try {
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			int cnt = rs.getInt(1);
			return cnt;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	public boolean insertBoard(BoardVO vo) {
		conn = DAO.getConnect();
		sql = "insert into tbl_board (brd_no, brd_title, brd_writer, brd_content) " //
				+ "values(board_seq.nextval,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBrdTitle());
			psmt.setString(2, vo.getBrdWriter());
			psmt.setString(3, vo.getBrdContent());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	public boolean updateBoard(BoardVO vo) {
		conn = DAO.getConnect();
		sql = "update tbl_board set brd_title=?, brd_content=? where brd_no=? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBrdTitle());
			psmt.setString(2, vo.getBrdContent());
			psmt.setLong(3, vo.getBrdNo());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	public BoardVO selectBoard(long brdNo) {
		conn = DAO.getConnect();
		sql = "select * from tbl_board where brd_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdNo(rs.getInt("brd_no"));
				vo.setBrdTitle(rs.getString("brd_title"));
				vo.setBrdWriter(rs.getString("brd_writer"));
				vo.setBrdContent(rs.getString("brd_content"));
				vo.setCreateDate(rs.getDate("create_date"));
				vo.setClickCnt(rs.getInt("click_cnt"));

				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	// 조회수 증가.
	public void clickCnt(long brdNo) {
		sql = "update tbl_board set click_cnt=click_cnt+1 where brd_no=?";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);
			int r = psmt.executeUpdate();
			System.out.println(r + " 건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public boolean deleteBoard(long brdNo) {
		sql = "delete tbl_board where brd_no=?";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
