package com.cos.crud.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.crud.model.Board;
import com.cos.crud.model.User;
import com.cos.crud.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository mRepo;
	
	@Transactional
	public void increaseCountAndTimeUpdate(int id) {
		try {
			mRepo.increaseCount(id);
			mRepo.timeUpdate(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	//DB관련로직만 서비스에 필요하다.
	public List<Board> boardList() {
		List<Board> boards = mRepo.findAll();
		
		return boards;
	}

	
	public Board boardDetail(int id) {
		Optional<Board> board = mRepo.findById(id);	
		return board.get();
	}

	
	public int boardWrite(Board board, HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			board.setUser(user);
			mRepo.save(board);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int boardDelete(@PathVariable int id) {
		try {
			mRepo.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public Board boardUpdateForm(int id) {
		// 세션있어야 되는데 안해
		Optional<Board> board = mRepo.findById(id);
		
		return board.get();
	}

	
	public int boardUpdate(Board board) {
		// 세션있어야 되는데 안해
		try {
			Optional<Board> b = mRepo.findById(board.getId());
			b.get().setContent(board.getContent());
			b.get().setTitle(board.getTitle());
			mRepo.save(b.get());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	
	
}
