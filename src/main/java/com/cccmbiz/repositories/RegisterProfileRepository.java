package com.cccmbiz.repositories;

import com.cccmbiz.domain.MealPlan;
import com.cccmbiz.domain.RegisterProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RegisterProfileRepository extends CrudRepository<RegisterProfile, Integer> {

    @Query(value="SELECT p.profile_id AS profileId, register.id AS registerId FROM (register JOIN JSON_TABLE(register.profile_id, '$[*]' COLUMNS (profile_id int path '$')) p) WHERE register.event_id=33 AND p.profile_id = :profileId ORDER BY last_update DESC limit 1", nativeQuery=true)
    RegisterProfileProjection getRegisterProfile(@Param("profileId") Integer profileId);

}