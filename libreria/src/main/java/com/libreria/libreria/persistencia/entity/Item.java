package com.libreria.libreria.persistencia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "item")
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_book")
    private Integer idBook;
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "status")
    private Boolean status;



}
