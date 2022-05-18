package com.libreria.libreria.persistencia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String nombre;
    @Column(name = "surname")
    private String apellidos;
    @Column(name = "telephone")
    private String telefono;
    @Column(name = "age")
    private String edad;
    @Column(name = "county")
    private String provincia;

    @OneToMany(mappedBy = "usuario")
    private List<Book> books;

}
