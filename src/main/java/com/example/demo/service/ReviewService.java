package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.Review;

public interface ReviewService {

	//리뷰 목록 등록
	int register (ReviewDto dto);
	
	default Review dtoToEntity (ReviewDto dto) {
		
		Review entity = Review.builder()
				.no(dto.getNo())
				.review_title(dto.getReview_title())
				.review_writer(dto.getReview_writer())
				.review(dto.getReview())
				.build();
				
				
		return entity;
	}
	
	//리뷰 목록 조회
	List<ReviewDto> getList();
	
	default ReviewDto entityToDTO(Review entity) {
		ReviewDto dto = ReviewDto.builder()
				.no(entity.getNo())
				.review_writer(entity.getReview())				
				.review_title(entity.getReview_title())
				.review(entity.getReview())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();
		return dto;
	}
	
	
	
	// 3. 리뷰 상세조회
	ReviewDto read(int no); // 게시물 번호 입력받아서 dto형태로 출력하는 추상메서드
	  
	
	// 4. 리뷰 수정 	
		void modify(ReviewDto dto); // 수정한 ｄｔｏ 입력받아서 데이터 수정하는 추상메서드
		
		
	// 5. 리뷰 삭제
		int remove(int no); // 결과 알려주려고 하다보니 반환타입들어감. 아니면 그냥 void였었음.
	
	
}
