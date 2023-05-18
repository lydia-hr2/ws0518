package com.kbstar.mapper;

import com.kbstar.dto.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    void insert(Order order);
}
