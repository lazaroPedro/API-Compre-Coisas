package com.lazaro.comprecoisas.model.dtos;

import com.lazaro.comprecoisas.model.enums.Genero;
import com.lazaro.comprecoisas.model.enums.StatusConta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class UsuarioDTO {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private String telefone;
    @NotNull
    private Genero genero;

    private List<Long> enderecosId;



    @NotNull
    private LocalDateTime dataNascimento;

    private StatusConta statusConta;

    private LocalDateTime dataCadastro;

    public UsuarioDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public StatusConta getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public List<Long> getEnderecosId() {
        return enderecosId;
    }

    public void setEnderecosId(List<Long> enderecosId) {
        this.enderecosId = enderecosId;
    }
}
