package com.cccmbiz.repositories;

import com.cccmbiz.domain.Meal;
import com.cccmbiz.domain.Register;
import com.cccmbiz.domain.RegisterMeal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RegisterMealRepository extends CrudRepository<RegisterMeal, Integer>{
    RegisterMeal findRegisterMealByRegisterByRegisterIdAndMealByMealId(Register register, Meal meal);
}
