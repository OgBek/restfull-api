package com.springboot.rest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.Exception.ResourceNotFoundException;
import com.springboot.rest.model.Items;
import com.springboot.rest.repo.ItemRepo;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepo itemrepo;

	public ItemServiceImpl() {
		super();
		
	}

	@Override
	public Items saveItems(Items item) {
		return itemrepo.save(item);
	}

	@Override
	public List<Items> getAllItems() {
		return itemrepo.findAll();
	}

	@Override
	public Items getItemById(long id) {
		Optional<Items> item = itemrepo.findById(id);
		
		
		if(item.isPresent()) {
			return item.get();
			}else {
				throw new ResourceNotFoundException("Items","id",id);
			}
		
		
	}

	@Override
	public Items updateItem(Items item, long id) {
	Items exItem=itemrepo.findById(id).orElseThrow(()->  new ResourceNotFoundException("Items","id",id));
	 exItem.setIname(item.getIname());
	 exItem.setDescription(item.getDescription());
	 itemrepo.save(exItem);
	 return exItem;
	}

	@Override
	public void deleteItem(long id) {
		
		itemrepo.findById(id).orElseThrow(()->  new ResourceNotFoundException("Items","id",id));
		itemrepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}