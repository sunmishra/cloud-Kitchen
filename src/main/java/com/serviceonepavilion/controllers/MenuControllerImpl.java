package com.serviceonepavilion.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.serviceonepavilion.entities.Dish;
import com.serviceonepavilion.entities.OrderedDish;
import com.serviceonepavilion.services.MenuService;

@RestController
public class MenuControllerImpl {

	private static final Logger log = LoggerFactory.getLogger(MenuControllerImpl.class);

	@Autowired
	private MenuService menuService;
	static List<Dish> cart = new ArrayList<>();
	static List<Dish> list = new ArrayList<>();
	static {
		list.add(new Dish(3, "Chapati", 1, 5.0));
		list.add(new Dish(4, "Masala Papad", 1, 10.0));
		list.add(new Dish(5, "Maggie", 1, 20.0));
	}

	@GetMapping("/getItems")
	public List<Dish> getItems() {
		List<Dish> itemList = menuService.findItems();
		return itemList;
	}

	@GetMapping("/getItem/{id}")
	public Dish getItem(@PathVariable int id) {
		log.debug("...........Item {} ........", menuService.findItem(id));
		Dish m = menuService.findItem(id);
		return m;
	}

	@PostMapping("/addItem")
	private int saveItem(@RequestBody Dish menu) {
		log.debug("adding Items........");
		menuService.addOrUpdateItem(menu);
		return menu.getId();
	}

	@DeleteMapping("/removeItem/{id}")
	public void removeItem(@PathVariable int id) {
		menuService.delItemById(id);
		log.debug("removing item", menuService.findItem(id).getName());
	}

	@GetMapping("/addCart")
	public List<Dish> addToCart(/* @RequestAttribute List<Dish> selectedItems */) {
		// List<Integer> cart = (List<Integer>) session.getAttribute("cart");
		List<Dish> selectedItems = list;
		for (Dish dish : selectedItems) {
			cart.add(dish);
		}
		return cart;
	}

	@GetMapping("/showCart")
	public List<OrderedDish> showCart(/* @RequestBody List<Dish> selectedItems */) {
		List<Dish> selectedItems = list;
		List<OrderedDish> orderedList = new ArrayList<>();
		for (Dish d : selectedItems)
			orderedList.add(new OrderedDish(d.getId(), d.getName(), d.getPrice()));
		return orderedList;
	}

}
