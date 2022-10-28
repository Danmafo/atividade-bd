package br.com.atividade.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.atividade.jpa.entity.Emprestimo;
import br.com.atividade.jpa.interfaces.DAO;

public class EmprestimoDAO implements DAO<Emprestimo> {

    private EntityManager em;

    public EmprestimoDAO(EntityManager em) {
        this.em = em;
    }

    public Emprestimo findById(long matricula, long codPublicacao) {
        String jpql = "SELECT e FROM Emprestimo e WHERE e.matriculaAluno.matriculaAluno = :matricula AND e.codigoPub.codigoPub = :codPublicacao";
        return this.em.createQuery(jpql, Emprestimo.class)
        .setParameter("matricula", matricula).setParameter("codPublicacao", codPublicacao).getSingleResult();

    }

    @Override
    public List<Emprestimo> findAll() {
        String jpql = "SELECT e FROM Emprestimo e";
        return em.createQuery(jpql, Emprestimo.class).getResultList();
    }

    @Override
    public void insert(Emprestimo t) {
        this.em.persist(t);
    }

    @Override
    public void update(Emprestimo t) {
        this.em.merge(t);
    }

    @Override
    public void delete(Emprestimo t) {
        this.em.remove(t);    
    }

}
