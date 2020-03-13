package com.poc.poc.service;

import com.poc.poc.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    public void addItem(Item item);

    public void addItemWithoutData();

    public List<Item> getItems();

    public Item getItem(int item_id);

    public void modifyItem(Item item);

    public void deleteItem(int item_id);
}
