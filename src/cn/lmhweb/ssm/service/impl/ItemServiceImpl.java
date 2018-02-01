package cn.lmhweb.ssm.service.impl;

import cn.lmhweb.springmvc.module.Item;
import cn.lmhweb.ssm.mapper.ItemMapper;
import cn.lmhweb.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> queryAllItems(){

        // 从数据库查询商品数据
        List<Item> list = itemMapper.queryAllItems();

        return list;

    }
}
