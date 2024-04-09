package com.romr.whitehall.cafe.drink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DrinkRepository {

    private static final Logger log = LoggerFactory.getLogger(DrinkRepository.class);
    private final JdbcClient jdbcClient;

    public DrinkRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    List<Drink> getAllDrinks() {
        return jdbcClient.sql("SELECT * FROM drinks")
                .query(Drink.class)
                .list();
    }

}
