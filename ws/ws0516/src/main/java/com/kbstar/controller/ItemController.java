package com.kbstar.controller;

import com.kbstar.dto.Item;
import com.kbstar.service.CartService;
import com.kbstar.service.ItemService;
import com.kbstar.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService service;

    @Autowired
    CartService cartService;

    @Value("${uploadimgdir}")
    String uploadimgdir;

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("main","registerProduct");
        return "index";
    }

    @RequestMapping("/{id}")
    public String detail(Model model, @PathVariable int id) throws Exception {
        Item item = service.get(id);
        model.addAttribute("item", item);
        model.addAttribute("main", "updateProduct");
        return "index";
    }

    @RequestMapping("/registerImpl")
    public String registerImpl(Model model, Item item) throws Exception {
        MultipartFile mf =  item.getImgName();

        //파일에서 이미지를 끄집어 낸다.
        String imgname = mf.getOriginalFilename();
        item.setImg(imgname);

        //db에 파일 저장
        service.register(item);

        //이미지 저장 디렉토리에 이미지를 저장한다.
        //우리가 업로드한 파일이 원하는 폴더로 들어간다(static으로 호출해서 함수 사용)
        FileUploadUtil.saveFile(mf, uploadimgdir);

        return "redirect:/";
    }

    @RequestMapping("/updateImpl")
    public String updateImpl(Model model, Item item) throws Exception {
        MultipartFile mf =  item.getImgName();
        //파일에서 이미지를 끄집어 낸다.
        String imgname = mf.getOriginalFilename();
        if (imgname.equals("") || imgname == null) {
            service.modify(item);
        } else {
            item.setImg(imgname);

            service.modify(item);
            FileUploadUtil.saveFile(mf, uploadimgdir);
            //이미지 저장 디렉토리에 이미지를 저장한다.
            //우리가 업로드한 파일이 원하는 폴더로 들어간다(static으로 호출해서 함수 사용)
        }
        return "redirect:/item/" + item.getId();
    }

    @RequestMapping("/deleteimpl")
    public String deleteimpl(int id) throws Exception {
        service.remove(id);
        return "redirect:/";
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void cronSumCartUpdate() throws Exception {
        int num = cartService.SumCart();
        log.info(num+"");
    }
}