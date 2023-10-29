package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	
		MemberService memberService = new MemberService();

		
	//## 1. 만들어진 모든 리스트 출력
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return memberService.getMembers();
	}
	
	//## 2. Post add
	
	//## 3. Get select
	
	//## 4. Put update
	
	//## 5. Delete delete
	
}
