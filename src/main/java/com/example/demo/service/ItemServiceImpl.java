package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


	
	
	
	@Override
	public List<ItemDto> getList() {
		List<Item> result = repository.findAll();
		
		List<ItemDto> list = new ArrayList<>();
		
		list = result.stream()
				.map(entity -> entityToDTO(entity))
				.collect(Collectors.toList());
		
		return list;
	}

	
	

	@Override
	public ItemDto read(int no) {
		Optional<Item> result = repository.findById(no);
		
		if (result.isPresent()) {
			
			Item item = result.get();
			
			ItemDto itemDto = entityToDTO(item);
			
			return itemDto;
		} else
			return null;		
	}


	
	
	@Override
	public void modify(ItemDto dto) {
		
		Optional<Item> result = repository.findById(dto.getNo());
		
		if(result.isPresent()) {
			
			Item entity = result.get();
						
			entity.setItem_name(dto.getItem_name());
			entity.setPrice(dto.getPrice());
			entity.setSeller(dto.getSeller());
			
			repository.save(entity);
			
		}			
	}


	@Override
	public int remove (int no) {
		Optional<Item> result = repository.findById(no);
		
		if(result.isPresent()) {
			repository.deleteById(no);
			return 1;
		}
		else 
			return 0;
	
	}
}



















