package com.romr.whitehall.cafe.drink;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/drinks")
public class DrinkController {

    private final DrinkRepository drinkRepository;

    public DrinkController(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @GetMapping
    List<Drink> getAllDrinks() {
        return drinkRepository.getAll();
    }

    @GetMapping("/{id}")
    Optional<Drink> getDrinkById(@PathVariable Integer id) {
        return drinkRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createDrink(@Valid @RequestBody Drink drink) {
        drinkRepository.create(drink);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateDrink(@Valid @RequestBody Drink drink, @PathVariable Integer id) {
        drinkRepository.update(drink, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteDrink(@PathVariable Integer id) {
        drinkRepository.delete(id);
    }

}
