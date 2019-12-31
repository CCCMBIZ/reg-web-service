package com.cccmbiz.repositories;

import com.cccmbiz.domain.MealTracker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MealTrackerRepository extends CrudRepository<MealTracker, Integer> {

    List<MealTracker> findByRegisterIdAndMealId(Integer registerId, Integer mealId);

    List<MealTracker> findByHouseholdIdAndMealId(Integer householdId, Integer mealId);

    long countByMealId(Integer mealId);
}
