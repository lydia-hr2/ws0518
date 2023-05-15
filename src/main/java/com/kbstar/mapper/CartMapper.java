package com.kbstar.mapper;

import com.kbstar.dto.Cart;
import org.apache.ibatis.annotations.Mapper;
import x.senior.item.Item;

import java.util.List;

@Mapper
public interface CartMapper {
    void addCart(int userId, int itemId);

    List<Item> findByUserId(int userId);

    List<Cart> findByItemId(int itemId);

    void increaseCnt(int userId, int itemId);

    void deleteItem(int id);

}
