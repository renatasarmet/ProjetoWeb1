/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Promocao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Renata
 */
public class PromocaoDAO extends GenericDAO<Promocao> {

    @Override
    public Promocao get(Long id) {
        EntityManager em = this.getEntityManager();
        Promocao promocao = em.find(Promocao.class, id);
        em.close();
        return promocao;
    }

    @Override
    public List<Promocao> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select p from Promocao p", Promocao.class);
        List<Promocao> promocao = q.getResultList();
        em.close();
        return promocao;
    }

    public List<Promocao> getAllURL(String email) {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select p from Promocao p where p.site_venda_ingresso.email = '"+email+"'", Promocao.class);
        List<Promocao> promocao = q.getResultList();
        em.close();
        return promocao;
    }
    public List<Promocao> getAllTeatro(String nome) {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select p from Promocao p where p.teatro.nome = '"+nome+"'", Promocao.class);
        List<Promocao> promocao = q.getResultList();
        em.close();
        return promocao;
    }

    @Override
    public void save(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(promocao);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(promocao);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        promocao = em.getReference(Promocao.class, promocao.getId());
        tx.begin();
        em.remove(promocao);
        tx.commit();
    }

}
