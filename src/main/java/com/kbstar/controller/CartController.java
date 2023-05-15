package com.kbstar.controller;

import com.kbstar.dto.Item;
import com.kbstar.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;


    @PostMapping("/add")
    public void addCart(int userId, int itemId) {
        cartService.addCart(userId, itemId);
    }

    /*
        개수 조정하고 결제 탭으로 진행할 때 shopping cart 개별 cnt를 한번에 조정한다.
        결제가 완료되고 나서는 해당 유저의 장바구니를 삭제한다
     */

    @GetMapping("/{userId}")
    public String myCart(@PathVariable int userId, Model model) {
        List<Item> myCart = cartService.myCart(userId);
        model.addAttribute("myCart", myCart);
        model.addAttribute("center", "shopping-cart");
        return "index";
    }

}
