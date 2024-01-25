package com.example.demo;

import static org.mockito.ArgumentMatchers.intThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemDto_Cart;
import com.example.demo.dto.ReviewDto;
import com.example.demo.service.CartService;
import com.example.demo.service.ItemService;
import com.example.demo.service.ReviewService;

@SpringBootTest
public class CartServiceTest {

	@Autowired
	CartService service;
	
	@Test
	public void 게시물등록() {
		
		ItemDto_Cart dto = ItemDto_Cart.builder()
				.item_name("좋아요").seller("홍길동")
				.price(3500)
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
		
		dto.setPrice(2000);
		
		service.modify(dto);
	}
	
	
	@Test
	void 게시물삭제() {
		int result = service.remove(２);
		
		System.out.println("결과가 1이면 삭제 성공,결과가 0이면 삭제 실패" + result);
	}
	
	
	
}
