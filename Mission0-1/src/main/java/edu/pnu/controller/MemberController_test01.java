package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import domain.MemberVO_test01;

@RestController
public class MemberController_test01 {
	
	List<MemberVO_test01> list;

	
	//생성자 생성
	public MemberController_test01() {
		list = new ArrayList<>();
	
		for(int i =1; i<6; i++) {
			MemberVO_test01 m = new MemberVO_test01();
			m.setId(i);
			m.setName("name" + i);
			m.setPass("pass" + i);
			m.setRegidate(new Date());
			list.add(m);
					
		}
	}
	
	//## 1. 전체 데이터 호출
	
	
	//## 2. Post insert
	
	
	//## 3. Get select
	
	
	//## 4. Put update
	
	
	//## 5. Delete delete
}
