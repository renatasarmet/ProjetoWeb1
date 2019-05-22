/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.pojo;

/**
 *
 * @author root
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;

    @ManyToOne
    private Papel papel;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }


    public void setId(Long id) {
        this.id = id;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setPapel(Papel papel) {
        this.papel = papel;
    }
}
