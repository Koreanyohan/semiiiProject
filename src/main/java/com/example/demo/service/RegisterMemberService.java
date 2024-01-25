package com.example.demo.service;
// 회원가입 
import java.util.List;

import com.example.demo.dto.RegisterMemberDto;
import com.example.demo.entity.RegisterMember;

public interface RegisterMemberService {

	int register (RegisterMemberDto dto);
	
	default RegisterMember dtoToEntity (RegisterMemberDto dto) {

		RegisterMember entity = RegisterMember.builder()
				.no(dto.getNo())
				.member_name(dto.getMember_name())
				.member_password(dto.getMember_password())
				.introduction(dto.getIntroduction())
				.build();
		
		return entity;
	}
	
	List<RegisterMemberDto> getList();
	
	default RegisterMemberDto entityToDTO(RegisterMember entity) {
		RegisterMemberDto dto  = RegisterMemberDto.builder()
				.no(entity.getNo())
				.member_name(entity.getMember_name())
				.member_password(entity.getMember_password())
				.introduction(entity.getIntroduction())
				.birth_date(entity.getBirth_date())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();
		
		return dto;
	}
	
	// 게시물 상세조회
	RegisterMemberDto read(int no);
	
	// 게시물 수정
	void modify(RegisterMemberDto dto);
	
	// 게시물 삭제 
	int remove(int no);
}
