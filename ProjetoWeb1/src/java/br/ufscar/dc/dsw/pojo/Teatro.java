/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.pojo;

import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author João
 */
@Entity 
@Cacheable(value = false)
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"cnpj"})})
public class Teatro extends Usuario{
    
    private String cnpj;
    private String nome;
    private String cidade;
    
    @OneToMany(mappedBy = "teatro", fetch = FetchType.LAZY)
    private List<Promocao> promocoes;

    public void setId_Usuario(Long id){
        super.setId(id);
    }
    
    public Long getId_Usuario(){
        return super.getId();
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }
    
    public List<Promocao> getPromocoes() {
        return promocoes;
    }
 
    public void setPromocoes(List<Promocao> promocao) {
        this.promocoes = promocoes;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof Teatro))
		return false;
	Teatro other = (Teatro) obj;
	return other.nome.equals(this.nome);
    }
    
    @Override
    public String toString() {
        return nome;
    }

}
