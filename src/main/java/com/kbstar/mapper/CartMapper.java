package com.kbstar.mapper;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    void addCart(Cart cart);

    List<Item> findByUserId(int userId);

    List<Cart> findByItemId(int itemId);

    void increaseCnt(int userId, int itemId);

    void deleteItem(int id);

    void deleteCart(int userId);


}
