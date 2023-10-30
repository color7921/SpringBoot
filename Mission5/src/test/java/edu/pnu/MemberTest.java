package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.Persistence.MemberRepository;
import edu.pnu.domain.Member;

@SpringBootTest
public class MemberTest {

	@Autowired
	private MemberRepository memberRepo;

	//@Test
	public void testInsert() {
		for (int i = 0; i < 5; i++) {
			Member member = Member.builder()
					.name("name" + i)
					.pass("pass" + i)
					.regidate(new Date())
					.build();
			memberRepo.save(member);
		}
	}
	
	@Test
	public void testGetBoard() {
		Member member = memberRepo.findById(1L).get();
	}
}
