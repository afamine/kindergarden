package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Child;

@Repository
public interface ChildRepository extends CrudRepository<Child, Long> {

}
