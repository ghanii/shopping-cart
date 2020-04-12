package com.poc.poc.controller;

import com.poc.poc.model.Item;
import com.poc.poc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {


    @Autowired
    private ItemService itemService;

    /**
     * add an item
     * */
    @PostMapping("add-item")
    public void addItem(@RequestBody Item item){
        itemService.addItem(item);
    }

    /**
     * add all items
    */
    @PostMapping
    public void addAllItems(@RequestBody List<Item> items){
        itemService.addAllItems(items);
    }

    //just for testing
    @PostMapping("add-item-without-data")
    public void addItemWithoutData(){
        itemService.addItemWithoutData();
    }
    /**
     * get all items
     * */
    @GetMapping("get-items")
    public List<Item> getItems(){
        return itemService.getItems();
    }
    /**
     * get an item by item_id
     * */
    @GetMapping("get-item/{item_id}")
    public Item getItem(@PathVariable int item_id){
        return itemService.getItem(item_id);
    }
    @PutMapping("edit-item")
    public void modifyItem(@RequestBody Item item){
        itemService.modifyItem(item);
    }

    /**
     * delete an item by item_id
     * */
    @DeleteMapping("delete-item/{item_id}")
    public void deleteItem(@PathVariable int item_id){
        itemService.deleteItem(item_id);
    }
}
