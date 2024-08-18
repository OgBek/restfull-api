package com.springboot.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.Service.ItemService;
import com.springboot.rest.model.Items;

@RestController 
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService; 

  

    @PostMapping 
    public ResponseEntity<Items> saveItem(@RequestBody Items item) {
        Items savedItem = itemService.saveItems(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED); 
    }

    @GetMapping 
    public ResponseEntity<List<Items>> getAllItems() {
        List<Items> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Items> getItemById(@PathVariable("id") long itemid){
    	 return new ResponseEntity<Items>(itemService.getItemById(itemid),HttpStatus.OK);
    	
    }
    @PutMapping("{id}")
    public ResponseEntity<Items> updateItem(@PathVariable("id") long itemid, @RequestBody Items item){
    	 return new ResponseEntity<Items>(itemService.updateItem(item, itemid),  HttpStatus.OK );
    	
    	
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") long itemid){
    	
    	itemService.deleteItem(itemid);
    	
    	 return new ResponseEntity<String>("successfully deleted",HttpStatus.OK );
    	
    }
    
    
    
    
    
    
    
    
    
}