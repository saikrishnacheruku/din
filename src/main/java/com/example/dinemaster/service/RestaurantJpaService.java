package com.example.dinemaster.service;/*
                                       *
                                       * You can use the following import statements
                                       * 
                                       * import org.springframework.beans.factory.annotation.Autowired;
                                       * import org.springframework.http.HttpStatus;
                                       * import org.springframework.stereotype.Service;
                                       * import org.springframework.web.server.ResponseStatusException;
                                       * 
                                       * import java.util.ArrayList;
                                       * import java.util.List;
                                       * 
                                       */

// Write your code here

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.RestaurantJpaRepository;
import com.example.dinemaster.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RestaurantJpaService implements RestaurantRepository {

    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantJpaRepository.findAll();
    }

    public Restaurant getRestaurantById(int restaurantId) {

        try {
            Restaurant restaurant = restaurantJpaRepository.findById(restaurantId).get();
            return restaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {

        return restaurantJpaRepository.save(restaurant);

    }

    @Override
    public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant) {

        try {
            Restaurant newRestaurant = restaurantJpaRepository.findById(restaurantId).get();

            if (restaurant.getRating() != 0) {
                newRestaurant.setRating(restaurant.getRating());
            }

            restaurantJpaRepository.save(newRestaurant);
            return newRestaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        try {
            restaurantJpaRepository.deleteById(restaurantId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
