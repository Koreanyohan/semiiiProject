package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	
	@Override
	public int register (ReviewDto dto) {
		
		Review entity = dtoToEntity(dto);
		
		repository.save(entity);
		
		int newNo = entity.getNo();		
		
		System.out.println(entity);
		
		return newNo;
	}


	
	
	
	@Override
	public List<ReviewDto> getList() {
		List<Review> result = repository.findAll();
		
		List<ReviewDto> list = new ArrayList<>();
		
		list = result.stream()
				.map(entity -> entityToDTO(entity))
				.collect(Collectors.toList());
		
		return list;
	}

	
	

	@Override
	public ReviewDto read(int no) {
		Optional<Review> result = repository.findById(no);
		
		if (result.isPresent()) {
			
			Review review = result.get();
			
			ReviewDto reviewDto = entityToDTO(review);
			
			return reviewDto;
		}else
			return null;
	}
	


	
	
	@Override
	public void modify(ReviewDto dto) {
		
		Optional<Review> result = repository.findById(dto.getNo());
		
		if(result.isPresent()) {
			
			Review entity = result.get();
			
			entity.setReview_title(dto.getReview_title());
			entity.setReview(dto.getReview());	
			entity.setReview_writer(dto.getReview_writer());
			
			repository.save(entity);
			
		}			
	}


	@Override
	public int remove (int no) {
		Optional<Review> result = repository.findById(no);
		
		if(result.isPresent()) {
			repository.deleteById(no);
			return 1;
		}
		else 
			return 0;
	
	}


}

