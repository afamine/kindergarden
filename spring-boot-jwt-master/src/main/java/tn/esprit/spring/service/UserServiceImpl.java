package tn.esprit.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lowagie.text.pdf.PdfWriter;

import tn.esprit.spring.dto.ChildDTO;
import tn.esprit.spring.dto.UserDataDTO;
import tn.esprit.spring.entities.Child;
import tn.esprit.spring.entities.Director;
import tn.esprit.spring.entities.Doctor;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.exception.CustomException;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.JwtTokenProvider;

@Service
public class UserServiceImpl{

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private AuthenticationManager authenticationManager;

  public String signin(String username, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
      return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public String signup(UserDataDTO user) {
	    if (!userRepository.existsByUsername(user.getUsername())) {
	      user.setPassword(passwordEncoder.encode(user.getPassword()));
	      
	      
	      System.out.println("zzz"+user.getRoles().get(0).getAuthority());
	      
	      if(user.getRoles().get(0).getAuthority().equals("ROLE_DIRECTOR")) {
	    	  
	    	  
	    	  Director d = new Director();
	    	  d.setUsername(user.getUsername());
	    	  d.setPassword(user.getPassword());
	    	  d.setEmail(user.getEmail());
	    	  d.setRoles(user.getRoles());
	    	  d.setNumD(user.getNumD());
	    	  d.setCv(user.getCv());
	    	  
	    	  
	    	  userRepository.save(d);
	    	  
	      }
 if(user.getRoles().get(0).getAuthority().equals("ROLE_DOCTOR")) {
	    	  
	    	  
	    	  Doctor doc = new Doctor();
	    	  doc.setUsername(user.getUsername());
	    	  doc.setPassword(user.getPassword());
	    	  doc.setEmail(user.getEmail());
	    	  doc.setRoles(user.getRoles());
	    	  doc.setNumDct(user.getNumDct());
	    	  doc.setSpecialite(user.getSpecialite());
	    	  
	    	  userRepository.save(doc);
	    	  
	      }
 if(user.getRoles().get(0).getAuthority().equals("ROLE_PARENT")) {
	  
	  
	  Parent p = new Parent();
	  p.setUsername(user.getUsername());
	  p.setPassword(user.getPassword());
	  p.setEmail(user.getEmail());
	  p.setRoles(user.getRoles());
	  p.setAdresse(user.getAdresse());
	  p.setDateReg(user.getDateReg());
	  p.setEtatCivil(user.getEtatCivil());
	  
	  userRepository.save(p);
	  
 }
 if(user.getRoles().get(0).getAuthority().equals("ROLE_ADMIN")) {
	  
	  
	  User p = new User();
	  p.setUsername(user.getUsername());
	  p.setPassword(user.getPassword());
	  p.setEmail(user.getEmail());
	  p.setRoles(user.getRoles());
	 
	  
	  userRepository.save(p);
	  
}

 
	      
	    //  userRepository.save(user);
	      return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
	    } else {
	      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	  }

  public void delete(String username) {
    userRepository.deleteByUsername(username);
  }

  public User search(String username) {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
    }
    return user;
  }

  public User whoami(HttpServletRequest req) {
    return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
  }

  public String refresh(String username) {
    return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
  }

  public List<User> findAllOrderByUsernameAsc() {
      return userRepository.findAllOrderByUsernameAsc();
  }

  
  public Page<User> listByPage(org.springframework.data.domain.Pageable pageable) {
      return userRepository.findAll(pageable);
  }

public User registerNewUserAccount(@Valid UserDataDTO userDto) {
	// TODO Auto-generated method stub
	return null;
}

public Child save(ChildDTO child) {
	Child c =new Child();
	c.setAge(child.getAge());
	c.setFirstname(child.getFirstname());
	c.setLastname(child.getLastname());
	c.setPicture(child.getPicture());
	c.setSex(child.getSex());
	
	return  userRepository.save(c);
	
}

public List<User> listAll() {
    return userRepository.findAll(Sort.by("email").ascending());
}


}
