/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.projetoweb.pojo;

import br.ufscar.dc.dsw.dao.TeatroDAO;
import java.util.Date;
import javax.persistence.Entity;


/**
 *
 * @author Renata
 */
@Entity
public class Promocao {
    
    private int id;
    private String nome;
    private float preco;
    private String data_sessao;
    private String horario_sessao;

    private Teatro teatro;
    private Site_Venda_Ingresso site_Venda_Ingresso;
    
    public Promocao(int id) {
        this.id = id;
    }

    public Promocao(Teatro teatro, Site_Venda_Ingresso site_Venda_Ingresso, String nome, float preco, String data_sessao, String horario_sessao) {
        this.teatro = teatro;
        this.site_Venda_Ingresso = site_Venda_Ingresso;
        this.nome = nome;
        this.preco = preco;
        this.data_sessao = data_sessao;
        this.horario_sessao = horario_sessao;   
    }

    public Promocao(int id, Teatro teatro, Site_Venda_Ingresso site_Venda_Ingresso, String nome, float preco, String data_sessao, String horario_sessao) {
        this.id = id;
        this.teatro = teatro;
        this.site_Venda_Ingresso = site_Venda_Ingresso;
        this.nome = nome;
        this.preco = preco;
        this.data_sessao = data_sessao;
        this.horario_sessao = horario_sessao;
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public Site_Venda_Ingresso getSite_Venda_Ingresso() {
        return site_Venda_Ingresso;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }

    public void setSite_Venda_Ingresso(Site_Venda_Ingresso site_Venda_Ingresso) {
        this.site_Venda_Ingresso = site_Venda_Ingresso;
    }
    
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public String getData_sessao() {
        return data_sessao;
    }
    
    public String getHorario_sessao() {
        return horario_sessao;
    }
      
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setData_sessao(String data_sessao) {
        this.data_sessao = data_sessao;
    }

    public void setHorario_sessao(String horario_sessao) {
        this.horario_sessao = horario_sessao;
    }
    
}

