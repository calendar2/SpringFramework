package mul.cam.a.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.cam.a.dao.PdsDao;
import mul.cam.a.dto.PdsDto;
import mul.cam.a.dto.PdsParam;

@Repository
public class PdsDaoImpl implements PdsDao {
	@Autowired
	SqlSessionTemplate session;
	
	String ns = "Pds.";

	@Override
	public List<PdsDto> pdslist(PdsParam pds) {
		
		return session.selectList(ns + "pdslist", pds);
	}

	@Override
	public int uploadPds(PdsDto dto) {
		
		return session.insert(ns + "uploadPds", dto);
	}

	@Override
	public void downcount(int seq) {
		
		session.update(ns + "downcount", seq);
	}

	@Override
	public int getAllPds(PdsParam pds) {
		
		return session.selectOne(ns + "getAllPds", pds);
	}

	@Override
	public PdsDto getPdsInfo(int seq) {
		
		return session.selectOne(ns + "getPdsInfo", seq);
	}

	@Override
	public int updatePds(PdsDto dto) {
		
		return session.update(ns + "updatePds", dto);
	}
}
