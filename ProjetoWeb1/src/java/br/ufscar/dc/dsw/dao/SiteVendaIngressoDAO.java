/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.SiteVendaIngresso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
/**
 *
 * @author Leonardo
 */
public class SiteVendaIngressoDAO extends GenericDAO<SiteVendaIngresso> {
    

    @Override
    public SiteVendaIngresso get(Long id) {
        EntityManager em = this.getEntityManager();
        SiteVendaIngresso siteVendaIngresso = em.find(SiteVendaIngresso.class, id);
        em.close();
        return siteVendaIngresso;
    }

    @Override
    public List<SiteVendaIngresso> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select s from SiteVendaIngresso s", SiteVendaIngresso.class);
        List<SiteVendaIngresso> siteVendaIngresso = q.getResultList();
        em.close();
        return siteVendaIngresso;
    }

    @Override
    public void save(SiteVendaIngresso siteVendaIngresso) {
        PapelDAO papelDAO = new PapelDAO();
        siteVendaIngresso.setPapel(papelDAO.get("SITE"));
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(siteVendaIngresso);
        tx.commit();
        em.close();
    }

    @Override
    public void update(SiteVendaIngresso siteVendaIngresso) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(siteVendaIngresso);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(SiteVendaIngresso siteVendaIngresso) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        siteVendaIngresso = em.getReference(SiteVendaIngresso.class, siteVendaIngresso.getId());
        tx.begin();
        em.remove(siteVendaIngresso);
        tx.commit();
    }
}
