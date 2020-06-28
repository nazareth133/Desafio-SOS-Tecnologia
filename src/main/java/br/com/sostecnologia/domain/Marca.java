package br.com.sostecnologia.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "nome")
    private String nome;

}
