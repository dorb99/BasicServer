package com.example.BasicServer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BasicServer.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {    
    // Custom query method by email
    List<Item> findByEmail(String email);
}
