package com.example.sqldemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.sqldemo.models.Item;
import com.example.sqldemo.repositories.ItemRepository;

@RestController
@RequestMapping("/api/v1/items")
public class ItemsController {
	@Autowired
	private ItemRepository itemRepository;
	
	
	@GetMapping
	public List<Item> list() {
		return itemRepository.findAll();// Selects all on the item table

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Item item) {
		itemRepository.save(item);
	}
	
	@GetMapping("/${id}")
	public Item get(@PathVariable("id") long id) {
		return itemRepository.getOne(id);// Search for one item based on the Id.
	}
}
