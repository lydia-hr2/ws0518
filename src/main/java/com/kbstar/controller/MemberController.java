package com.kbstar.controller;

import com.kbstar.dto.Member;
import com.kbstar.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class MemberController {

    @Autowired
    MemberService memberService;
    String dir = "/member";



    @RequestMapping("/signinimpl")
    public String signinimpl(Model model, Member member, HttpSession session) throws Exception {
        memberService.register(member);
        model.addAttribute("center","center");
        return "index";
    }



}
