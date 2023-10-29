package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.BoardVO;

public class BoardService {

	List<BoardVO> list;

	// ## 1. 리스트에 값을 저장하기 위해 만든 생성자
	public BoardService() {
		list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			BoardVO m = new BoardVO();
			m.setSeq(i);
			m.setTitle("name" + i);
			m.setWriter("1234" + 1);
			m.setContent("content" + i);
			m.setCreateDate(new Date());
			list.add(m);
		}
	}

	// ## 1. 모든 리스트 출력
	public List<BoardVO> getBoards() {
		return list;
	}

	// ## 2. Get select
	public BoardVO findBoard(Integer Seq) {
		for (BoardVO board : list) {
			if (board.getSeq() == Seq)
				return board;
		}
		return null;
	}

	// ## 3. Post insert
	private int getNextSeq() {
		int mseq = -1;
		for (BoardVO board : list) {
			if (mseq < board.getSeq())
				mseq = board.getSeq();
		}
		return mseq + 1;
	}

	// Integer(BoardVO의 int를 객체 형식으로 바꿔줘야함)
	// int (primitive 형식이라서 boardVO.getSeq() == null 이 실행안됨 )

	public BoardVO addBoard(BoardVO boardVO) {

		if (boardVO.getSeq() == null || boardVO.getWriter() == null) {
			return null;
		}

		boardVO.setSeq(getNextSeq());
		boardVO.setCreateDate(new Date());
		list.add(boardVO);
		return boardVO;
	}

	// ## 4. Put update
	public BoardVO updateBoards(BoardVO boardVO) {

		BoardVO fm = findBoard(boardVO.getSeq());
		if (boardVO.getSeq() != null)
			fm.setSeq(boardVO.getSeq());
		if (boardVO.getSeq() != null)
			fm.setWriter(boardVO.getWriter());

		return fm;
	}

	// ## 5. Delete delete
	public BoardVO removeBoard(@PathVariable Integer seq) {
		for (int i = 0; i < list.size(); i++) {
			BoardVO m = list.get(i);
			if (m.getSeq() == seq) {
				list.remove(i);
				return m;
			}
		}
		return null;
	}

}
