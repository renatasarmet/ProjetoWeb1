/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.model;

/**
 *
 * @author João
 */
public class Teatro extends Usuario{
    
    private String CNPJ;
    private String nome;
    private String cidade;
    
    public Teatro(int id, String email, String senha, String CNPJ, String nome, String cidade) {
        super(id,email,senha,1);
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.cidade = cidade;
    }
    
    public Teatro(String email, String senha, String CNPJ, String nome, String cidade) {
        super(email,senha,1);
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.cidade = cidade;
    }
    public void setId_Usuario(int id){
        super.setId(id);
    }
    public int getId_Usuario(){
        return super.getId();
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }
}
