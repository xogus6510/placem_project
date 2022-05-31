package com.placem.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.placem.phonebook.entity.Friend;
import com.placem.phonebook.entity.Phone;
import com.placem.phonebook.repository.FriendRepository;
import com.placem.phonebook.repository.PhoneRepository;

@Controller
public class FriendController {

	@Autowired
	private FriendRepository repository;
	
	@Autowired
	private PhoneRepository repository2;
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
	List<Friend> friend = repository.findAll();
	System.out.println(friend);
	ModelAndView mv = new ModelAndView();
	//mv.addObject("friendlist",  friend);
	model.addAttribute("friendlist", friend);
	model.addAttribute("msg", "test");
	 return "list";
	}
	
	@GetMapping("/registration")
	public String registration(Model model) throws Exception {
	model.addAttribute("msg", "Hello world");
	 return "registration";
	}
	
	@GetMapping ("/add")
	public String addFriend(@ModelAttribute Friend friend, Phone phone) {
		
		repository.save(friend);
		repository2.save(phone);
		
		return "redirect:/list"; 
	}
	
	
	
	/*@GetMapping("/findbyid")
	public String findById(@RequestParam("id") long id) {
		String result = "";

		for (Member member : repository.findById(id)) {
			result += member.toString() + "</br>";
		}

		return result;
	}

	@GetMapping("/findbylastname")
	public String findById(@RequestParam("lastname") String lastName) {
		String result = "";

		for (Member member : repository.findByLastName(lastName)) {
			result += member.toString() + "</br>";
		}

		return result;
	}

	@GetMapping("/add")
	public String addMember(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
			@RequestParam("email") String email) {

		repository.save(new Member(firstName, lastName, email));

		return "Addition done!";
	}

	@GetMapping("/update")
	public String updateMember(@RequestParam("id") long id, @RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName, @RequestParam("email") String email) {

		Member member = repository.findById(id).get(0);

		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setEmail(email);
		repository.save(member);

		return "Update done!";
	}

	@GetMapping("/delete")
	public String deleteMember(@RequestParam("id") long id) {

		repository.deleteById(id);

		return "Delete done!";
	}*/

}