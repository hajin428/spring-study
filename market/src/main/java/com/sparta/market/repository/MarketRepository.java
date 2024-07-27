package com.sparta.market.repository;

import com.sparta.market.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface MarketRepository extends JpaRepository<Market, Long> {
    void update(Market market);
}
