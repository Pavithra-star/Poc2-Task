package com.example.product_dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_usuer_order.UserOrder;

public interface UserOrderDao extends JpaRepository<UserOrder, Integer>{

}
