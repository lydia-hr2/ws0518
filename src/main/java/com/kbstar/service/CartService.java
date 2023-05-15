package com.kbstar.service;

import com.kbstar.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import x.senior.item.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartMapper cartMapper;

    public void addCart(int userId, int itemId) {
        List<Item> byUserId = cartMapper.findByUserId(userId);

        Item foundCart = byUserId.stream().filter(item -> itemId == item.getId()).findFirst().orElse(null);
        log.info("===============foundCart=============={}", foundCart);
        if (foundCart == null) {
            cartMapper.addCart(userId, itemId);
            return;
        }
        cartMapper.increaseCnt(userId, itemId);
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
        Map<String, Integer> calMap = new HashMap<String, Integer>();
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
}
