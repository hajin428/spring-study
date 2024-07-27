package com.sparta.market.entity;

import com.sparta.market.dto.MarketRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Market {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //게시글 식별값

    private String title; //제목

    private String content; //내용

    private int price; //가격

    private String username; //작성자




    public Market (MarketRequestDto marketRequestDto) {
        this.id = marketRequestDto.getId();
        this.title = marketRequestDto.getTitle();
        this.content = marketRequestDto.getContent();
        this.price = marketRequestDto.getPrice();
        this.username = marketRequestDto.getUsername();
    }


    public Market() {}



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
