package com.sg.service;

import java.util.List;

import com.sg.pojo.Item;
import com.sg.pojo.ItemDesc;

public interface ItemService {

	Item findItemById(Long itemId);

	List<Item> findItems(int pages, int rows);

	void insert(Item item,ItemDesc itemDesc);

}
