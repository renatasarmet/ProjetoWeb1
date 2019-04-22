/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.model;

/**
 *
 * @author root
 */
public class Usuario {
    private int id;
    private String email;
    private String senha;
    private int ativo;

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(int id, String email, String senha, int ativo) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Usuario(String email, String senha, int ativo) {
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
}