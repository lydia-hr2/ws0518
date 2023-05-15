package com.kbstar.service;

import com.kbstar.dto.Order;
import com.kbstar.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper mapper;

    public void insert(Order order) {
        mapper.insert(order);
    }

}
