package tn.esprit.spring.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  ROLE_ADMIN, ROLE_PARENT, ROLE_DOCTOR, ROLE_DIRECTOR;

  public String getAuthority() {
    return name();
  }

}
