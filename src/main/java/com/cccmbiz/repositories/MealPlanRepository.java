package com.cccmbiz.repositories;

import com.cccmbiz.domain.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MealPlanRepository extends CrudRepository<MealPlan, Integer>{

    @Query(value="SELECT DISTINCT p.household_id As householdId, b1.qty As breakfast1, b2.qty As breakfast2, b3.qty As breakfast3, d1.qty As dinner1, d2.qty As dinner2, d3.qty As dinner3, l1.qty As lunch1, l2.qty As lunch2, l3.qty As lunch3, ( SELECT price FROM meal WHERE id=32 ) AS breakfastFee, ( SELECT price FROM meal WHERE id=29) AS dinnerFee, ( SELECT price FROM meal WHERE id=35) AS lunchFee FROM register r LEFT JOIN profile p ON p.household_id = r.household_id LEFT JOIN register_meal d1 ON d1.register_id = r.id AND d1.meal_id = 29 LEFT JOIN register_meal d2 ON d2.register_id = r.id AND d2.meal_id = 30 LEFT JOIN register_meal d3 ON d3.register_id = r.id AND d3.meal_id = 31 LEFT JOIN register_meal b1 ON b1.register_id = r.id AND b1.meal_id = 32 LEFT JOIN register_meal b2 ON b2.register_id = r.id AND b2.meal_id = 33 LEFT JOIN register_meal b3 ON b3.register_id = r.id AND b3.meal_id = 34 LEFT JOIN register_meal l1 ON l1.register_id = r.id AND l1.meal_id = 35 LEFT JOIN register_meal l2 ON l2.register_id = r.id AND l2.meal_id = 36 LEFT JOIN register_meal l3 ON l3.register_id = r.id AND l3.meal_id = 37 where r.event_id=17", nativeQuery=true)
    List<MealPlanProjection> findAllMealPlan();

    @Query(value="SELECT DISTINCT p.household_id As householdId, b1.qty As breakfast1, b2.qty As breakfast2, b3.qty As breakfast3, d1.qty As dinner1, d2.qty As dinner2, d3.qty As dinner3, l1.qty As lunch1, l2.qty As lunch2, l3.qty As lunch3, ( SELECT price FROM meal WHERE id=32 ) AS breakfastFee, ( SELECT price FROM meal WHERE id=29) AS dinnerFee, ( SELECT price FROM meal WHERE id=35) AS lunchFee FROM register r LEFT JOIN profile p ON p.household_id = r.household_id LEFT JOIN register_meal d1 ON d1.register_id = r.id AND d1.meal_id = 29 LEFT JOIN register_meal d2 ON d2.register_id = r.id AND d2.meal_id = 30 LEFT JOIN register_meal d3 ON d3.register_id = r.id AND d3.meal_id = 31 LEFT JOIN register_meal b1 ON b1.register_id = r.id AND b1.meal_id = 32 LEFT JOIN register_meal b2 ON b2.register_id = r.id AND b2.meal_id = 33 LEFT JOIN register_meal b3 ON b3.register_id = r.id AND b3.meal_id = 34 LEFT JOIN register_meal l1 ON l1.register_id = r.id AND l1.meal_id = 35 LEFT JOIN register_meal l2 ON l2.register_id = r.id AND l2.meal_id = 36 LEFT JOIN register_meal l3 ON l3.register_id = r.id AND l3.meal_id = 37 where r.event_id=17 AND p.household_id = :householdId", nativeQuery=true)
    List<MealPlanProjection> findMealPlanByHouseholdId(@Param("householdId") Integer householdId);
}
