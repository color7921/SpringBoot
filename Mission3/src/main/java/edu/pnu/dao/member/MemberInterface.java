package edu.pnu.dao.member;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberInterface {

	//#1. Post insert
	int addMember(MemberVO membervo);

	//#2. 모든 리스트 출력
	List<MemberVO> getMembers();

	//#2-1. 1개만 출력
	// 데이터베이스 Member테이블에서 ID가 i인 행을 찾아서 리턴하는 메서드
	MemberVO getMember(Integer i);

	//#3. Put update
	int updateMembers(MemberVO membervo);

	//#4. Delete remove
	int removeMember(Integer id);

	//#5. Delete remove (스트링으로 처리)
	int removerMembers(MemberVO membervo);

}