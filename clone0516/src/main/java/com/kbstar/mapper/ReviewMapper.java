package com.kbstar.mapper;

import com.kbstar.dto.Review;
import com.kbstar.frame.ShopMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReviewMapper extends ShopMapper<Integer, Review> {
}
