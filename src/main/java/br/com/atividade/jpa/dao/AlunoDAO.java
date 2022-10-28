package br.com.atividade.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.atividade.jpa.entity.Aluno;

public class AlunoDAO implements DAO<Aluno>{

    private EntityManager em;

    public AlunoDAO(EntityManager em) {
        this.em = em;
    }

    public Aluno findById(long id) {
        return this.em.find(Aluno.class, id);
    }

    @Override
    public List<Aluno> findAll() {
        String jpql = "SELECT a FROM Aluno a";
        return em.createQuery(jpql, Aluno.class).getResultList();
    }

    @Override
    public void insert(Aluno t) {
        this.em.persist(t);
    }

    @Override
    public void update(Aluno t) {
        this.em.merge(t);
    }

    @Override
    public void delete(Aluno t) {
        this.em.remove(t);    
    }

    
}
