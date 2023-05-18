package com.kbstar.chart;

import com.kbstar.dto.Chart;
import com.kbstar.service.ChartService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class MonthlyTotalTest {

    @Autowired
    ChartService service;

    @Test
    void contextLoads(){
        try {
            List<Chart> list = service.getMonthlyTotal();
            JSONArray ja = new JSONArray();
            for(Chart c:list){
                    ja.add(c.getTotal());
            }
            log.info(ja.toJSONString());
        } catch (Exception e) {
            log.info("에러 ..... ");
          // e.printStackTrace();
        }
    }
}
// [] 배열에 데이터 출력  :: [280000,150000,100000,420000,180000]