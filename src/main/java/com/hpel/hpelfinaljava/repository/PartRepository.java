package com.hpel.hpelfinaljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hpel.hpelfinaljava.model.Part;

@RepositoryRestResource(collectionResourceRel = "parts", path = "parts")
public interface PartRepository extends JpaRepository<Part, Long>{

}
