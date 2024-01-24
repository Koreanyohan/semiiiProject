package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ReviewDto;
import com.example.demo.service.ReviewService;

@Controller
@RequestMapping ("/review")
public class ReviewController {

	@Autowired
	ReviewService service;
	
	/*
	 * @GetMapping("/InfoRead") public void review () {
	 * 
	 * }
	 */
	
	
	@GetMapping("/register") // 등록된 리뷰들 목록
    public void register(Model model) {		   
	   
	   List<ReviewDto> list = service.getList();
	   
	   model.addAttribute("list", list);
   }
   
   
   // 리뷰 등록하기
   @GetMapping("/register_reviews")
    public void register_items() {		   
	   		   
    }
   
   @PostMapping("/register_reviews")
    public String register_items_post(ReviewDto dto, RedirectAttributes redirectAttributes) {		   
	
	   int no = service.register(dto);
	   
	   redirectAttributes.addFlashAttribute("msg", no);
	   
	   
	   return "redirect:/review/register";  		   
   }
	   
	  
	    
	   
	   // 제품 정보 보기
	   @GetMapping("/infoRead")
	   public void infoRead(@RequestParam(name="no") int no, Model model) {
		  ReviewDto dto = service.read(no);
		  
		  model.addAttribute("dto", dto);
	   }
	   
	
	   // 아이템데이터 수정
	   @GetMapping("/modify")
	   public void modify (@RequestParam(name="no") int no, Model model) {
		   ReviewDto dto = service.read(no);
		   
		   model.addAttribute("dto", dto);
	   }

	   
	   @PostMapping("/modify")
	   public String modifyPost (ReviewDto dto, RedirectAttributes redirectAttributes) {
		   service.modify(dto);
		   
		   redirectAttributes.addAttribute("no", dto.getNo());
		   
		   return "redirect:/review/read";
	   }
	   
	   
	   
	   // 삭제
	   @PostMapping("/remove")
	   public String removePost (@RequestParam(name="no") int no) {
		   
		   service.remove(no);
		   
		   return "redirect:/review/register";
	   }
	
	
	
	
}

