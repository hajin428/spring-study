package com.sparta.market.controller;

import com.sparta.market.dto.MarketRequestDto;
import com.sparta.market.dto.MarketResponseDto;
import com.sparta.market.entity.Market;
import com.sparta.market.service.MarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class MarketController {

    private final MarketService marketService;
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }



    //판매 게시글 작성
    @PostMapping
    public MarketResponseDto postSale(@RequestBody MarketRequestDto marketRequestDto) {
        return marketService.salePost(marketRequestDto);
    }

    //판매 게시글 상세 조회
    @GetMapping("/{id}")
    public MarketResponseDto getSaleById(@PathVariable Long id) {
        return marketService.getSaleById(id);
    }

    //판매 게시글 전체 조회
    @GetMapping
    public List<MarketResponseDto> findAll() {
        return marketService.findAll();
    }

    //판매 게시글 수정
    @PutMapping("/{id}")
    public Long updateSale(@PathVariable Long id, @RequestBody MarketRequestDto marketRequestDto) {
        return marketService.updateSale(id, marketRequestDto);
    }

    //판매 게시글 삭제
    @DeleteMapping("/{id}")
    public String deleteSale(@PathVariable Long id) {
        return marketService.deleteSale(id);
    }


}



