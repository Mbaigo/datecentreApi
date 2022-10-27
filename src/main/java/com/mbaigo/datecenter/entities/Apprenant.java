package com.mbaigo.datecenter.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity @Builder
@Data @AllArgsConstructor @NoArgsConstructor
public class Apprenant{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String picture;
    private Date birthday;
    @Column(name = "image", unique = false, nullable = false, length = 100000)
    private byte[] photo;
    private Date created;

}
