package br.com.atividade.jpa.teste;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.atividade.jpa.dao.AlunoDAO;
import br.com.atividade.jpa.dao.EmprestimoDAO;
import br.com.atividade.jpa.dao.PublicacaoDAO;
import br.com.atividade.jpa.entity.Emprestimo;
import br.com.atividade.jpa.util.CalculaDataDevolucao;
import br.com.atividade.jpa.util.JPAUtil;

public class TesteEmprestimo {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
        AlunoDAO alunoDAO = new AlunoDAO(em);
        PublicacaoDAO publicacaoDAO = new PublicacaoDAO(em);

        Emprestimo emp;

        System.out.println("\n==== BUSCANDO POR ID ====\n");
        System.out.println("Matricula do Aluno: 1, Código da Publicação: 1");
        emp = emprestimoDAO.findById(1l, 1l);
        System.out.println("Nome = " + emp.getMatriculaAluno().getNome());

        System.out.println("Matricula do Aluno: 1, Código da Publicação: 2");
        emp = emprestimoDAO.findById(1l, 2l);
        System.out.println("Nome = " + emp.getMatriculaAluno().getNome());

        System.out.println("Matricula do Aluno: 3, Código da Publicação: 4");
        emp = emprestimoDAO.findById(3l, 4l);
        System.out.println("Nome = " + emp.getMatriculaAluno().getNome());

        System.out.println("Matricula do Aluno: 4, Código da Publicação: 3");
        emp = emprestimoDAO.findById(4l, 3l);
        System.out.println("Nome = " + emp.getMatriculaAluno().getNome());

        System.out.println("\n==== FIND ALL ANTES DAS ALTERAÇÕES ====\n");
        List<Emprestimo> emprestimos = emprestimoDAO.findAll();
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo + "\n");
        }

        System.out.println("\n==== INSERINDO, ALTERANDO E REMOVENDO ====\n");

        Emprestimo emp2 = new Emprestimo(alunoDAO.findById(2l), publicacaoDAO.findById(5l), new Date(), CalculaDataDevolucao.calcular(new Date()));
        Emprestimo emp3 = new Emprestimo(alunoDAO.findById(1l), publicacaoDAO.findById(1l), new Date(), CalculaDataDevolucao.calcular(new Date()));

        em.getTransaction().begin();
		
		emprestimoDAO.insert(emp2);
        emprestimoDAO.update(emp3);
        emprestimoDAO.delete(emp);
		
		em.getTransaction().commit();

        System.out.println("\n==== FIND ALL DEPOIS DAS ALTERAÇÕES ====\n");
        List<Emprestimo> emprestimos2 = emprestimoDAO.findAll();
        for (Emprestimo emprestimo : emprestimos2) {
            System.out.println(emprestimo + "\n");
        }

		em.close();
    }

}
