package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@SpringBootTest
public class MemberDaoTest {

	@DisplayName("MemberDao Insert Test")
	//@Test
	public void testInsert() {
		MemberDao dao = new MemberDao();
		int ret = dao.addMember(MemberVO.builder()
				.id(2)
				.pass("1234")
				.name("홍길동")
				.build());
		System.out.println("ret:" + ret);
	}
	
	@DisplayName("MemberDao Select All Test")
	//@Test
	public void testSelectAll() {
		MemberDao dao = new MemberDao();
		
		List<MemberVO> list = dao.getMembers();
		for (MemberVO m : list) {
			System.out.println(m);
		}
	}
	@DisplayName("MemberDao Select Test")
	//@Test
	public void testSelect() {
		MemberDao dao = new MemberDao();
		MemberVO m = dao.getMember(1);
		System.out.println(m);
	}
	
	@DisplayName("MemberDao Update Test")
	//@Test
	public void testUpdate() {
		MemberDao dao = new MemberDao();
		MemberVO m = new MemberVO();
		
		m.setId(2);
		m.setPass("1234");
		
		dao.updateMember(m);
		
	}
	@DisplayName("MemberDao Delete Test")
	//@Test
	public void testDelete() {
		MemberDao dao = new MemberDao();

		dao.removeMember(2);
	}
}
