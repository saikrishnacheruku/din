package com.example.dinemaster.service;/*
                                       *
                                       * You can use the following import statements
                                       * 
                                       * import org.springframework.beans.factory.annotation.Autowired;
                                       * import org.springframework.http.HttpStatus;
                                       * import org.springframework.stereotype.Service;
                                       * import org.springframework.web.server.ResponseStatusException;
                                       * import java.util.ArrayList;
                                       * import java.util.List;
                                       * 
                                       */

// Write your code here

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.ChefJpaRepository;
import com.example.dinemaster.repository.ChefRepository;
import com.example.dinemaster.repository.RestaurantJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ChefJpaService implements ChefRepository {

    @Autowired
    private ChefJpaRepository chefJpaRepository;

    @Autowired
    private RestaurantJpaService restaurantJpaService;

    public List<Chef> getRestaurantChefs() {
        return chefJpaRepository.findAll();
    }

    @Override
    public Chef getChefById(int chefId) {
        try {
            Chef chef = chefJpaRepository.findById(chefId).get();
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef addChef(Chef chef) {

        // Restaurant restaurant=chef.getRestaurant();
        int restaurantId = chef.getRestaurant().getId();

        Restaurant restaurant = restaurantJpaService.getRestaurantById(restaurantId);

        chef.setRestaurant(restaurant);
        chefJpaRepository.save(chef);
        return chef;

    }

    @Override
    public Chef updateChef(int chefId, Chef chef) {
        try {
            Chef newChef = chefJpaRepository.findById(chefId).get();

            if (chef.getRestaurant() != null) {
                int restaurantId = chef.getRestaurant().getId();

                Restaurant restaurant = restaurantJpaService.getRestaurantById(restaurantId);
                newChef.setRestaurant(restaurant);
            }
            if (chef.getFirstName() != null) {
                newChef.setFirstName(chef.getFirstName());
            }
            if (chef.getLastName() != null) {
                newChef.setLastName(chef.getLastName());
            }
            if (chef.getExpertise() != null) {
                newChef.setExpertise(chef.getExpertise());
            }
            if (chef.getExperienceYears() != 0) {
                newChef.setExperienceYears(chef.getExperienceYears());

            }
            chefJpaRepository.save(newChef);
            return newChef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteChef(int chefId) {
        try {
            chefJpaRepository.deleteById(chefId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Restaurant getChefRestaurant(int chefId) {
        try {
            Chef chef = chefJpaRepository.findById(chefId).get();

            Restaurant restaurant = chef.getRestaurant();

            return restaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

	
	
	

}