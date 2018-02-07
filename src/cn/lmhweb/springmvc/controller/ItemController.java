package cn.lmhweb.springmvc.controller;

import cn.lmhweb.springmvc.module.Item;
import cn.lmhweb.ssm.service.ItemService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public ModelAndView queryItemList(Item item) {
        System.out.println(item);
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


    @RequestMapping("/editItem.action")
    public String queryItemListById(String id,Model model) {
        //id从页面中传入的参数，如果没有的话，传入的值是默认值null
        if(Strings.isNotBlank(id)){
            Item item=itemService.queryItemListById(id);
            model.addAttribute("item",item);
        }
        return "editItem";//返回页面的名称，结合配置的师徒解析器可以成功的找到相应的文件
    }

    @RequestMapping(value="/updateItem.action",method= RequestMethod.POST)
    public String editItem(Item item) {
        //id从页面中传入的参数，如果没有的话，传入的值是默认值null
            itemService.editItem(item);
            //更新完成之后，重定向到queryItem.action方法中
//       return "redirect:/item/queryItem.action";
        //转发到请求的方法中
        return "forward:/item/queryItem.action";
    }



}
