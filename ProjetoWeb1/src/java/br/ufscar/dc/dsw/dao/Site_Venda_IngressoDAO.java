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
        Site_Venda_Ingresso site_Venda_Ingresso = em.find(Site_Venda_Ingresso.class, id);
        em.close();
        return site_Venda_Ingresso;
    }

    @Override
    public List<Site_Venda_Ingresso> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select s from Site_Venda_Ingresso s", Site_Venda_Ingresso.class);
        List<Site_Venda_Ingresso> site_Venda_Ingresso = q.getResultList();
        em.close();
        return site_Venda_Ingresso;
    }

    @Override
    public void save(Site_Venda_Ingresso site_Venda_Ingresso) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(site_Venda_Ingresso);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Site_Venda_Ingresso site_Venda_Ingresso) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(site_Venda_Ingresso);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Site_Venda_Ingresso site_Venda_Ingresso) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        site_Venda_Ingresso = em.getReference(Site_Venda_Ingresso.class, site_Venda_Ingresso.getId());
        tx.begin();
        em.remove(site_Venda_Ingresso);
        tx.commit();
    }
}
