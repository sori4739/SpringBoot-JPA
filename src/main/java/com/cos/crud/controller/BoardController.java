package com.cos.crud.controller;

import java.util.List;
import java.util.Optional;

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

import com.cos.crud.model.Board;
import com.cos.crud.model.User;
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
	public String boardDetail(@PathVariable int id, Model model) {
		Optional<Board> board = mRepo.findById(id);
		model.addAttribute("board", board.get());
		return "/board/detail";
	}

	@PostMapping("/write")
	public String boardWrite(Board board, HttpSession session) {
		User user = (User) session.getAttribute("user");
		board.setUser(user);
		mRepo.save(board);
		return "redirect:/board/list";

	}

	@GetMapping("/writeForm")
	public String boardWriteForm(HttpSession session) {
		// 인터셉터 처리 AOP
		return "/board/writeForm";
	}

	@DeleteMapping("/delete/{id}")
	public String boardDelete(@PathVariable int id) {
		mRepo.deleteById(id);
		return "redirect:/board/list";
	}

	@PutMapping("/update")
	public String boardUpdate(Board board) {
		// 세션있어야 되는데 안해
		Optional<Board> b = mRepo.findById(board.getId());
		b.get().setContent(board.getContent());
		b.get().setTitle(board.getTitle());

		mRepo.save(b.get());
		return "redirect:/board/list";
	}

	@GetMapping("/updateForm/{id}")
	public String boardUpdateForm(@PathVariable int id, Model model) {
		// 세션있어야 되는데 안해
		Optional<Board> board = mRepo.findById(id);
		model.addAttribute("board", board.get());
		return "/board/updateForm";
	}
}
