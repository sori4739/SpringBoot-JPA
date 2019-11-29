package com.cos.crud.controller;




import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.User;

import com.cos.crud.service.UserService;
import com.cos.crud.utils.Script;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService mService;
	
	@GetMapping("/{id}")
	public @ResponseBody List<User> getUser(@PathVariable int id){
		return mService.getUser(id);
	}
	
	@PostMapping("/login")
	public @ResponseBody String userLogin(User user, HttpSession session) {
		User u = mService.userLogin(user);
		if (u != null) {
			session.setAttribute("user", u);
			return Script.href("/board/list");

		} else {
			return Script.back("i kill onejina");
		}
	}

	@GetMapping("/loginForm")
	public String userLoginForm() {
		return "user/loginForm";
	}

	@PostMapping("/join")
	public String userJoin(User user) {
		int result = mService.userJoin(user);
		if(result == 1) {
			return "redirect:/board/list";
		}
		return "redirect:/user/joinForm";
	}

	@GetMapping("/joinForm")
	public String userJoinForm() {
		return "user/joinForm";
	}

	@GetMapping("/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
