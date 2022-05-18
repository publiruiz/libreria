package com.libreria.libreria.persistencia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String titulo;
    @Column(name = "author")
    private String autor;
    @Column(name = "type")
    private String genero;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false,updatable = false)
    private User usuario;


}
