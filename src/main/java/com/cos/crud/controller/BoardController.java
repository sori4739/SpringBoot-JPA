package com.cos.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.cos.crud.model.Board;
import com.cos.crud.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardRepository mRepo;
	
	@GetMapping("/list")
	public String boardList(Model model) {
		List<Board> boards = mRepo.findAll();
		model.addAttribute("boards", boards);
		return "/board/list";
	}
	@GetMapping("/detail/{id}")
	public String boardDetail(@PathVariable int id) {
		return null;
	}
	@PostMapping("/write")
	public String boardWrite(Board board) {
		return null;
	}
	@GetMapping("/writeForm")
	public String boardWriteForm() {
		return null;
	}
	@DeleteMapping("/delete/{id}")
	public String boardDelete(@PathVariable int id) {
		return null;
	}
	@PutMapping("/update")
	public String boardUpdate(Board board) {
		return null;
	}
	@GetMapping("/updateForm/{id}")
	public String boardUpdateForm(@PathVariable int id) {
		return null;
	}
}
