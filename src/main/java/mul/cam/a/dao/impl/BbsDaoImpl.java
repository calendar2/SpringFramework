package mul.cam.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.cam.a.dao.BbsDao;
import mul.cam.a.dto.BbsComment;
import mul.cam.a.dto.BbsDto;
import mul.cam.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {
	@Autowired
	SqlSession session;
	
	String ns = "Bbs.";

	@Override
	public List<BbsDto> bbslist(BbsParam bbs) {
		// TODO Auto-generated method stub
		return session.selectList(ns + "bbslist", bbs);
	}

	@Override
	public int getAllBbs(BbsParam bbs) {
		// TODO Auto-generated method stub
		return session.selectOne(ns + "getAllBbs", bbs);
	}

	@Override
	public int writeBbs(BbsDto dto) {
		// TODO Auto-generated method stub
		return session.insert(ns + "writeBbs", dto);
	}

	@Override
	public BbsDto getBbsInfo(int seq) {
		// TODO Auto-generated method stub
		return session.selectOne(ns + "getBbsInfo", seq);
	}

	@Override
	public void readcount(int seq) {
		session.update(ns + "readcount", seq);
		
	}

	@Override
	public int update(BbsDto dto) {
		
		return session.update(ns + "update", dto);
	}

	@Override
	public int delete(int seq) {
		
		return session.delete(ns + "delete", seq);
	}

	@Override
	public int answer(BbsDto dto) {
		session.update(ns + "answerOne", dto);
		return session.insert(ns + "answerTwo", dto);
	}

	@Override
	public int commentWrite(BbsComment bbs) {
		
		return session.insert(ns + "commentWrite", bbs);
	}

	@Override
	public List<BbsComment> commentList(int seq) {
		
		return session.selectList(ns + "commentList", seq);
	}
}
