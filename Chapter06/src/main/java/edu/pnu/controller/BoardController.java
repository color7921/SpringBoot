package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.Board;

//RestController 리턴값을 모두 스트링으로 판단
//Controller 리턴하는 문자이름이 뷰가 됨 -> 뷰의 이름으로 판단 ( ex. getBoardList.jsp 를 호출함)
//for 루프 태그를 이용하기 위해 jstl 가져옴
@Controller
public class BoardController {

	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting", "Hello");
	}
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model) {
		List<Board> boardList = new ArrayList<Board>();
		
		for (Long i = 1L; i <= 10; i++) {
			Board board = new Board();
			board.setSeq(i);
			board.setTitle("게시판 프로그램 테스트");
			board.setWriter("도우너");
			board.setContent("게시판 프로그램 테스트입니다.");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardList.add(board);
		}
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
}
