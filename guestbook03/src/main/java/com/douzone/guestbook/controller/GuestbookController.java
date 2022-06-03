package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	

	@RequestMapping(value="/delete/{no}")
	public String delete(@PathVariable("no") Long no) {
		return "/WEB-INF/views/delete.jsp";
	}

	
	@RequestMapping(value="/delete/{no}", method=RequestMethod.POST)
	public String delete(
			@PathVariable("no") Long no,
			@RequestParam(value="password", required=true, defaultValue="") String password) {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);
		GuestbookRepository.delete(vo);

		return "redirect:/";
	}
	
	@RequestMapping(value="/guestbook", method=RequestMethod.POST)
	public String add(GuestbookVo vo) {
		
		GuestbookRepository.insert(vo);

		return "redirect:/";
	}
}
