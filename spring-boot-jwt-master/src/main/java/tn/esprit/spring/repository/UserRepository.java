package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Child;
import tn.esprit.spring.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

  boolean existsByUsername(String username);

  User findByUsername(String username);

  @Transactional
  void deleteByUsername(String username);

  @Query("select s from User s where s.username like %?1%")
  List<User> findByName(String username);
  
  @Query("FROM User ORDER BY username ASC")
  List<User> findAllOrderByUsernameAsc();

  Page<User> findAll(Pageable pageable);

  User findById(Long id);

  Child save(Child c);
  User findByEmailIdIgnoreCase(String emailId);

}
