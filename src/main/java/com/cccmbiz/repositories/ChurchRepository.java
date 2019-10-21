package com.cccmbiz.repositories;

import com.cccmbiz.domain.Church;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ChurchRepository extends CrudRepository<Church, Integer>{
}
