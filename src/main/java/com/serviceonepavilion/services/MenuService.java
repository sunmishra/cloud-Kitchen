package com.serviceonepavilion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceonepavilion.entities.Dish;
import com.serviceonepavilion.repository.MenuRepo;

@Service
public class MenuService {
	@Autowired
	private MenuRepo menuRepo;

	public Dish addOrUpdateItem(Dish b) {
		return menuRepo.save(b);
	}


	public void delItemById(int id) {
		menuRepo.deleteById(id);
	}

	public Dish findItem(int id) {
		return menuRepo.findById(id).get();
	}

	public List<Dish> findItems() {
		return menuRepo.findAll();
	}


}
