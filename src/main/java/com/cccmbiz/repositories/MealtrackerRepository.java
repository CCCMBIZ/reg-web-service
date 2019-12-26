package com.cccmbiz.repositories;

import com.cccmbiz.domain.Mealtracker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MealtrackerRepository extends CrudRepository<Mealtracker, Integer> {

    List<Mealtracker> findByRegisterIdAndMealId(Integer registerId, Integer mealId);

    List<Mealtracker> findByHouseholdIdAndMealId(Integer householdId, Integer mealId);

}
