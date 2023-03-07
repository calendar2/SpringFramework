package mul.cam.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.cam.a.dao.PdsDao;
import mul.cam.a.dto.PdsDto;
import mul.cam.a.dto.PdsParam;
import mul.cam.a.service.PdsService;

@Service
public class PdsServiceImpl implements PdsService {
	@Autowired
	PdsDao dao;

	@Override
	public List<PdsDto> pdslist(PdsParam pds) {
		
		return dao.pdslist(pds);
	}

	@Override
	public boolean uploadPds(PdsDto dto) {
		int count = dao.uploadPds(dto);
		return count>0?true:false;
	}

	@Override
	public void downcount(int seq) {
		
		dao.downcount(seq);
	}

	@Override
	public int getAllPds(PdsParam pds) {
		
		return dao.getAllPds(pds);
	}

	@Override
	public PdsDto getPdsInfo(int seq) {
		
		return dao.getPdsInfo(seq);
	}

	@Override
	public boolean updatePds(PdsDto dto) {
		int n = dao.updatePds(dto);
		return n>0?true:false;
	}
	
	
}
