package com.api.padaria.model;


import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USUARIO")
    private String userName;
    @Column(name = "SENHA")
    private String senha;

    public Usuario(Long id, String userName, String senha) {
        this.id = id;
        this.userName = userName;
        this.senha = senha;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
