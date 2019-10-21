package com.cccmbiz.repositories;

import com.cccmbiz.domain.Event;
import com.cccmbiz.domain.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MealRepository extends CrudRepository<Meal, Integer>{
    List<Meal> findByLocation(Byte location);

    List<Meal> findByEventByEventId(Event event);
}
