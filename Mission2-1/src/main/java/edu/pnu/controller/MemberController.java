package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	//Service 객체 만들기
	private MemberService memberService = new MemberService();
	
	//#1. 모든 멤버 정보를  출력
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return memberService.getMembers();
	}
	
	//#2. 아이디가 {id}인 member를 출력
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return memberService.getMember(id);
		}
	
	//#3. Post add 
	@PostMapping("/member")
	public int addMember(MemberVO memberVO) {
		return memberService.addMember(memberVO);
	}
	
	//#4. Put update 
	@PutMapping("/member")
	public int updateMembers(MemberVO memberVO) {
		return memberService.updateMembers(memberVO);
	}
	
	//#5. Delete delete 
	@DeleteMapping("/member/{id}")
	public int removeMember(@PathVariable Integer id) {
		return memberService.removeMember(id);
	}
	
	//#6. Delete delete2
	@DeleteMapping("/member")
	public int removerMembers(MemberVO memberVO) {
		return memberService.removeMembers(memberVO);
	}
}
