package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ItemDto_Cart;
import com.example.demo.entity.Item_Cart;
import com.example.demo.repository.Item_CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private Item_CartRepository repository;
	
	
	@Override
	public int register(ItemDto_Cart dto) {
		
		Item_Cart entity = dtoToEntity(dto);
		
		repository.save(entity);
		
		int newNo = entity.getNo();		
		
		System.out.println(entity);
		
		return newNo;
	}	
	
	
	
	@Override
	public List<ItemDto_Cart> getList() {
		List<Item_Cart> result = repository.findAll();
		
		List<ItemDto_Cart> list = new ArrayList<>();
		
		list = result.stream()
				.map(entity -> entityToDTO(entity))
				.collect(Collectors.toList());
		
		return list;
	}

	
	

	@Override
	public ItemDto_Cart read(int no) {
		Optional<Item_Cart> result = repository.findById(no);
		
		if (result.isPresent()) {
			
			Item_Cart item = result.get();
			
			ItemDto_Cart itemDto = entityToDTO(item);
			
			return itemDto;
		} else
			return null;		
	}


	
	
	@Override
	public void modify(ItemDto_Cart dto) {
		
		Optional<Item_Cart> result = repository.findById(dto.getNo());
		
		if(result.isPresent()) {
			
			Item_Cart entity = result.get();
						
			entity.setItem_name(dto.getItem_name());
			entity.setPrice(dto.getPrice());
			entity.setSeller(dto.getSeller());
			
			repository.save(entity);
			
		}			
	}


	@Override
	public int remove (int no) {
		Optional<Item_Cart> result = repository.findById(no);
		
		if(result.isPresent()) {
			repository.deleteById(no);
			return 1;
		}
		else 
			return 0;
	
	}
}



















