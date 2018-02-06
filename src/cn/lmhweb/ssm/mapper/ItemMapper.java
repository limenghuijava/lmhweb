package cn.lmhweb.ssm.mapper;

import cn.lmhweb.springmvc.module.Item;

import java.util.List;

public interface ItemMapper {
    public List<Item> queryAllItems();

    public Item queryItemListById(String id);

    public void editItem(Item item);
}
