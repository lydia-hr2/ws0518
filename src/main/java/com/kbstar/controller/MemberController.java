package com.kbstar.controller;

import com.kbstar.dto.Member;
import com.kbstar.service.MemberService;
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
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder encoder;
    String dir = "/member";



    @Valid
    @RequestMapping("/signinimpl")
    public String signinimpl(@Valid Member member, Model model, HttpSession session) throws Exception {
        try {
            member.setPassword(encoder.encode(member.getPassword()));
            memberService.register(member);
//            session.setMaxInactiveInterval(100000);
//            session.setAttribute("loginmember",member);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("가입 오류");
        }
        model.addAttribute("rmember", member);
        return "redirect:/";
    }


    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String memberId, String password, HttpSession session) {
        String nextPage = "loginfail";
        try {
            Member member = memberService.get(memberId);
            if (member != null && encoder.matches(password, member.getPassword())) {
                nextPage = "loginok";
                session.setMaxInactiveInterval(100000);// 한 session의 제한시간
                session.setAttribute("loginmember", member); //session에 logincust라는 이름으로 cust를 넣어줌 --> login을 메모리에 제한시간만큼 유지
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("시스템 장애 잠시 후 다시 로그인 하세요.");
        }
        model.addAttribute("center", nextPage);
        return "index";
    }

}
