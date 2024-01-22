package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.ItemDto;
import com.example.demo.service.ItemService;

public class ItemServiceTest {

	@Autowired
	ItemService service;
	
	@Test
	public void 게시물등록() {
		
		ItemDto dto = ItemDto.builder()
				.item_name("좋은 셔츠").seller("홍길동")
				.price(15000)
				.build();
		
		int no = service.register(dto);
		
		System.out.println("새로운 품목 번호 : " + no);
		
	}
	
}
