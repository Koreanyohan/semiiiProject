package com.example.demo;

import static org.mockito.ArgumentMatchers.intThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemDto_Cart;
import com.example.demo.service.CartService;
import com.example.demo.service.ItemService;

@SpringBootTest
public class ItemServiceTest {

	@Autowired
	CartService service;
	
	@Test
	public void 게시물등록() {
		
		ItemDto_Cart dto = ItemDto_Cart.builder()
				.item_name("포켓몬빵").seller("샤니")
				.price(1500)
				.build();
		
		int no = service.register(dto);
		
		System.out.println("새로운 품목 번호 : " + no);
		
	}
	
	
	@Test
	void 게시물단건조회() {
		ItemDto_Cart dto = service.read(1);
		
		System.out.println(dto);
	}
	
	
	
	@Test
	void 게시물수정() {
		ItemDto_Cart dto = service.read(1);
		
		dto.setItem_name("디지몬빵");
		
		service.modify(dto);
	}
	
	
	@Test
	void 게시물삭제() {
		int result = service.remove(5);
		
		System.out.println("결과가 1이면 삭제 성공,결과가 0이면 삭제 실패" + result);
	}
	
	
	
	
	
	
	
	
	
	
	
}
