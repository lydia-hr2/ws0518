package com.kbstar.controller;

import com.kbstar.dto.Review;
import com.kbstar.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequestMapping("/review")
@Controller
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    String dir = "review/";

    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, Integer id) throws Exception {
        reviewService.remove(id);
        return "redirect:/review/reviewall";
    }

    @RequestMapping("/reviewall")
    public String reviewall(Model model) {
        List<Review> list = null;
        try {
            list = reviewService.get();
        } catch (Exception e) {
            log.error("리뷰 목록을 불러오지 못하였습니다.", e);
            throw new RuntimeException("리뷰 목록을 불러오지 못하였습니다.");
        }
        model.addAttribute("main", dir + "reviewall");
        model.addAttribute("reviewlist", list);
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model, Integer id) throws Exception  {
        Review review = null;
        try {
            review = reviewService.get(id);
        } catch (Exception e) {
            log.error("시스템 장애", e);
        }
        model.addAttribute("reviewinfo", review);
        model.addAttribute("main", dir+"detail"); // dir 변수의 값이 정의되어 있다면 해당 값을 사용해야 함
        return "index";
    }
}
