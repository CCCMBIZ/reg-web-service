package com.cccmbiz.repositories;

import com.cccmbiz.domain.Register;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RegisterRepository extends CrudRepository<Register, Integer>{
    public Register findByHouseholdId(Integer householdId);

    @Query(value="SELECT p.profile_id AS profileId, register.id AS registerId FROM (register JOIN JSON_TABLE(register.profile_id, '$[*]' COLUMNS (profile_id int path '$')) p) ", nativeQuery=true)
    List<RegisterProfileProjection> getRegisterProfile();
}
