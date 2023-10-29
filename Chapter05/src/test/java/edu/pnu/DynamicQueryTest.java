package edu.pnu;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;
import edu.pnu.persistence.DynamicBoardRepository;

@SpringBootTest
public class DynamicQueryTest {

	@Autowired
	private DynamicBoardRepository boardRepo;
	
	
	//@Test
	
	public void testInsert() {
		Random rd = new Random();
		for(int i = 0; i<100; i++) {
		Board board = Board.builder()
					.title("title" + i)
					.content("content" + i)
					.writer("write" + i)
					.cnt(rd.nextLong(100))
					.build();
		boardRepo.save(board);
		}
	}
	
	//@Test
	public void testDynamicQuery1() {
		//실행 안되는듯
		//annotation query와의 차이는 무엇? --> 해결
		//findByTitle() <-- 괄호 안의 값이 뭐가 들어가야하는지 ? --> 해결
		//searchkerword 값을 넣는듯 ---> %Title1% 을 넣어줌 --> 해결
		
		List<Board> boardList = boardRepo.findByTitle("%title1%");

		//Closing JPA EntityManagerFactory for persistence unit 'default'
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
	@Test
	public void testDynamicQuery2() {
		//annotation query 사용하기 
		//findByCnt() <-- 괄호 사이에 어떤게 들어가야할까 ---> ?에 들어가는 값을 넣는다.
		//cnt가 50보다 큰 데이터를 출력하는 쿼리 -->  select * from board where cnt > 50
		List<Board> boardList = boardRepo.findByCnt(50);
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println();
		}
	}
	
	//paging
//	@Test
//	public void testDynamicQuery3() {
//		List<Board> boardList = boardRepo.
//	}
//	
	//@Test
	public void testDynamicQuery() {
		String searchCondition = "TITLE";
		String searchKeyword = "테스트 제목10";
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		if(searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		} else if(searchCondition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}
		
		Pageable paging = PageRequest.of(0,5);
		
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println("검색 결과");
		for ( Board board : boardList) {
			System.out.println("----> " + board.toString());
		}
	}
}
