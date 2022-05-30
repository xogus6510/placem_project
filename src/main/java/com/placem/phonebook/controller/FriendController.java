package com.placem.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placem.phonebook.entity.Friend;
import com.placem.phonebook.repository.FriendRepository;

@Controller
public class FriendController {

	@Autowired
	FriendRepository repository;

	@GetMapping("/findall")
	public String findAll() {
		String result = "";

		for (Friend friend : repository.findAll()) {
			result += friend.toString() + "</br>";
		}

		return result;
	}
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
	System.out.println(repository.findAll());
	model.addAttribute("friendlist", repository.findAll());
	model.addAttribute("msg", "Hello world");
	 return "list";
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