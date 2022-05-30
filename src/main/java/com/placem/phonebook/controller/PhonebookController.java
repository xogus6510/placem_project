package com.placem.phonebook.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.placem.phonebook.entity.Friend;
import com.placem.phonebook.repository.FrindRepository;

@Controller
public class PhonebookController {
	
	@Autowired
	FrindRepository repository; 
	
	
	@GetMapping("/")
	public String getMainPage() {
		return "This is the JPA test page";
	}

	@GetMapping("/findall2")
	public String findAll() {
		String result = "";
		for (Friend friend : repository.findAll()) {
			result += friend.toString() + "</br>";
		}
		
		return result; 
	}
	
	@GetMapping("/list")
    public String articleList(Model model) {
    
        model.addAttribute("name", "Rooney");
        
        return "list";
    }
	
}