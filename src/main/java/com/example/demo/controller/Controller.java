package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ItemDto;
import com.example.demo.service.ItemService;



@org.springframework.stereotype.Controller
@RequestMapping("/items")
public class Controller {
	
	@Autowired
	ItemService service;
	
	   @GetMapping("/start")
	    public void main() {		 
	    }	   
	   
	  
	   @GetMapping({"/fashion", "/fashion_tshirt", "/fashion_shirt", "/fashion_trouser", "/AllCategories"})
	    public void fashion() { 
	    }
	   
	   
	   
	   
	   
	   @GetMapping("/register") // 등록된 아이템들 목록
	    public void register(Model model) {		   
		   
		   List<ItemDto> list = service.getList();
		   
		   model.addAttribute("list", list);
	   }
	   
	   
	   // 아이템 등록하기
	   @GetMapping("/register_items")
	    public void register_items() {		   
		   		   
	    }
	   
	   @PostMapping("/register_items")
	    public String register_items_post(ItemDto dto, RedirectAttributes redirectAttributes) {		   
		
		   int no = service.register(dto);
		   
		   redirectAttributes.addFlashAttribute("msg", no);
		   
		   
		   return "redirect:/items/register";  		   
	   }
		   
		  
		  // 아이템 상세조회
		   
		   @GetMapping("/read")
		   public void read(@RequestParam(name="no") int no, Model model) {
			  ItemDto dto = service.read(no);
			  
			  model.addAttribute("dto", dto);
		   }		   
		   
		   // 제품 정보 보기
		   @GetMapping("/infoRead")
		   public void infoRead(@RequestParam(name="no") int no, Model model) {
			  ItemDto dto = service.read(no);
			  
			  model.addAttribute("dto", dto);
		   }
		   
		
		   // 아이템데이터 수정
		   @GetMapping("/modify")
		   public void modify (@RequestParam(name="no") int no, Model model) {
			   ItemDto dto = service.read(no);
			   
			   model.addAttribute("dto", dto);
		   }
	
		   
		   @PostMapping("/modify")
		   public String modifyPost (ItemDto dto, RedirectAttributes redirectAttributes) {
			   service.modify(dto);
			   
			   redirectAttributes.addAttribute("no", dto.getNo());
			   
			   return "redirect:/items/read";
		   }
		   
		   
		   
		   // 삭제
		   @PostMapping("/remove")
		   public String removePost (@RequestParam(name="no") int no) {
			   
			   service.remove(no);
			   
			   return "redirect:/items/register";
		   }

}






















