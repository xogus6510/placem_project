package com.placem.phonebook.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.placem.phonebook.entity.Friend;
import com.placem.phonebook.entity.Phone;
import com.placem.phonebook.repository.FriendRepository;
import com.placem.phonebook.repository.PhoneRepository;

@Controller
public class FriendController {

	@Autowired
	private FriendRepository friendrepository;
	
	@Autowired
	private PhoneRepository phonerepository;
	
	@PersistenceUnit
	EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
	List<Friend> friend = friendrepository.findAll();
	ModelAndView mv = new ModelAndView();
	model.addAttribute("friendlist", friend);
	//model.addAttribute("msg", "test");
	 return "list";
	}
	
	@GetMapping("/registration")
	public String registration(Model model) throws Exception {
	model.addAttribute("msg", "Hello world");
	 return "registration";
	}
	
	@GetMapping ("/update")
	public ModelAndView content(@RequestParam("frndseq") long frndseq) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("/update"); 
	    mv.addObject("frndseq", frndseq); 
	    return mv;
	}
	
	//@GetMapping ("/updatesave")
	//public ModelAndView content(@RequestParam("frndseq") long frndseq) {
	    //ModelAndView mv = new ModelAndView();
	    //mv.setViewName("/update"); 
	   // mv.addObject("frndseq", frndseq); 
	  //  return mv;
	//}
	
	@GetMapping ("/add")
	public String addFriend(@ModelAttribute Friend friend, Phone phone) {
		
		friendrepository.save(friend);
		phone.setFriend(friend);
		phonerepository.save(phone);
		
		return "redirect:/list"; 
	}
	
	@RequestMapping("/delete")
	public String deleteMember(@RequestParam("frndseq") long frndseq) throws Exception {
	     Friend friend = friendrepository.findById(frndseq).orElse(null);
	     List<Phone> phoneList = phonerepository.findAllByFriend(friend);
	     phonerepository.deleteAll(phoneList);
	     friendrepository.deleteById(frndseq);
		return "redirect:/list";
	}
}