package com.kbstar.service;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Item;
import com.kbstar.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartMapper cartMapper;

    public void addCart(int userId, int itemId) {
        Cart cart = new Cart(userId, itemId, 1);
        List<Cart> byItemId = cartMapper.findByItemId(itemId);
        if (byItemId.stream().filter(cart1 -> cart1.getUserId() == userId).findAny().isEmpty()) {
            cartMapper.addCart(cart);
        } else {
            cartMapper.increaseCnt(userId, itemId);
        }
    }

    public List<Item> myCart(int userId) {
        return cartMapper.findByUserId(userId);
    }

    public void deleteItem(int id) {
        log.info("===========아이템 삭제 서비스============");
        cartMapper.deleteItem(id);
    }

    public void decreaseItem(int id) {
//        cartMapper.decreaseItem(id);
    }

    public Map<String, Integer> calculate(int userId) {
        Map<String, Integer> calMap = new HashMap<>();
        List<Item> cartList = cartMapper.findByUserId(userId);
        int cnt = 0;
        int price = 0;
        for (Item cart : cartList) {
            cnt += cart.getCnt();
            price += cart.getPrice();
        }
        calMap.put("cnt", cnt);
        calMap.put("price", price);
        return calMap;
    }

    public void deleteCart(int userId) {
        cartMapper.deleteCart(userId);
    }

}
