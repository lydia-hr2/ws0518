package com.kbstar.controller;

import com.kbstar.dto.Review;
import com.kbstar.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Slf4j
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    private BCryptPasswordEncoder encoder;
    String dir = "/review";

    @Valid
    @RequestMapping("/reviewimpl")
    public String reviewimpl(@Valid Review review, Model model, HttpSession session) throws Exception {
        try {
            reviewService.register(review);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("가입 오류");
        }
        model.addAttribute("rreview", review);
        return "redirect:/";
    }



}
