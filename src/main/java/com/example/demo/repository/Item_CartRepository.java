package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;
import com.example.demo.entity.Item_Cart;

public interface Item_CartRepository extends JpaRepository<Item_Cart, Integer> {

}
