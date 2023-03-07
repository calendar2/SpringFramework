package mul.cam.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.cam.a.dao.MemberDao;
import mul.cam.a.dto.MemberDto;

@Repository // == 저장소
public class MemberDaoImpl implements MemberDao {
	// MyBatis 접근(생성)
	@Autowired	// 자동생성
	SqlSession session; // autowired를 해주면 new SqlSession하듯이 생성해준다
	
	String ns = "Member.";
	
	@Override
	public List<MemberDto> allMember() {
		
		return session.selectList("Member." + "allMember");
	}

	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return session.selectOne(ns + "idcheck", id);
	}

	@Override
	public int addMember(MemberDto dto) {
		return session.insert(ns + "addmember", dto);
		
	}

	@Override
	public MemberDto login(MemberDto dto) {
		
		return session.selectOne(ns + "login", dto);
	}
	
}
