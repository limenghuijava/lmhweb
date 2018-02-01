package cn.lmhweb.springmvc.controller;

import cn.lmhweb.springmvc.module.Item;
import cn.lmhweb.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    // @RequestMapping：里面放的是请求的url，和用户请求的url进行匹配
    // action可以写也可以不写

    @Autowired
    private ItemService itemService;

    @RequestMapping("/queryItem.action")
    public ModelAndView queryItemList() {
        // 创建页面需要显示的商品数据
        List<Item> list = itemService.queryAllItems();


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
