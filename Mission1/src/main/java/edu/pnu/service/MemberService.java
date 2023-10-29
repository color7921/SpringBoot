package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberService {

	private List<MemberVO> list;
	
	public MemberService() {
		list = new ArrayList<>();
		for (int i = 1; i <=5 ; i++) {
			MemberVO m = new MemberVO();
			m.setId(i);
			m.setName("name"+i);
			m.setPass("1234");
			m.setRegidate(new Date());
			list.add(m);
		}
	}
	
	//## 1. 모든 리스트 출력
	public List<MemberVO> getMembers(){
		return list;
	}
	
	//## 2. Post insert
	
	//## 3. Get select
	
	//## 4. Put update
	
	//## 5. Delete delete
	
}
