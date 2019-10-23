package com.sg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.pojo.Item;
import com.sg.pojo.ItemDesc;
import com.sg.service.ItemService;
import com.sg.vo.SysResult;

@RequestMapping("/Item")
@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/findItemById")
	public SysResult findItemById(Long itemId) {
		Item item = itemService.findItemById(itemId);
		return new SysResult(200,null,item);
	}
	
	@RequestMapping("/findItems")
	public SysResult findItems(int pages,int rows) {
		List<Item> items = itemService.findItems(pages,rows);
		return new SysResult(200,null,items);
	}
	
	@RequestMapping("/addItem")
	public SysResult addItem(Item item,ItemDesc itemDesc) {
		itemService.insert(item,itemDesc);
		return SysResult.success();
	}
	

	
	
	

}
