/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.SiteVendaIngresso;
import br.ufscar.dc.dsw.pojo.Teatro;
import br.ufscar.dc.dsw.pojo.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author João
 */
public class CriaTudo{
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
//    private static Teatro criaTeatro(){
//        Teatro t = new Teatro();
//        t.setCnpj("87857036000174");
//        t.setNome("Teatro Municipal");
//        t.setCidade("Maceio");
//        t.setEmail("teatro@teatro");
//        t.setAtivo(true);
//        t.setSenha(encoder.encode("teatro"));
//        return t;
//    }
//    
//    private static SiteVendaIngresso criaSVI(){
//        SiteVendaIngresso svi = new SiteVendaIngresso();
//        svi.setUrl("https://ingresso.com");
//        svi.setNome("Ingresso ponto com");
//        svi.setEmail("site@site");
//        svi.setAtivo(true);
//        svi.setSenha(encoder.encode("site"));
//        return svi;
//    }
    
    private static Usuario criaAdmin(){
        Usuario admin = new Usuario();
        admin.setEmail("admin@admin");
        admin.setSenha(encoder.encode("admin"));
        admin.setAtivo(true);
        return admin;
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        PapelDAO papelDAO = new PapelDAO();
        TeatroDAO teatroDAO = new TeatroDAO();
        SiteVendaIngressoDAO sviDAO = new SiteVendaIngressoDAO();
        UsuarioDAO userDAO = new UsuarioDAO();
        
        // Criar os papeis "TEATRO, SITE e ADMIN"
        Papel p1 = new Papel();
        p1.setNome("ROLE_TEATRO");
        papelDAO.save(p1);
        
        Papel p2 = new Papel();
        p2.setNome("ROLE_SITE");
        papelDAO.save(p2);
        
        Papel p3 = new Papel();
        p3.setNome("ROLE_ADMIN");
        papelDAO.save(p3);
        
        // Criar usuários de teste pra Teatro, Site e Admin
//        SiteVendaIngresso svi = criaSVI();
//        Teatro t = criaTeatro();
        Usuario admin = criaAdmin();
        
//        teatroDAO.save(t);
//        sviDAO.save(svi);
        userDAO.save(admin);
        
        // Atribuir papéis
//        t.getPapel().add(p1);
//        svi.getPapel().add(p2);
        admin.getPapel().add(p3);
        
//        t.getPapel().add(p1);
//        teatroDAO.update(t);
//        svi.getPapel().add(p2);
//        sviDAO.update(svi);
        admin.getPapel().add(p3);
        userDAO.update(admin);
    }
}
