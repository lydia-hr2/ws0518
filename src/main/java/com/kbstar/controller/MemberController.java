package com.kbstar.controller;

import com.kbstar.dto.Member;
import com.kbstar.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Slf4j
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder encoder;
    String dir = "/member";



    @Valid
    @RequestMapping("/signinimpl")
    public String signinimpl(@Valid @RequestBody Member member, Model model, HttpSession session) throws Exception {
        try {
            member.setPassword(encoder.encode(member.getPassword()));
            memberService.register(member);
            session.setMaxInactiveInterval(100000);
            session.setAttribute("loginmember",member);
        } catch (Exception e) {
            throw new Exception("가입 오류");
        }
        model.addAttribute("rmember", member);
        return "redirect:/";
    }
}
