package com.sparta.market.dto;

import com.sparta.market.entity.Market;

public class MarketResponseDto {

    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;


    public MarketResponseDto(Market market) {
        this.id = getId();
        this.title = getTitle();
        this.content = getContent();
        this.price = getPrice();
        this.username = getUsername();
    }





    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getContent() {
        return content;
    }


    public int getPrice() {
        return price;
    }


    public String getUsername() {
        return username;
    }


}
