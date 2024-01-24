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
import com.example.demo.dto.ItemDto_Cart;
import com.example.demo.service.CartService;
import com.example.demo.service.ItemService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService service;
	

	   
	   @GetMapping("/cart_list") // 등록된 아이템들 목록
	    public void register(Model model) {		   
		   
		   List<ItemDto_Cart> list = service.getList();
		   
		   model.addAttribute("list", list);
	   }
	   
	   
		/*
		 * // 아이템 등록하기
		 * 
		 * @GetMapping("/register_cart") public void register_items() {
		 * 
		 * }
		 */
	   
	   @PostMapping("/cart_list")
	    public String register_items_post(ItemDto_Cart dto, RedirectAttributes redirectAttributes) {		   
		
		   int no = service.register(dto);
		   
		   
		   
		   return "redirect:/cart/cart_list";  		   
	   }
		   
		  
		  // 아이템 상세조회
		   
		   @GetMapping("/infoRead")
		   public void read(@RequestParam(name="no") int no, Model model) {
			  ItemDto_Cart dto = service.read(no);
			  
			  model.addAttribute("dto", dto);
		   }		   
		   
		
		   // 아이템데이터 수정
		   @GetMapping("/modify")
		   public void modify (@RequestParam(name="no") int no, Model model) {
			   ItemDto_Cart dto = service.read(no);
			   
			   model.addAttribute("dto", dto);
		   }
	
		   
		   @PostMapping("/modify")
		   public String modifyPost (ItemDto_Cart dto, RedirectAttributes redirectAttributes) {
			   service.modify(dto);
			   
			   redirectAttributes.addAttribute("no", dto.getNo());
			   
			   return "redirect:/cart/cart_list";
		   }
		   
		   
		   
		   // 삭제
		   @PostMapping("/remove")
		   public String removePost (@RequestParam(name="no") int no) {
			   
			   service.remove(no);
			   
			   return "redirect:/cart/cart_list";
		   }
	
}
