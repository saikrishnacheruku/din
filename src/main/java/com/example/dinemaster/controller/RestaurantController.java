package com.example.dinemaster.controller;
// Write your code here


import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.service.RestaurantJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController

public class RestaurantController {

    @Autowired
    private RestaurantJpaService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }


    @GetMapping("/restaurants/{restaurantId}")

    public Restaurant getRestaurantById(@PathVariable("restaurantId") int restaurantId){
        return restaurantService.getRestaurantById(restaurantId);
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addRestaurant(restaurant);
    }


    @PutMapping("/restaurants/{restaurantId}")
    public  Restaurant updateRestaurant(@PathVariable("restaurantId") int restaurantId,@RequestBody Restaurant restaurant){
        return  restaurantService.updateRestaurant(restaurantId,restaurant);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(@PathVariable("restaurantId") int restaurantid){
        restaurantService.deleteRestaurant(restaurantid);
    }
}
