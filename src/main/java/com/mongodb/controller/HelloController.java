package com.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mongodb.model.User;
import com.mongodb.repository.UserRepository;

@Controller
public class HelloController {
	@Autowired
	UserRepository userRepo;

	
	@GetMapping("/")
   public String direHello(Model m)
   {
	   m.addAttribute("nom", "Jellab");
	   return "hello";
   }
	
	@GetMapping("/add")
	public String add(Model m) {
		User u = new User();
		m.addAttribute("u", u);
		return "users/add";
	}
	
	@PostMapping("/add")
	public String add(User u, Model m, BindingResult rs) {
		if(rs.hasErrors()) {
			return "users/add";
		}
		m.addAttribute("u", u);
		return "users/info";
	}
	
	@GetMapping("/test") 
	public String test(Model m) {
		List<User> list = userRepo.findByUsername("mohammedjlb");
		m.addAttribute("nom", list.get(0).getUsername());
		return "hello";
	}


}

