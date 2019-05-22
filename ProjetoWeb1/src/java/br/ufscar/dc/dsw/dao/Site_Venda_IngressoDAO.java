/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Site_Venda_Ingresso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
/**
 *
 * @author Leonardo
 */
public class Site_Venda_IngressoDAO extends GenericDAO<Site_Venda_Ingresso> {
    

    @Override
    public Site_Venda_Ingresso get(Long id) {
        EntityManager em = this.getEntityManager();
        Site_Venda_Ingresso site_venda_ingresso = em.find(Site_Venda_Ingresso.class, id);
        em.close();
        return site_venda_ingresso;
    }

    @Override
    public List<Site_Venda_Ingresso> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select s from Site_Venda_Ingresso s", Site_Venda_Ingresso.class);
        List<Site_Venda_Ingresso> site_venda_ingresso = q.getResultList();
        em.close();
        return site_venda_ingresso;
    }

    @Override
    public void save(Site_Venda_Ingresso site_venda_ingresso) {
        PapelDAO papelDAO = new PapelDAO();
        site_venda_ingresso.setPapel(papelDAO.get("SITE"));
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(site_venda_ingresso);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Site_Venda_Ingresso site_venda_ingresso) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(site_venda_ingresso);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Site_Venda_Ingresso site_venda_ingresso) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        site_venda_ingresso = em.getReference(Site_Venda_Ingresso.class, site_venda_ingresso.getId());
        tx.begin();
        em.remove(site_venda_ingresso);
        tx.commit();
    }
}
