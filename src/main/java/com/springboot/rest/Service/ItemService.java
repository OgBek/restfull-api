package com.springboot.rest.Service;

import java.util.List;

import com.springboot.rest.model.Items;

public interface ItemService {
 
	Items saveItems(Items item);
	List<Items> getAllItems();
	Items getItemById(long id);
	Items updateItem(Items item,long id);
	void deleteItem(long id);
	
}
