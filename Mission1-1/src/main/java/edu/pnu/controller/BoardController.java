package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BoardVO;
import edu.pnu.service.BoardService;

@RestController
public class BoardController {

	BoardService boardService = new BoardService();
	
	//#1. 만들어진 모든 리스트 출력
	@GetMapping("/board")
	public List<BoardVO> getBoards(){
		return boardService.getBoards();
	}
	
	//#2. Get select
	@GetMapping("/board/{Seq}")
	public BoardVO getBoard(@PathVariable Integer Seq) {
		return boardService.findBoard(Seq);
	}
	
	//#3. Post add
	@PostMapping("/board")
	public BoardVO addBoard(BoardVO boardVO) {
		return boardService.addBoard(boardVO);
	}
	
	//#4. Put update
	@PutMapping("/board")
	public BoardVO updateBoards(BoardVO boardVO) {
		return boardService.updateBoards(boardVO);
	}
	
	//#5. Delete delete
	//pathvariable = 엔터티 식별
	@DeleteMapping("/board/{seq}")
	public BoardVO removeBoard(@PathVariable Integer seq) {
		return boardService.removeBoard(seq);
	}
	
}
