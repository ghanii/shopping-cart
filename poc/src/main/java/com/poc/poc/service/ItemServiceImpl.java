package com.poc.poc.service;

import com.poc.poc.model.Category;
import com.poc.poc.model.Item;
import com.poc.poc.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public void addItem(Item item) {
        itemRepo.save(item);
    }

    @Override
    public void addItemWithoutData() {
        Item item = new Item(10,"milk",250, Category.MILK,new Date(),new Date());
        itemRepo.save(item);
    }

    @Override
    public List<Item> getItems() {

        return (List<Item>) itemRepo.findAll();

    }

    @Override
    public Item getItem(int item_id) {

        Item item = null;
        Optional<Item> option = itemRepo.findById(item_id);
        if(option.isPresent()){
            item = option.get();
        }
        return item;
    }

    @Override
    public void deleteItem(int item_id) {
        itemRepo.deleteById(item_id);
    }
}
