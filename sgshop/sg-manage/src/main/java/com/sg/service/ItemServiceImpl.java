package com.sg.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sg.mapper.ItemDescMapper;
import com.sg.mapper.ItemMapper;
import com.sg.pojo.Item;
import com.sg.pojo.ItemDesc;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemDescMapper itemDescMapper;

	@Override
	public Item findItemById(Long itemId) {
		Item item = itemMapper.selectById(itemId);
		return item;
	}

	@Override
	public List<Item> findItems(int pages, int rows) {
		int start = (pages-1)*rows;		
		List<Item> items = itemMapper.findItems(start,rows);		
		return items;
	}

	@Override
	@Transactional
	public void insert(Item item,ItemDesc itemDesc) {
		item.setStatus(1)
			.setCreated(new Date())
			.setUpdated(item.getCreated());
		itemMapper.insert(item);
		//itemDescMapper.insert(itemDesc);
	}
}
