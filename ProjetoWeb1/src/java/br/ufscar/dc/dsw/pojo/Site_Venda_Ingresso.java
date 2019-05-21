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
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"url"})})
public class Site_Venda_Ingresso extends Usuario {
    
    private String url;
    private String nome;
    private String telefone;

    @OneToMany(mappedBy = "site_venda_ingresso", fetch = FetchType.LAZY)
    private List<Promocao> promocoes;

    
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
    
    public List<Promocao> getPromocoes() {
        return promocoes;
    }
 
    public void setLivros(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof Site_Venda_Ingresso))
		return false;
	Site_Venda_Ingresso other = (Site_Venda_Ingresso) obj;
	return other.nome.equals(this.nome);
    }
    
    @Override
    public String toString() {
        return nome;
    }
}