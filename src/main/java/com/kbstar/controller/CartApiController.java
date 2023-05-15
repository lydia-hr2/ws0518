package com.kbstar.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartApiController {

    private final CartService cartService;

    @PostMapping("/delete")
    public ResponseEntity<String> deleteItem(int id) {
        log.info("===========아이템 삭제 컨트롤러============{}", id);
        cartService.deleteItem(id);
        return ResponseEntity.ok().body("item delete complete");
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Integer>> infoItem(int id) {
        Map<String, Integer> result = cartService.calculate(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/decrease")
    public ResponseEntity<Map<String, Integer>> decreaseItem(int id) {
        Map<String, Integer> result = cartService.calculate(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/increase")
    public ResponseEntity<Map<String, Integer>> increaseItem(int id) {
        Map<String, Integer> result = cartService.calculate(id);
        return ResponseEntity.ok().body(result);
    }
}
