package tn.esprit.spring;

import java.util.ArrayList;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import tn.esprit.spring.config.FileStorageProperties;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.UserServiceImpl;
@EnableConfigurationProperties({
    FileStorageProperties.class
})
@SpringBootApplication
public class JwtAuthServiceApp implements CommandLineRunner {

  @Autowired
  UserServiceImpl userService;

  public static void main(String[] args) {
    SpringApplication.run(JwtAuthServiceApp.class, args);
  }

@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	
}

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
/*
  @Override
  public void run(String... params) throws Exception {
    User admin = new User();
    admin.setUsername("admin");
    admin.setPassword("admin");
    admin.setEmail("admin@email.com");
    admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.signup(admin);

    User client = new User();
    client.setUsername("client");
    client.setPassword("client");
    client.setEmail("client@email.com");
    client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));

    userService.signup(client);
  }
*/
}
