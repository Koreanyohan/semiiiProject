package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class RegisterMemberDto {

	int no; // 회원 번호
	
	String member_name;
	
	String member_password;
	
	String introduction;
	
	LocalDate birth_date;
	
	LocalDateTime regDate ; 
	
	LocalDateTime modDate ;
	
}



