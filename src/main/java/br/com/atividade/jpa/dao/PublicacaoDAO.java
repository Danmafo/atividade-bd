package br.com.atividade.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.atividade.jpa.entity.Publicacao;
import br.com.atividade.jpa.interfaces.DAO;

public class PublicacaoDAO implements DAO<Publicacao> {

    private EntityManager em;

    public PublicacaoDAO(EntityManager em) {
        this.em = em;
    }

    public Publicacao findById(long id) {
        return this.em.find(Publicacao.class, id);
    }

    @Override
    public List<Publicacao> findAll() {
        String jpql = "SELECT p FROM Publicacao p";
        return em.createQuery(jpql, Publicacao.class).getResultList();
    }

    @Override
    public void insert(Publicacao t) {
        this.em.persist(t);
    }

    @Override
    public void update(Publicacao t) {
        this.em.merge(t);
    }

    @Override
    public void delete(Publicacao t) {
        this.em.remove(t);    
    }
    
}
