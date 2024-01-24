package com.example.demo.dto;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {

	private int no; //글 번호
	
	private String review_title;
	
	private String review_writer;
	
	private String review;

	LocalDateTime regDate ;
	
	LocalDateTime modDate ;
	
}
