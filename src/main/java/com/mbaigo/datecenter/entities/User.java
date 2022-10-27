package com.mbaigo.datecenter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String profileImageUrl;
    private Date lastLoginDate;
    private Date getLastLoginDateDisplay;
    private Date joinDate;  // date de creation du compte
    private String[] roles;  //role de l'utilisateur
    private String[] authorities;  // les permissions de l'utilisateur
    private boolean isActive;
    private boolean isNotLocked;


}
