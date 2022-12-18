package com.maliitourist.apigestionregions.apigestionregions.payload.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String username;
  private String nom;
  private String prenom;
  private List<String> roles;

  public JwtResponse(String accessToken, Long id, String username, String nom,String prenom, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.nom = nom;
    this.prenom = prenom;
    this.roles = roles;
  }

  // public String getAccessToken() {
  //   return token;
  // }

  // public void setAccessToken(String accessToken) {
  //   this.token = accessToken;
  // }

  // public String getTokenType() {
  //   return type;
  // }

  // public void setTokenType(String tokenType) {
  //   this.type = tokenType;
  // }

  // public Long getId() {
  //   return id;
  // }

  // public void setId(Long id) {
  //   this.id = id;
  // }

  // public String getEmail() {
  //   return email;
  // }

  // public void setEmail(String email) {
  //   this.email = email;
  // }

  // public String getUsername() {
  //   return username;
  // }

  // public void setUsername(String username) {
  //   this.username = username;
  // }

  // public List<String> getRoles() {
  //   return roles;
  // }
}
