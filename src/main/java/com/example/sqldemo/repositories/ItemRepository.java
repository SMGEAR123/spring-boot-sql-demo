package com.example.sqldemo.repositories;

import com.example.sqldemo.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
