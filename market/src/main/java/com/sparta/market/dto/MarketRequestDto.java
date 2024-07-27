package com.sparta.market.dto;

public class MarketRequestDto {

    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;




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
