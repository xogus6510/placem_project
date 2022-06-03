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

	//전화번호부 목록
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		List<Friend> friend = friendrepository.findAll();
		model.addAttribute("friendlist", friend);
		return "list";
	}

	//지인 전화번호 등록
	@GetMapping("/registration")
	public String registration(Model model) throws Exception {
		model.addAttribute("msg", "Hello world");
		return "registration";
	}

	//개별 전화번호 목록
	@GetMapping("/detail")
	public ModelAndView content(@RequestParam("frndNm") String frndNm, @RequestParam("frndseq") Friend frndseq) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/detail");
		mv.addObject("frndNm", frndNm);
		mv.addObject("frndseq", frndseq);
		List<Phone> friend = phonerepository.findByFriend(frndseq);
		System.out.println(friend);
		mv.addObject("friend", friend);
		return mv;
	}

	//지인 이름 수정 페이지
	@GetMapping("/update")
	public ModelAndView update(@RequestParam("frndseq") long frndseq) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/update");
		mv.addObject("frndseq", frndseq);
		return mv;
	}

	//지인 이름 수정
	@GetMapping("/updatesave")
	public String deleteMember(@RequestParam("frndseq") long frndseq, @RequestParam("frndNm") String frndNm)
			throws Exception {
		Friend friend = friendrepository.findById(frndseq).orElse(null);
		friend.setFrndNm(frndNm);
		friendrepository.save(friend);
		System.out.println(frndseq + frndNm);
		return "redirect:/list";
	}

	@GetMapping("/add")
	public String addFriend(@ModelAttribute Friend friend, Phone phone) {
		friendrepository.save(friend);
		phone.setFriend(friend);
		phonerepository.save(phone);
		return "redirect:/list";
	}

	//
	@GetMapping("/delete")
	public String delete(@RequestParam("frndseq") long frndseq) throws Exception {
		Friend friend = friendrepository.findById(frndseq).orElse(null);
		List<Phone> phoneList = phonerepository.findAllByFriend(friend);
		phonerepository.deleteAll(phoneList);
		friendrepository.deleteById(frndseq);
		return "redirect:/list";
	}

	@GetMapping("/detaildelete")
	public String detaildelete(@RequestParam("telSeq") long telSeq, @RequestParam("frndNm") String frndNm,
			@RequestParam("frndseq") long frndseq) throws Exception {
		System.out.println(telSeq + "/" + frndNm + "/" + frndseq + "===========");
		phonerepository.deleteById(telSeq);
		return "redirect:/detail?frndNm=" + frndNm + "&frndseq=" + frndseq;
	}
}