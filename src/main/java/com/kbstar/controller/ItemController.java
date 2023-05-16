package com.kbstar.controller;

import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("")
    public String shop(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) {
        PageInfo<Item> p;
        p = new PageInfo<>(itemService.getAllItems(pageNo), 5);

        model.addAttribute("cpage", p);
        model.addAttribute("center", "shop");
        return "index";
    }

    @GetMapping("/{id}/detail")
    public String shopDetail(@PathVariable Integer id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        model.addAttribute("center", "shop-details");
        return "index";
    }

}
