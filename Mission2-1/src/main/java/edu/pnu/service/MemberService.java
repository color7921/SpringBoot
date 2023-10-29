package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

public class MemberService {

	private MemberDao memberDao = new MemberDao();

	public List<MemberVO> getMembers() {
		return memberDao.getMembers();
	}

	public MemberVO getMember(Integer id) {
		return memberDao.getMember(id);
	}

	public int addMember(MemberVO memberVO) {
		return memberDao.addMember(memberVO);
	}

	public int updateMembers(MemberVO memberVO) {
		return memberDao.updateMembers(memberVO);
	}

	public int removeMember(Integer id) {
		return memberDao.removeMember(id);
	}

	public int removeMembers(MemberVO memberVO) {
		return memberDao.removerMembers(memberVO);
	}
	
	
}
