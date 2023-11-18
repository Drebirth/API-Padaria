package com.api.padaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "CURRICULOS")
public class Curriculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String nomeCompleto;


    private String dataNascimento;


    private String bairro;

    private String faleSobreVoce;

    @OneToOne
    private Cargo cargo;


    private String telefone;


    @Email
    private String email;

    public Curriculo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getFaleSobreVoce() {
        return faleSobreVoce;
    }

    public void setFaleSobreVoce(String faleSobreVoce) {
        this.faleSobreVoce = faleSobreVoce;
    }


    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
