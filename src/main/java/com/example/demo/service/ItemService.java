package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemDto_Cart;
import com.example.demo.entity.Item;


public interface ItemService {

	int register (ItemDto dto);
	
	default Item dtoToEntity (ItemDto dto) {
		
		Item entity = Item.builder()
				.no(dto.getNo())
				.item_name(dto.getItem_name())
				.seller(dto.getSeller())
				.price(dto.getPrice())
				.build();
				
		return entity;
	}
	
	//게시물 목록 조회
	List<ItemDto> getList();
	
	default ItemDto entityToDTO(Item entity) {
		ItemDto dto = ItemDto.builder()
				.no(entity.getNo()).item_name(entity.getItem_name())
				.seller(entity.getSeller()).price(entity.getPrice()).regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();
		return dto;
	}
	
	
	
	// 3. 게시물 상세조회
	ItemDto read(int no); // 게시물 번호 입력받아서 dto형태로 출력하는 추상메서드
	  
	
	// 4. 게시물 수정 	
		void modify(ItemDto dto); // 수정한 ｄｔｏ 입력받아서 데이터 수정하는 추상메서드
		
		
	// 5. 게시물 삭제
		int remove(int no); // 결과 알려주려고 하다보니 반환타입들어감. 아니면 그냥 void였었음.
	
		
		
		
		
}
