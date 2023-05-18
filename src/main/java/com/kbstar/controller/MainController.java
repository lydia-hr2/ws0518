package com.kbstar.controller;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Item;
import com.kbstar.dto.Review;
import com.kbstar.service.AdmService;
import com.kbstar.service.ItemService;
import com.kbstar.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

    private final ItemService service;

    @Autowired
    AdmService admService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @RequestMapping("/")
    public String main(Model model) {
        List<Item> items = null;
        try {
            items = service.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("items", items);
        model.addAttribute("main", "main");
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("main", "login");
        return "index";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("main", "test");
        return "index";
    }


    @RequestMapping("/password")
    public String password(Model model) {
        model.addAttribute("main", "password");
        return "index";
    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String adminId, String pwd
            ,HttpSession session) throws Exception {      //로그인 성공 시 session에다가 넣어둔다
        Adm adm = null;
        String nextPage = "loginfail";
        try {
            adm = admService.get(adminId);
            if(adm != null && encoder.matches(pwd, adm.getPwd())){    //아이디가 있고, 해당하는 아이디의 pwd를 비교 후 일치하면
//                nextPage = "loginok";
                session.setMaxInactiveInterval(1000);  //세션 유지 시간 설정 :: 1000초 지나면 세션 종료(로긴 튕김)
                session.setAttribute("loginadm", adm);   //쎄션에 로긴정보를 박아두는 것  .. index에도 나오는 loginadm
                return "redirect:/";
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("시스템 장애, 잠시 후 다시 로그인 하세요");
        }
        model.addAttribute("main", nextPage);
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session){
        if(session != null){             //로긴 상태면
            session.invalidate();        //세션에서 정보를 없앤다
        }
        return "redirect:/";
//        return "index";
    }


    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("main", "register");
        return "index";
    }

    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, Adm adm
            ,HttpSession session) throws Exception {
        try {
            adm.setPwd(encoder.encode(adm.getPwd()));  //화면에서 입력한 pwd를 가져와서 암호화 후, 다시 adm 객체에 넣어서 register
            admService.register(adm);
            session.setAttribute("loginadm", adm);   //회원가입 시 바로 로그인 처리 되도록하기
        } catch (Exception e) {
            //log.info(e.getMessage());
            throw new Exception("가입오류");
        }
        return "redirect:/";
    }

    @RequestMapping("/sumcart")
    public String sumcart(Model model){
        model.addAttribute("main", "sumcart");
        return "index";
    }

    @RequestMapping("/chart")
    public String chart(Model model) {
        model.addAttribute("main", "charts");
        return "index";
    }

    @RequestMapping("/401")
    public String error401(Model model) {
        model.addAttribute("main", "401");
        return "401";
    }

    @RequestMapping("/404")
    public String error404(Model model) {
        model.addAttribute("main", "404");
        return "404";
    }

    @RequestMapping("/500")
    public String error500(Model model) {
        model.addAttribute("main", "500");
        return "500";
    }

    @RequestMapping("/table")
    public String table(Model model) {
        model.addAttribute("main", "tables");
        return "index";
    }


    @RequestMapping("/product")
    public String product(Model model) {
        model.addAttribute("main", "registerProduct");
        return "index";
    }



}
