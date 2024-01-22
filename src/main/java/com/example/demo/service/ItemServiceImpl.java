package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;
	
	
	@Override
	public int register(ItemDto dto) {
		
		Item entity = dtoToEntity(dto);
		
		repository.save(entity);
		
		int newNo = entity.getNo();
		
		
		System.out.println(entity);
		
		return newNo;
	}

}
