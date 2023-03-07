package mul.cam.a.service;

import java.util.List;

import mul.cam.a.dto.PdsDto;
import mul.cam.a.dto.PdsParam;

public interface PdsService {

	List<PdsDto> pdslist(PdsParam pds);
	
	boolean uploadPds(PdsDto dto);
	
	// 다운로드수 증가
	void downcount(int seq);
	
	// 글의 총수
	int getAllPds(PdsParam pds);
	
	// 자료실 세부내용
	PdsDto getPdsInfo(int seq);
	
	// 자료실 수정
	boolean updatePds(PdsDto dto);
}
