/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Site_Venda_Ingresso;
import br.ufscar.dc.dsw.pojo.Teatro;
import br.ufscar.dc.dsw.pojo.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author João
 */
public class CriaTudo{
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    private static Teatro criaTeatro(){
        Teatro t = new Teatro();
        t.setCnpj("87857036000174");
        t.setNome("Teatro Municipal");
        t.setCidade("Maceio");
        t.setEmail("teatro@teatro");
        t.setSenha(encoder.encode("teatro"));
        return t;
    }
    
    private static Site_Venda_Ingresso criaSVI(){
        Site_Venda_Ingresso svi = new Site_Venda_Ingresso();
        svi.setUrl("https://ingresso.com");
        svi.setNome("Ingresso ponto com");
        svi.setEmail("site@site");
        svi.setSenha(encoder.encode("site"));
        return svi;
    }
    
    private static Usuario criaAdmin(){
        Usuario admin = new Usuario();
        admin.setEmail("admin@admin");
        admin.setSenha(encoder.encode("admin"));
        return admin;
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        PapelDAO papelDAO = new PapelDAO();
        TeatroDAO teatroDAO = new TeatroDAO();
        Site_Venda_IngressoDAO sviDAO = new Site_Venda_IngressoDAO();
        
        
        // Criar os papeis "TEATRO, SITE e ADMIN"
        Papel p1 = new Papel();
        p1.setNome("TEATRO");
        papelDAO.save(p1);
        
        Papel p2 = new Papel();
        p2.setNome("SITE");
        papelDAO.save(p2);
        
        Papel p3 = new Papel();
        p3.setNome("ADMIN");
        papelDAO.save(p3);
        
        // Criar usuários de teste pra Teatro, Site e Admin
        Site_Venda_Ingresso svi = criaSVI();
        Teatro t = criaTeatro();
        Usuario admin = criaAdmin();
        
        // Atribuir papéis
        t.setPapel(p1);
        svi.setPapel(p2);
        admin.setPapel(p3);        
    }
}
