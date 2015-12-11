package com.example.flaviano.cadastroeconsultatcc;

/**
 * Created by Flaviano on 04/12/2015.
 */
public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private String funcao;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Usuario(int id, String nome, String cpf, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario() {

    }
    public String toString()
    {
        return getNome() +" - " + getCpf() +" - " + getFuncao();
    }
}
