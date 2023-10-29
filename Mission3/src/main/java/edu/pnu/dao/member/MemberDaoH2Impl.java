package edu.pnu.dao.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.MemberVO;


//스푸링부트를 실행시켜서 H2와 연결하기

public class MemberDaoH2Impl implements MemberInterface {
	
	//List<MemberVO> list;
	

	Connection con;

	public MemberDaoH2Impl() {
		try {
			Class.forName("org.h2.Driver");

			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/mission2", "sa", "abcd");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//#1. Post insert
	@Override
	public int addMember(MemberVO membervo) {
		int result = 0;

		PreparedStatement psmt = null;

		try {
			String query = "INSERT INTO Member ( pass, name) values (?,?)";

			psmt = con.prepareStatement(query);
			
			psmt.setString(1, membervo.getPass());
			psmt.setString(2, membervo.getName());

			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//#2. 모든 리스트 출력
	@Override
	public List<MemberVO> getMembers() {

		 List<MemberVO> list = new ArrayList<>();
		
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Member");
			while (rs.next()) {
				MemberVO m = MemberVO.builder()
						.id(rs.getInt("id"))
						.pass(rs.getString("pass"))
						.name(rs.getString("name"))
						.regidate(rs.getDate("regidate"))
						.build();
						list.add(m);
						
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	};

	//#2-1. 1개만 출력
	// 데이터베이스 Member테이블에서 ID가 i인 행을 찾아서 리턴하는 메서드
	@Override
	public MemberVO getMember(Integer i) {
		// 질의 결과를 저장하는 객체
		ResultSet rs = null;

		// 데이터베이스에다가 질의를 실행하는 객체
		PreparedStatement psmt = null;

		try {
			// 질의문 작성
			String query = "SELECT * FROM Member WHERE ID = ?";
			// 질의 객체 생성
			psmt = con.prepareStatement(query);
			// 질의 변수 ID(?) 설정
			psmt.setInt(1, i);
			// 질의 실행, 질의 결과는 rs에 저장
			rs = psmt.executeQuery();
			// 커서프로세싱 시작, 검색대상이 한 개이기 때문에 while을 안하고 rs.next만 함.
			rs.next();

			//MemberVO에 있는 MemberVO 생성자로 membervo 객체 생성하기
			MemberVO membervo = MemberVO.builder()
					
			//rs에 저장된 Int형식으로 되어있는 id 열을 출력하는 값을 membervo에 저장하기
										.id(rs.getInt("id"))
			
			//rs에 저장된 String 형식으로 되어있는 pass 열을 출력하는 값을 membervo에 저장하기
										.pass(rs.getString("pass"))
			
			//rs에 저장된 String 형식으로 되어있는 name 열을 출력하는 값을 membervo에 저장하기
										.name(rs.getString("name"))
			
			//rs에 저장된 Date 형식으로 되어있는 regidate 열을 출력하는 값을 membervo에 저장하기
										.regidate(rs.getDate("regidate"))
			
			//저장된 데이터를 가지고 membervo 객체 생성
										.build();

			//membervo 객체 반환하기
			return membervo;
			
			//예외 처리
		} catch (SQLException e) {
			//예외값 추적
			e.printStackTrace();
		}
		//결과값 반환
		return null;
	}

	//#3. Put update
	@Override
	public int updateMembers(MemberVO membervo) {
		//질의 결과를 저장하는 객체
		
		//데이터베이스에다가 질의를 실행하는 객체
		PreparedStatement psmt = null;
		
		try {
			//질의문 작성(현재는 pass만 업데이트가 가능함)
			String query = "UPDATE MEMBER SET PASS = ? WHERE ID = ?";
			//질의 객체 생성
			psmt = con.prepareStatement(query);
//@@@@@@@@  왜 membervo.getID() 안될까?
			psmt.setString(1, membervo.getPass());
//@@@@@@@@  membervo.getPass()안되는 이유
			//유추1. 데이터 타입 때문?
			psmt.setInt(2, membervo.getId());
			
			//이것도 데이터 타입 문제?
			//int와 memberVO의 차이가 뭔지? 정수형과 memberVO?
			return psmt.executeUpdate();
			
		}
		catch (Exception e) {
		e.printStackTrace();	
		}
		return 0;
	}

//#4. Delete remove
	@Override
	public int removeMember(Integer id) {
		PreparedStatement psmt = null;
		
		try {
			String query = "DELETE FROM MEMBER WHERE id = ?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
		
			return psmt.executeUpdate();
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//#5. Delete remove (스트링으로 처리)
	@Override
	public int removerMembers(MemberVO membervo) {
		PreparedStatement psmt = null;
		try {
			String query = "DELETE FROM MEMBER WHERE id = ?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, membervo.getId());
			
			return psmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
}
