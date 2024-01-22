package com.example.demo.service;

import com.example.demo.dto.ItemDto;
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
	
}
