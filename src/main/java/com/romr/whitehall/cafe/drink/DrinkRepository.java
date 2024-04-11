package com.romr.whitehall.cafe.drink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class DrinkRepository {

    private static final Logger log = LoggerFactory.getLogger(DrinkRepository.class);
    private final JdbcClient jdbcClient;

    public DrinkRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Drink> getAll() {
        return jdbcClient.sql("SELECT * FROM drinks")
                .query(Drink.class)
                .list();
    }

    public Optional<Drink> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM drinks WHERE id = :id")
                .param("id", id)
                .query(Drink.class)
                .optional();
    }

    public void create(Drink drink) {
        var updated = jdbcClient.sql("INSERT INTO drinks (id, name, description, price, volume, category, image, date_added, date_modified, order_id) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
                .params(List.of(drink.id(), drink.name(), drink.description(), drink.price(), drink.volume(), drink.category().toString(), drink.image(), drink.dateAdded(), drink.dateModified(), drink.orderId()))
                .update();

        Assert.state(updated == 1, "Failed to create drink " + drink.name());
    }

    public void update(Drink drink, Integer id) {
        Assert.notNull(drink.price(), "Price must not be null");

        var updated = jdbcClient.sql("update drinks  set name = ?, description = ?, price = ?, volume = ?, category = ?, image = ?, date_added = ?, date_modified = ?, order_id = ?  where id = ?")
                .params(List.of(drink.name(), drink.description(), drink.price(), drink.volume(), drink.category().toString(), drink.image(), drink.dateAdded(), drink.dateModified(), drink.orderId(), id))
                .update();

        Assert.state(updated == 1, "Failed to update drink " + drink.name());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from drinks where id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete drink " + id);
    }

    public int count() {
        return jdbcClient.sql("select * from drinks").query().listOfRows().size();
    }

}
