package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Garden;

@Repository
public interface GardenRepository extends CrudRepository<Garden, Long> {

}
