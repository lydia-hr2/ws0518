package com.kbstar.controller;

import com.kbstar.dto.Member;
import com.kbstar.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    MemberService memberService;

    String dir = "member/";

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("main", dir+"add");
        return "index";
    }

    @RequestMapping("/addimpl")
    public String addimpl(Model model, @Validated Member member, Errors errors) throws Exception {
        if(errors.hasErrors()){
            List<ObjectError> es = errors.getAllErrors();
            String msg ="";
            for(ObjectError e:es){
                msg += "<h4>";
                msg += e.getDefaultMessage();
                msg += "</h4>";
            }
            throw new Exception(msg);
        }
        member.setPassword(encoder.encode(member.getPassword()));
        memberService.register(member);
        return "redirect:/member/all";
    }


    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        List<Member> list = null;
        list = memberService.get();
        model.addAttribute("mlist", list);
        model.addAttribute("main", dir+"all");
        return "index";
    }

    @RequestMapping("/detail")   //로그인 사용자 아이디 클릭 시 정보조회
    public String detail(Model model, Integer id) throws Exception {
        Member member =null;
        try {
            member = memberService.get(id);
        } catch (Exception e) {
            e.printStackTrace();
//            log.info(dir+detail());
            throw new Exception("시스템 장애");
        }
        model.addAttribute("memberinfo", member);    //뿌릴 정보를 준비하고
        model.addAttribute("main", dir+"detail");     //센터에 정보를 뿌림
        return "index";
    }

    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, @Validated Member member, Errors errors) throws Exception {
        if(errors.hasErrors()){
            List<ObjectError> es = errors.getAllErrors();    //Member(dto)에 담아둠(Size와 DefaultMessage)
            String msg ="";
            for(ObjectError e:es){
                msg += "<h4>";
                msg += e.getDefaultMessage();
                msg += "</h4>";
            }
            throw new Exception(msg);
        }
        member.setPassword(encoder.encode(member.getPassword())); //password 암호화
        memberService.modify(member);
        return "redirect:/member/detail?id="+member.getId(); //수정이 일어난 후, "/detail?id="로 다시 보냄
    }

    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, Integer id) throws Exception {
        memberService.remove(id);
        return "redirect:/member/all";
    }
}
