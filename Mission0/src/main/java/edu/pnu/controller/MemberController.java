package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import lombok.NoArgsConstructor;

@RestController
public class MemberController {

	List<MemberVO> list;

	public MemberController() {
		list = new ArrayList<>();
		int idx = 1;
		for (int i = 1; i < 5; i++) {
			MemberVO m = new MemberVO();
			m.setId(i);
			m.setPass("pass" + i);
			m.setName("name" + i);
			m.setRegidate(new Date());
			list.add(m);
			
			//빌더 패턴을 이용한 객체 생성
//			list.add(MemberVO.builder()
//			.id(idx)
//			.name("name" + idx)
//			.pass("pass" + idx)
//			.regidate(new Date())
//			.build()
//			);
			
			//모든 파라미터를 필요로 하는 생성자를 이용한 객체 생성 (@NoArgsConstructor 가 없다면 다음과 같이 작성)
//			MemberVO m1 = new MemberVO(idx, "pass" + idx, "name" + idx, new Date());
//			list.add(m1);
//			idx++;
		}
	}

	// ##1. 모든 멤버 정보를 JSON 형태로 브라우저에 출력
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return list;
	}

	// Creat ; insert Post
	// Read ; select Get
	// Update ; put
	// Delete ; delete

	
	// equals = String
	// == int

	// ##2. 아이디가 {id}인 member를 찾아서 브라우저에 출력
	private MemberVO findMember(Integer id) {
		for (MemberVO member : list) {
			if (member.getId() == id)
				return member;
		}
		return null;
	}

	// MemberVO에서 id가 {id}인 데이터를 찾아서 리턴
	// http://localhost:8080/member/5 ==> id가 5인 데이터를 찾아서 돌려줘
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return findMember(id);
	}

	// ##3. 현재 입력 되어있는 객체들의 id를 조사해서 최댓값에 1을 더해서 다음 추가되는 데이터의 id를 만들어서 넘겨준다.
	private int getNextId() {
		int mid = -1;
		for (MemberVO member : list) {
			if (mid < member.getId())
				mid = member.getId();
		}
		return mid + 1;
	}

	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {

		if (memberVO.getName() == null || memberVO.getPass() == null) {
			return null;
		}

		memberVO.setId(getNextId());
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return memberVO;
	}
	
	@PostMapping("/member1")
	public ResponseEntity<?> addMember1(MemberVO memberVO) {
		
		if (memberVO.getName() == null || memberVO.getPass() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(memberVO);
		}
		
		memberVO.setId(getNextId());
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return ResponseEntity.status(HttpStatus.OK).body(memberVO);
	}

	// ##4. 수정 대상 객체 정보를 전달, 수정된 객체를 출력
	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {

		// 있는 데이터를 업데이트
		MemberVO fm = findMember(memberVO.getId());
		if (memberVO.getName() != null)
			fm.setName(memberVO.getName());
		if (memberVO.getName() != null)
			fm.setPass(memberVO.getPass());

		return fm;
	}
	
	// ##5. Delete
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {
		for (int i = 0; i< list.size(); i++) {
			MemberVO m = list.get(i);
			if (m.getId() == id) {
				list.remove(i);
				return m;
			}
		}
		return null;
	}
}
