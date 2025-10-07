package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Item;
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
	public List<Item> findByShopId(int shopId);
	public Item findByItemDesc(String itemdesc);
}
