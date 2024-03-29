
// Write your code here

package com.example.dinemaster.repository;/*
                                          *
                                          * You can use the following import statements
                                          * 
                                          * import org.springframework.data.jpa.repository.JpaRepository;
                                          * import org.springframework.stereotype.Repository;
                                          * 
                                          */

// Write your code here

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefJpaRepository extends JpaRepository<Chef, Integer> {
    // You can add custom query methods here if needed
}