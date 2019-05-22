/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufscar.dc.dsw.pojo;

import br.ufscar.dc.dsw.dao.TeatroDAO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

/**
 *
 * @author Renata
 */
@Entity
public class Promocao implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private float preco;
    private String data_sessao;
    private String horario_sessao;

    @ManyToOne
    private Teatro teatro;

    @ManyToOne
    private SiteVendaIngresso site_venda_ingresso;


    public Teatro getTeatro() {
        return teatro;
    }

    public SiteVendaIngresso getSite_venda_ingresso() {
        return site_venda_ingresso;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }

    public void setSite_venda_ingresso(SiteVendaIngresso site_venda_ingresso) {
        this.site_venda_ingresso = site_venda_ingresso;
    }
    
    
    public Long getId() {
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
      
    public void setId(Long id) {
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

