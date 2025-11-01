package com.chj.postapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "tb_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content",
    length = 1000)
    private String body;
    @Column(name = "views")
    private int views;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;





}
