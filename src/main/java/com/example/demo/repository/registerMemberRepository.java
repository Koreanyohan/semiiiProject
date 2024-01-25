package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.RegisterMemberDto;
import com.example.demo.entity.RegisterMember;

public interface registerMemberRepository extends JpaRepository<RegisterMember, Integer> {

}
