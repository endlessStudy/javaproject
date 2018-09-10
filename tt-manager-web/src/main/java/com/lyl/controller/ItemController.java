package com.lyl.controller;

import com.lyl.pojo.TbItem;
import com.lyl.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EUDataGridResult;

/**
 * Created by liuyl on 2018/3/21.
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/{id}")
    @ResponseBody
    public TbItem getItemById(@PathVariable long id){
        return itemService.getItemById(id);
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(int page, int rows){
        return itemService.getItemList(page,rows);
    }
}
