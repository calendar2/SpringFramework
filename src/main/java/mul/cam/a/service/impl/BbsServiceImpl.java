package mul.cam.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.cam.a.dao.BbsDao;
import mul.cam.a.dto.BbsComment;
import mul.cam.a.dto.BbsDto;
import mul.cam.a.dto.BbsParam;
import mul.cam.a.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {
	@Autowired
	BbsDao dao;

	@Override
	public List<BbsDto> bbslist(BbsParam bbs) {
		// TODO Auto-generated method stub
		return dao.bbslist(bbs);
	}

	@Override
	public int getAllBbs(BbsParam bbs) {
		// TODO Auto-generated method stub
		return dao.getAllBbs(bbs);
	}

	@Override
	public boolean writeBbs(BbsDto dto) {
		int count = dao.writeBbs(dto);
		return count>0?true:false;
	}

	@Override
	public BbsDto getBbsInfo(int seq) {
		
		return dao.getBbsInfo(seq);
	}

	@Override
	public void readcount(int seq) {
		dao.readcount(seq);
		
	}

	@Override
	public boolean update(BbsDto dto) {
		int count = dao.update(dto);
		return count>0?true:false;
	}

	@Override
	public boolean delete(int seq) {
		int count = dao.delete(seq);
		return count>0?true:false;
	}

	@Override
	public boolean answer(BbsDto dto) {
		int count = dao.answer(dto);
		return count>0?true:false;
	}

	@Override
	public boolean commentWrite(BbsComment bbs) {
		int count = dao.commentWrite(bbs);
		return count>0?true:false;
	}

	@Override
	public List<BbsComment> commentList(int seq) {
		
		return dao.commentList(seq);
	}
}
