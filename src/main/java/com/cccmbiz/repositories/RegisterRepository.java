package com.cccmbiz.repositories;

import com.cccmbiz.domain.Register;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RegisterRepository extends CrudRepository<Register, Integer>{
    public Register findByHouseholdId(Integer householdId);
}
