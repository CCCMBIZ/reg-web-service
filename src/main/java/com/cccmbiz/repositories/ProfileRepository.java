package com.cccmbiz.repositories;

import com.cccmbiz.domain.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfileRepository extends CrudRepository<Profile, Integer>{
    Profile findProfileByUid(String uid);
}
