package com.placem.phonebook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.placem.phonebook.dto.FriendDTO;
import com.placem.phonebook.entity.Friend;
import com.placem.phonebook.entity.Phone;
import com.placem.phonebook.repository.FriendRepository;
import com.placem.phonebook.repository.PhoneRepository;
import com.placem.phonebook.service.FriendService;

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
	
	@Autowired
	FriendService service;

	// 전화번호부 목록
	@GetMapping("/list")
	public String list(Model model,
			@PageableDefault(page = 0, size = 3, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(required = false, defaultValue = "")String searchtext, @RequestParam(required = false, defaultValue = "") String search) throws Exception {
		Page<Friend> friend = friendrepository.findAll(pageable);
		
		if (search.equals("num3")) {
			Page<Phone> phone = phonerepository.findByTelNo3Equals(searchtext, pageable);
			int nowPage = phone.getPageable().getPageNumber();
			int sizePage = phone.getPageable().getPageSize();
			int endPage = phone.getTotalPages() - 1;
			int totalPage = friend.getTotalPages();
			model.addAttribute("friendlist", phone);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("sizePage", sizePage);
			model.addAttribute("test", service.test(searchtext));
			model.addAttribute("num3", "num3");
			return "list";
		}
		// 지인이름 검색
		if (search.equals("name")) {
			Page<Friend> friendname = friendrepository.findByFrndNmContaining(searchtext, pageable);
			int nowPage = friendname.getPageable().getPageNumber();
			int sizePage = friendname.getPageable().getPageSize();
			int endPage = friendname.getTotalPages() - 1;
			int totalPage = friend.getTotalPages();
			System.out.println(
					nowPage + "=nowPage, " + sizePage + "=sizePage, " + endPage + "=endPage,  " + totalPage + "=totalPage_name");
			model.addAttribute("friendlist", friendname);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("sizePage", sizePage);
			model.addAttribute("searchtext", searchtext);
			return "listname";
		}
		int nowPage = friend.getPageable().getPageNumber();
		int sizePage = friend.getPageable().getPageSize();
		int endPage = friend.getTotalPages() - 1;
		int totalPage = friend.getTotalPages();
		System.out.println(
				nowPage + "=nowPage, " + sizePage + "=sizePage, " + endPage + "=endPage,  " + totalPage + "=totalPage");
		model.addAttribute("friendlist", friend);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("sizePage", sizePage);
		model.addAttribute("totalPage", totalPage);
		
		return "list";
	}

	// 지인 전화번호 등록
	@GetMapping("/registration")
	public String registration(Model model) throws Exception {
		return "registration";
	}

	// 개별 전화번호 등록
	@GetMapping("/detailregistration")
	public ModelAndView detailregistration(@RequestParam("frndseq") long frndseq, @RequestParam("frndNm") String frndNm)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/detailregistration");
		mv.addObject("frndNm", frndNm);
		mv.addObject("frndseq", frndseq);
		System.out.println(frndseq);
		System.out.println(frndNm + "++++++++");
		return mv;
	}

	// 개별 전화번호 목록
	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam("frndNm") String frndNm, @RequestParam("frndseq") Friend frndseq) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/detail");
		mv.addObject("frndNm", frndNm);
		mv.addObject("frndseq", frndseq);
		List<Phone> friend = phonerepository.findByFriend(frndseq);
		System.out.println(friend);
		mv.addObject("friend", friend);
		return mv;
	}

	// 지인 이름 수정 페이지
	@GetMapping("/update")
	public ModelAndView update(@RequestParam("frndseq") long frndseq) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/update");
		mv.addObject("frndseq", frndseq);
		return mv;
	}

	// 개별 전화 수정 페이지
	@GetMapping("/detailupdate")
	public ModelAndView detailupdate(@RequestParam("telSeq") long telSeq, @RequestParam("frndNm") String frndNm,
			@RequestParam("frndseq") Friend frndseq) {
		System.out.println(telSeq + "=========");
		ModelAndView mv = new ModelAndView();
		mv.addObject("telSeq", telSeq);
		mv.addObject("frndNm", frndNm);
		mv.addObject("frndseq", frndseq.getFrndSeq());
		mv.setViewName("/detailupdate");
		return mv;
	}

	// 지인 이름 수정
	@GetMapping("/updatesave")
	public String updatesave(@RequestParam("frndseq") long frndseq, @RequestParam("frndNm") String frndNm)
			throws Exception {
		Friend friend = friendrepository.findById(frndseq).orElse(null);
		friend.setFrndNm(frndNm);
		friendrepository.save(friend);
		System.out.println(frndseq + frndNm);
		return "redirect:/list";
	}

	// 개별 전화 수정
	@GetMapping("/detailupdatesave")
	public String detailupdatesave(@RequestParam("friend") Friend frndseq, @RequestParam("frndNm") String frndNm,
			@ModelAttribute Phone phone, @RequestParam("telSeq") long telSeq) throws Exception {
		System.out.println(frndseq + frndNm + "++++++++++++++");
		System.out.println(phone);
		Phone phone2 = phonerepository.findById(telSeq).orElse(null);
		phone2.setTelType(phone.getTelType());
		phone2.setTelNo1(phone.getTelNo1());
		phone2.setTelNo2(phone.getTelNo2());
		phone2.setTelNo3(phone.getTelNo3());
		phonerepository.save(phone2);
		return "redirect:/list";
	}

	// 전화번호 정보 등록 후 저장버튼 클릭
	@GetMapping("/add")
	public String addFriend(@ModelAttribute Friend friend, Phone phone) {
		System.out.println(friend + "= friend,  " + phone.getTelNo1().length() + "= phone");
		friendrepository.save(friend);
		phone.setFriend(friend);
		if(phone.getTelNo1().length() != 0 && phone.getTelNo2().length() != 0 && phone.getTelNo3().length() != 0) {
			phonerepository.save(phone);
		}
		return "redirect:/list";
	}

	// 개별 전화번호 정보 등록 후 저장버튼 클릭
	@GetMapping("/detailadd")
	public String detailaddFriend(@ModelAttribute Phone phone, @RequestParam("friend") Friend friend,
			@RequestParam("frndNm") String frndNm) {
		phonerepository.save(phone);
		System.out.println(frndNm + "=================");
		return "redirect:/detail?frndNm=" + frndNm + "&frndseq=" + friend.getFrndSeq();
	}

	// 지인 목록에서 데이터 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("frndseq") long frndseq) throws Exception {
		Friend friend = friendrepository.findById(frndseq).orElse(null);
		List<Phone> phoneList = phonerepository.findAllByFriend(friend);
		phonerepository.deleteAll(phoneList);
		friendrepository.deleteById(frndseq);
		return "redirect:/list";
	}

	// 전화 목록에서 데이터 삭제
	@GetMapping("/detaildelete")
	public String detaildelete(@RequestParam("telSeq") long telSeq, @RequestParam("frndNm") String frndNm,
			@RequestParam("frndseq") long frndseq) throws Exception {
		phonerepository.deleteById(telSeq);
		return "redirect:/detail?frndNm=" + frndNm + "&frndseq=" + frndseq;
	}
}