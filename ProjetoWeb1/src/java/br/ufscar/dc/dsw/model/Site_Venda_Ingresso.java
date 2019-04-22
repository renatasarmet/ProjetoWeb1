/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.model;

/**
 *
 * @author Leonardo
 */
public class Site_Venda_Ingresso extends Usuario{
    
    private String url;
    private String nome;
    private String telefone;

    public Site_Venda_Ingresso(int id_usuario) {
        super(id_usuario);
    }

    public Site_Venda_Ingresso(int id_usuario,String email, String senha, String url, String nome, String telefone) {
        super(id_usuario,email,senha,1);
        this.url = url;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Site_Venda_Ingresso(String email, String senha, String url, String nome, String telefone) {
        super(email,senha,1);
        this.url = url;
        this.nome = nome;
        this.telefone = telefone;
    }

    public void setId_usuario(int id_usuario) {
        super.setId(id_usuario);
    }
    
    public int getId_usuario() {
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
