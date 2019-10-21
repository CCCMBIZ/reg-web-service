package com.cccmbiz.repositories;

import com.cccmbiz.domain.Mealplan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MealplanRepository extends CrudRepository<Mealplan, Integer> {

    @Query(value="SELECT DISTINCT p.household_id As householdId, b1.qty As breakfast1, b2.qty As breakfast2, b3.qty As breakfast3, d1.qty As dinner1, d2.qty As dinner2, d3.qty As dinner3, l1.qty As lunch1, l2.qty As lunch2, l3.qty As lunch3, (SELECT price FROM meal WHERE id = 2) AS breakfastFee, (SELECT price FROM meal WHERE id = 1) AS dinnerFee, (SELECT price FROM meal WHERE id = 3) AS lunchFee FROM register r LEFT JOIN profile p ON p.household_id = r.household_id LEFT JOIN register_meal d1 ON d1.register_id = r.id AND d1.meal_id = 10 LEFT JOIN register_meal d2 ON d2.register_id = r.id AND d2.meal_id = 12 LEFT JOIN register_meal d3 ON d3.register_id = r.id AND d3.meal_id = 13 LEFT JOIN register_meal b1 ON b1.register_id = r.id AND b1.meal_id = 14 LEFT JOIN register_meal b2 ON b2.register_id = r.id AND b2.meal_id = 15 LEFT JOIN register_meal b3 ON b3.register_id = r.id AND b3.meal_id = 27 LEFT JOIN register_meal l1 ON l1.register_id = r.id AND l1.meal_id = 17 LEFT JOIN register_meal l2 ON l2.register_id = r.id AND l2.meal_id = 18 LEFT JOIN register_meal l3 ON l3.register_id = r.id AND l3.meal_id = 28 LEFT JOIN register_meal ad1 ON ad1.register_id = r.id AND ad1.meal_id = 20 ", nativeQuery=true)
    List<MealPlanProjection> findAllCustom();

}