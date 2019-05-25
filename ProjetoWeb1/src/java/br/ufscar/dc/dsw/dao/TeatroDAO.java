/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Teatro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author João
 */
public class TeatroDAO extends GenericDAO<Teatro> {


    @Override
    public Teatro get(Long id) {
        EntityManager em = this.getEntityManager();
        Teatro teatro = em.find(Teatro.class, id);
        em.close();
        return teatro;
    }

    @Override
    public List<Teatro> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select u from Teatro u", Teatro.class);
        List<Teatro> teatro = q.getResultList();
        em.close();
        return teatro;
    }
    public List<Teatro> getAllCidade(String cidade) {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select u from Teatro u where u.cidade = '"+cidade+"'", Teatro.class);
        List<Teatro> teatro = q.getResultList();
        em.close();
        return teatro;
    }

    @Override
    public void save(Teatro teatro) {
        PapelDAO papelDAO = new PapelDAO();
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teatro);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(teatro);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        teatro = em.getReference(Teatro.class, teatro.getId());
        tx.begin();
        em.remove(teatro);
        tx.commit();
    }
}

