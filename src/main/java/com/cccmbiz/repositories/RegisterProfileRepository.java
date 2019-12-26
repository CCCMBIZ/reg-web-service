package com.cccmbiz.repositories;

import com.cccmbiz.domain.Mealplan;
import com.cccmbiz.domain.RegisterProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RegisterProfileRepository extends CrudRepository<RegisterProfile, Integer> {

    @Query(value="SELECT p.profile_id AS profileId, register.id AS registerId FROM (register JOIN JSON_TABLE(register.profile_id, '$[*]' COLUMNS (profile_id int path '$')) p) ", nativeQuery=true)
    List<RegisterProfileProjection> getRegisterProfile();

}