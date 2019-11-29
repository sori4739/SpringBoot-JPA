package com.cos.crud.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.Board;
import com.cos.crud.service.BoardService;
import com.cos.crud.utils.Script;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService mService;
	
	//트랜잭션 테스트
	@PostMapping("/ict/{id}")
	public @ResponseBody String increaseCountAndTimeUpdate(@PathVariable int id) {
		mService.increaseCountAndTimeUpdate(id);
		return "테스트 완료";
	}
	
	@GetMapping("/list")
	public String boardList(Model model) {
		List<Board> boards = mService.boardList();
		model.addAttribute("boards", boards);
		return "/board/list";
	}

	@GetMapping("/detail/{id}")
	public String boardDetail(@PathVariable int id, Model model) {
		Board board = mService.boardDetail(id);
		model.addAttribute("board", board);
		return "/board/detail";
	}

	@PostMapping("/write")
	public String boardWrite(Board board, HttpSession session) {
		int result = mService.boardWrite(board, session);
		if(result == 1) {
			return "redirect:/board/list";
		}else {
			return "/board/writeForm";
		}

	}

	@GetMapping("/writeForm")
	public String boardWriteForm(HttpSession session) {
		// 인터셉터 처리 AOP
		return "/board/writeForm";
	}

	@DeleteMapping("/delete/{id}")
	public @ResponseBody String boardDelete(@PathVariable int id) {
		int result = mService.boardDelete(id);
		if(result == 1) {
			return Script.href("/board/list");
		}else {
			return Script.back("삭제실패");
		}
	}

	@PutMapping("/update")
	public @ResponseBody String boardUpdate(Board board) {
		// 세션있어야 되는데 안해
		int result = mService.boardUpdate(board);
		if(result == 1) {
			return Script.href("/board/update");			
		}else {
			return Script.back("업데이트 실패");
		}
	}

	@GetMapping("/updateForm/{id}")
	public String boardUpdateForm(@PathVariable int id, Model model) {
		// 세션있어야 되는데 안해
		Board board = mService.boardUpdateForm(id);
		model.addAttribute("board", board);
		return "/board/updateForm";
	}
}
