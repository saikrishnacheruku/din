/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here

/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.dinemaster.repository;

import com.example.dinemaster.model.*;
import java.util.*;

public interface ChefRepository {
    List<Chef> getRestaurantChefs();

    Chef getChefById(int chefId);

    Chef addChef(Chef chef);

    Chef updateChef(int chefId, Chef chef);

    void deleteChef(int chefId);

    Restaurant getChefRestaurant(int chefId);
}