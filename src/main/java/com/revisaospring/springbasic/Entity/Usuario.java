package com.revisaospring.springbasic.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "telefne", nullable = false, length = 50)
    private int telefne;
    
    @Column(name = "userename", nullable = false, length = 50)
    private String userename;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "role", nullable = false, length = 100)
    private String role;



    public Usuario() {
    }

    public Usuario(long id, String nome, int telefne, String userename, String password, String role) {
        this.id = id;
        this.nome = nome;
        this.telefne = telefne;
        this.userename = userename;
        this.password = password;
        this.role = role;
    }



}
