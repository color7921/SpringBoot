package edu.pnu.dao.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImp implements MemberInterface {

	List<MemberVO> list;

	public MemberDaoListImp() {
		list = new ArrayList<>();

		for (int i = 1; i < 5; i++) {
			MemberVO m = new MemberVO();
			m.setId(i);
			m.setPass("pass" + i);
			m.setName("name" + i);
			m.setRegidate(new Date());
			list.add(m);
		}
	}

	private int getNextId() {
		int mid = -1;
		for (MemberVO member : list) {
			if (mid < member.getId())
				mid = member.getId();
		}
		return mid + 1;
	}

	@Override
	public int addMember(MemberVO membervo) {

		if (membervo.getName() == null || membervo.getPass() == null) {
			return 0;
		}

		membervo.setId(getNextId());
		membervo.setRegidate(new Date());
		list.add(membervo);
		return 1;
	}

	@Override
	public List<MemberVO> getMembers() {

		return list;
	}

	@Override
	public MemberVO getMember(Integer i) {
		for (MemberVO member : list) {
			if (member.getId() == i)
				return member;
		}
		return null;
	}

	@Override
	public int updateMembers(MemberVO membervo) {
		MemberVO fm = getMember(membervo.getId());
		if (membervo.getName() != null)
			fm.setName(membervo.getName());
		if (membervo.getName() != null)
			fm.setPass(membervo.getPass());

		return 0;

	}

	@Override
	public int removeMember(Integer id) {
		for (int i = 0; i < list.size(); i++) {
			MemberVO m = list.get(i);
			if (m.getId() == id) {
				list.remove(i);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int removerMembers(MemberVO membervo) {
		return removeMember(membervo.getId());
	}
}
