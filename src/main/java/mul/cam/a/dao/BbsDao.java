package mul.cam.a.dao;

import java.util.List;

import mul.cam.a.dto.BbsComment;
import mul.cam.a.dto.BbsDto;
import mul.cam.a.dto.BbsParam;

public interface BbsDao {
	List<BbsDto> bbslist(BbsParam bbs);
	
	int getAllBbs(BbsParam bbs);
	
	int writeBbs(BbsDto dto);
	
	BbsDto getBbsInfo(int seq);
	void readcount(int seq);
	
	int update(BbsDto dto);
	int delete(int seq);
	
	int answer(BbsDto dto);
	
	// 댓글
	int commentWrite(BbsComment bbs);
	
	List<BbsComment> commentList(int seq);
}
