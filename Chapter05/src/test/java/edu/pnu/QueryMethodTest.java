package edu.pnu;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;

	// @Test
	public void dataPrepare() {
		for (int i = 1; i <= 100; i++) {
			Board board = new Board();
			board.setTitle("테스트 제목" + i);
			board.setWriter("테스터");
			board.setContent("테스트 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
	}

	//@Test
	public void testFindByTitle() {
		List<Board> boardList = boardRepo.findByTitle("테스트 제목10");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

	//@Test
	public void testFindByContentContaining() {
		List<Board> boardList = boardRepo.findByContentContaining("17");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("===> " + board.toString());
		}
	}

	//@Test
	public void testFindByTitleContainingOrContentContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17", "17");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("->->-> " + board.toString());
		}
	}

	//@Test
	public void testFindByTitleContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println(">>>>> <<<<<" + board.toString());
		}
	}

//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
//		List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
//
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("----------->>>>> " + board.toString());
//		}
//	}
	//@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		
		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
		
		System.out.println("PAGE SIZE : " + pageInfo.getSize());
		System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
		System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
		System.out.println("NEXT : " + pageInfo.nextPageable());
		
		//List<Board> boardList = pageInfo.getContent();
		
		System.out.println("검색 결과");
		for (Board board : pageInfo) {
			System.out.println("----> " + board.toString());
		}
	}
	@Test
	public void testQueryAnnotationTest1() {
		List<Board> boardList = boardRepo.queryAnnotationTest1("테스트 제목10");
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---/////>>>>>> " + board.toString());
		}
	}
	
	//@Test
	public void testQueryAnnotationTest2() {
		List<Board> boardList = boardRepo.queryAnnotationTest2("테스트 제목10");
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---/////>>>>>> " + board.toString());
		}
	}
	
	//@Test
	public void testQueryAnnotationTest3() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest3("테스트 제목10");
		
		System.out.println("검색 결과");
		for (Object[] row : boardList) {
			System.out.println("--- >" + Arrays.toString(row));
		}
	}
	
	//@Test
	public void testQueryAnnotationTest4() {
		Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "seq");
		List<Board> boardList = boardRepo.queryAnnotationTest4(paging);
		
		System.out.println("검색결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
