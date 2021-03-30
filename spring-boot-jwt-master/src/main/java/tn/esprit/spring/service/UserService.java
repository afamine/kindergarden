package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.ChildDTO;
import tn.esprit.spring.entities.Child;
import tn.esprit.spring.entities.User;

public interface  UserService {

    List<User> findAllOrderByUsernameAsc();

	Page<User> listByPage(Pageable pageable);

	Child save(ChildDTO child);
}
