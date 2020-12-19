package com.serviceonepavilion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.serviceonepavilion.entities.Dish;

public interface MenuRepo  extends JpaRepository<Dish, Integer>{


}