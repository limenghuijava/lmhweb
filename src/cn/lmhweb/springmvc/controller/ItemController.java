package cn.lmhweb.springmvc.controller;

import cn.lmhweb.springmvc.module.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ItemController {
    // @RequestMapping：里面放的是请求的url，和用户请求的url进行匹配
    // action可以写也可以不写

    @RequestMapping("/item/queryItem.action")
    public ModelAndView queryItemList() {
        // 创建页面需要显示的商品数据
        List<Item> list = new ArrayList<>();
        list.add(new Item(1, "1华为 荣耀8", 2399.0, new Date(), "质量好！1"));
        list.add(new Item(2, "2华为 荣耀8", 2399.0, new Date(), "质量好！2"));
        list.add(new Item(3, "3华为 荣耀8", 2399.0, new Date(), "质量好！3"));
        list.add(new Item(4, "4华为 荣耀8", 2399.0, new Date(), "质量好！4"));
        list.add(new Item(5, "5华为 荣耀8", 2399.0, new Date(), "质量好！5"));
        list.add(new Item(6, "6华为 荣耀8", 2399.0, new Date(), "质量好！6"));

        // 创建ModelAndView，用来存放数据和视图
        ModelAndView modelAndView = new ModelAndView();
        // 设置数据到模型中
        modelAndView.addObject("itemsList", list);
        //相当于是request.setAttribute();

       // modelAndView.setViewName("/WEB-INF/jsp/itemsList.jsp"); // 直接指定返回的视图解析器的物理地址
        modelAndView.setViewName("itemsList");//springmvc.xml中配置了视图解析器，最终jsp物理地址：前缀+逻辑视图名+后缀

        return modelAndView;
    }

}
