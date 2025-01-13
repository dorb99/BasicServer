package com.example.BasicServer.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.BasicServer.model.Item;
import com.example.BasicServer.repository.ItemRepository;

@Service
public class ItemService {
	
	private final ItemRepository itemRepo;
	
	public ItemService(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}
	
	// get one
	public Optional<Item> getItem(Long id) {
		return itemRepo.findById(id);
	}
	
	// get all
	public Iterable<Item> getAllItems() {
		return itemRepo.findAll();
	}
	
	// create
	public Item addItem(Item item) {
		return itemRepo.save(item);
	}
	
	// delete
	public void deleteItem(Long id) {
		itemRepo.deleteById(id);
	}
	
	// update
	public Item updateItem(Item item) {
        return itemRepo.save(item);
	}
}
