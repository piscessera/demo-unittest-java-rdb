package com.piscessera.unittest.rdb.demo;

import com.piscessera.unittest.rdb.demo.model.Item;
import com.piscessera.unittest.rdb.demo.repository.DataSourceConfig;
import com.piscessera.unittest.rdb.demo.repository.ItemRepository;

public class Main {
    public static void main(String[] args){
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.loadConfig(Main.class);

        Item item1 = new Item();
        item1.setName("m2 Samsung 1TB");

        ItemRepository itemRepository = new ItemRepository();
        itemRepository.create(item1);
    }
}
