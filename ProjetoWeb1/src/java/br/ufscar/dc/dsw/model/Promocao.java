/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.model;

import java.util.Date;


/**
 *
 * @author Renata
 */
public class Promocao {

    private int id;
    private String url;
    private String cnpj;
    private String nome;
    private float preco;
    private Date data_sessao;

    public Promocao(int id) {
        this.id = id;
    }

    public Promocao(String url, String cnpj, String nome, float preco, Date data_sessao) {
        this.url = url;
        this.cnpj = cnpj;
        this.nome = nome;
        this.preco = preco;
        this.data_sessao = data_sessao;
    }
    
    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public Date getData_sessao() {
        return data_sessao;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setData_sessao(Date data_sessao) {
        this.data_sessao = data_sessao;
    }

    
    
}

