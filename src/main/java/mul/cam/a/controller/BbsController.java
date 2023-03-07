package mul.cam.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mul.cam.a.dto.BbsComment;
import mul.cam.a.dto.BbsDto;
import mul.cam.a.dto.BbsParam;
import mul.cam.a.dto.MemberDto;
import mul.cam.a.service.BbsService;

@Controller
public class BbsController {
	@Autowired
	BbsService service;
	
	@GetMapping(value = "bbslist.do")
	public String bbslist(BbsParam param, Model model) {
		// 글의 시작과 끝
		int pn = param.getPageNumber();	// 0 1 2 3 4
		int start = 1 + (pn * 10);
		int end = (pn + 1) * 10;
		
		param.setStart(start);
		param.setEnd(end);
		
		List<BbsDto> list = service.bbslist(param);
		int len = service.getAllBbs(param);
		
		int pageBbs = len / 10;		// 25 / 10 -> 2
		if((len % 10) > 0) {
			pageBbs = pageBbs + 1;
		}
		
		if(param.getChoice() == null || param.getChoice().equals("")
				|| param.getSearch() == null || param.getSearch().equals("")) {
			param.setChoice("검색");
			param.setSearch("");;
		}
		
		model.addAttribute("bbslist", list);	// 게시판 리스트
		model.addAttribute("pageBbs", pageBbs);	// 총 페이지수
		model.addAttribute("pageNumber", param.getPageNumber()); // 현재 페이지
		model.addAttribute("choice", param.getChoice());	// 검색 카테고리
		model.addAttribute("search", param.getSearch());	// 검색어
		
		return "bbslist";
	}
	
	@RequestMapping(value = "bbswrite.do", method = RequestMethod.GET)
	public String bbswrite() {
		return "bbswrite";
	}
	
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf(BbsDto dto, Model model) {
		boolean isS = service.writeBbs(dto);
		String msg = "";
		
		if(isS) {
			msg = "BBS_ADD_OK";
		}else {
			msg = "BBS_ADD_NO";
		}
		
		model.addAttribute("bbswrite", msg);
		
		return "message";
	}
	
	@GetMapping(value = "bbsdetail.do")
	public String bbsdetail(int seq, Model model) {
		// MemberDto mem = (MemberDto)session.getAttribute("login");
		service.readcount(seq);
		BbsDto dto = service.getBbsInfo(seq);
		
		model.addAttribute("dto", dto);
		return "bbsdetail";
	}
	
	@GetMapping(value = "updateBbs.do")
	public String updateBbs(int seq, Model model) {
		BbsDto dto = service.getBbsInfo(seq);
		
		model.addAttribute("dto", dto);
		return "updateBbs";
	}
	
	@RequestMapping(value = "updateAf.do", method = RequestMethod.POST)
	public String updateAf(BbsDto dto, Model model) {
		boolean isS = service.update(dto);
		String msg = "";
		
		if(isS) {
			msg = "BBS_UP_OK";
		}else {
			msg = "BBS_UP_NO";
		}
		
		model.addAttribute("seq", dto.getSeq());
		model.addAttribute("bbsUp", msg);
		
		return "message";
	}
	
	@RequestMapping(value = "deleteBbs.do", method = RequestMethod.GET)
	public String deleteBbs(int seq, Model model) {
		boolean isS = service.delete(seq);
		String msg = "";
		
		if(isS) {
			msg = "BBS_DEL_OK";
		}else {
			msg = "BBS_DEL_NO";
		}
		
		model.addAttribute("seq", seq);
		model.addAttribute("bbsDel", msg);
		
		return "message";
	}
	
	@GetMapping(value = "answer.do")
	public String answer(int seq, Model model) {
		BbsDto dto = service.getBbsInfo(seq);
		
		model.addAttribute("dto", dto);
		return "answer";
	}
	
	@RequestMapping(value = "answerAf.do", method = RequestMethod.POST)
	public String answerAf(BbsDto dto, Model model) {
		boolean isS = service.answer(dto);
		String msg = "";
		
		if(isS) {
			msg = "BBS_ANS_OK";
		}else {
			msg = "BBS_ANS_NO";
		}
		
		model.addAttribute("seq", dto.getSeq());
		model.addAttribute("bbsAns", msg);
		
		return "message";
	}
	
	// 댓글
	@RequestMapping(value = "commentWriteAf.do", method = RequestMethod.POST)
	public String commentWriteAf(BbsComment bbs, Model model) {
		boolean isS = service.commentWrite(bbs);
		
		
		if(isS) {
			System.out.println("댓글 작성 성공");
		}else {
			System.out.println("댓글 작성 실패");
		}
		
		
		
		return "redirect:/bbsdetail.do?seq=" + bbs.getSeq();
	}
	
	@ResponseBody
	@GetMapping(value = "commentList.do")
	public List<BbsComment> commentList(int seq) {
		List<BbsComment> list = service.commentList(seq);
		return list;
	}
}
