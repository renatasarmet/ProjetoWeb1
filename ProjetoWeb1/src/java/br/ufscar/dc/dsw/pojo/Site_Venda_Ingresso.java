/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.pojo;

/**
 *
 * @author Leonardo
 */
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"url"})})
public class Site_Venda_Ingresso extends Usuario {
    
    private String url;
    private String nome;
    private String telefone;

    public void setId_usuario(Long id_usuario) {
        super.setId(id_usuario);
    }
    
    public Long getId_usuario() {
        return super.getId();
    }

    public String getUrl() {
        return url;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
