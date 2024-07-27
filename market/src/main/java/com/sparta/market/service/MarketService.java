package com.sparta.market.service;

import com.sparta.market.dto.MarketRequestDto;
import com.sparta.market.dto.MarketResponseDto;
import com.sparta.market.entity.Market;
import com.sparta.market.repository.MarketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    //판매 게시글 작성
    public MarketResponseDto salePost(MarketRequestDto marketRequestDto) {
        Market market = new Market(marketRequestDto);
        marketRepository.save(market);
        MarketResponseDto marketResponseDto = new MarketResponseDto(market);
        return marketResponseDto;
    }


    //판매 게시글 상세 조회
    public MarketResponseDto getSaleById(Long id) {
        Market market = marketRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        return new MarketResponseDto(market);
    }


    //판매 게시글 전체 조회
    public List<MarketResponseDto> findAll() {
        List<Market> markets = marketRepository.findAll();
        List<MarketResponseDto> marketResponseDtos = new ArrayList<>();
        for (Market market : markets) {
            marketResponseDtos.add(new MarketResponseDto(market));
        }
        return marketResponseDtos;
    }

    //판매 게시글 수정
    public Long updateSale(Long id, MarketRequestDto marketRequestDto) {
        Market market = marketRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        marketRepository.update(market);
        return market.getId();
    }

    //판매 게시글 삭제
    public String deleteSale(Long id) {
        Market market = marketRepository.findById(id).get();
        marketRepository.delete(market);
        return "삭제 완료.";
    }

}
