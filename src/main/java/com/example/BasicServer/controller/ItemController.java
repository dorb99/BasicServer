package com.example.BasicServer.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BasicServer.model.Item;
import com.example.BasicServer.service.ItemService;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

	private final ItemService itemService;
	
	public ItemController(ItemService userService) {
        this.itemService = userService;
	}
	
	// Create
	@PostMapping
	public ResponseEntity<Item> createItem(@RequestBody Item item){
		Item newItem = itemService.addItem(item);
		return ResponseEntity.ok(newItem);
	}
	
	// Get all
	@GetMapping
	public ResponseEntity<Iterable<Item>> getAllItems(){
		return ResponseEntity.ok(itemService.getAllItems());
	}
	
	// READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Item> getUserById(@PathVariable Long id) {
        Optional<Item> user = itemService.getItem(id);
        return user.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateitem(@PathVariable Long id, @RequestBody Item itemDetails) {
        Optional<Item> existingItemOpt = itemService.getItem(id);
        if (existingItemOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        Item existingItem = existingItemOpt.get();
        // Update the fields of the existing item with the new item's data
        existingItem.setTitle(itemDetails.getTitle()); 
        existingItem.setAmount(itemDetails.getAmount());
        
        Item updatedItem = itemService.updateItem(existingItem);
        return ResponseEntity.ok(updatedItem);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<Item> item = itemService.getItem(id);
        if (item.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
