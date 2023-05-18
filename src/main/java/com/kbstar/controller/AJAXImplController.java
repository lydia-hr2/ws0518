package com.kbstar.controller;

import com.kbstar.dto.Chart;
import com.kbstar.dto.Review;
import com.kbstar.service.ChartService;
import com.kbstar.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class AJAXImplController {

    @Autowired
    ChartService service;

    @Autowired
    ReviewService reviewService;

    @RequestMapping("/gmtchart")
    public Object gmtchart() throws Exception {
        List<Chart> list = service.getMonthlyTotal();
        JSONArray data = new JSONArray();
        for(Chart c:list){
            data.add(c.getTotal());
        }
        return data;
        }
}


