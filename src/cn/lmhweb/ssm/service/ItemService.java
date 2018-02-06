package cn.lmhweb.ssm.service;

import cn.lmhweb.springmvc.module.Item;

import java.util.List;

public interface ItemService {

    public List<Item> queryAllItems();

    public Item queryItemListById(String id);

    public void editItem(Item item);

}
