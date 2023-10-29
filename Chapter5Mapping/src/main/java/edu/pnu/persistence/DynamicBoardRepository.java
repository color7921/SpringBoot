package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import edu.pnu.domain.Board;

public interface DynamicBoardRepository extends 
	JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board>{

	List<Board> findByTitle(String searchKeyword);

	@Query(value="SELECT * FROM BOARD WHERE CNT > ?", nativeQuery = true)
	List<Object[]> findByCnt(long searchKeyword);


}
