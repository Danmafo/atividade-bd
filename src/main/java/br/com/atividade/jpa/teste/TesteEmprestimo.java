package br.com.atividade.jpa.teste;

import java.util.Date;

import javax.persistence.EntityManager;

import br.com.atividade.jpa.dao.AlunoDAO;
import br.com.atividade.jpa.dao.EmprestimoDAO;
import br.com.atividade.jpa.dao.PublicacaoDAO;
import br.com.atividade.jpa.entity.Aluno;
import br.com.atividade.jpa.entity.Emprestimo;
import br.com.atividade.jpa.entity.Publicacao;
import br.com.atividade.jpa.util.CalculaDataDevolucao;
import br.com.atividade.jpa.util.JPAUtil;

public class TesteEmprestimo {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
        AlunoDAO alunoDAO = new AlunoDAO(em);
        PublicacaoDAO publicacaoDAO = new PublicacaoDAO(em);

        cadastros();

        //TODO - Realizar mais testes

        Emprestimo emp = emprestimoDAO.findById(1l, 1l);
        System.out.println("Nome = " + emp.getMatriculaAluno().getNome());

        Aluno al = alunoDAO.findById(1);
        System.out.println("Aluno com Id 1 = " + al.getNome());
    }

    private static void cadastros() {
        Aluno aluno1 = new Aluno("Abelardo Santos");
        Aluno aluno2 = new Aluno("Santiago Bernabeu");
        Aluno aluno3 = new Aluno("Tainara Cristina");
        Aluno aluno4 = new Aluno("Túlio Cristóvão");

        Publicacao publicacao1 = new Publicacao("Contos para Família", 2020, "Joaquim Freitas", "Revista");
        Publicacao publicacao2 = new Publicacao("História de Belém", 2005, "Sérgio Mesquita", "Artigo");
        Publicacao publicacao3 = new Publicacao("Cálculo Diferencial", 1995, "Leopoldo Silva", "Livro");
        Publicacao publicacao4 = new Publicacao("Mude seu Mindset", 2021, "Amanda Vitória", "Livro");

        EntityManager em = JPAUtil.getEntityManager();

        AlunoDAO alunoDAO = new AlunoDAO(em);
        PublicacaoDAO publicacaoDAO = new PublicacaoDAO(em);
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);

        Emprestimo emprestimo1 = new Emprestimo(aluno1,
                publicacao1,
                new Date(),
                CalculaDataDevolucao.calculaDataDevolucao(new Date()));

        Emprestimo emprestimo2 = new Emprestimo(aluno2,
                publicacao2,
                new Date(),
                CalculaDataDevolucao.calculaDataDevolucao(new Date()));

        em.getTransaction().begin();

        alunoDAO.insert(aluno1);
        alunoDAO.insert(aluno2);
        alunoDAO.insert(aluno3);
        alunoDAO.insert(aluno4);

        publicacaoDAO.insert(publicacao1);
        publicacaoDAO.insert(publicacao2);
        publicacaoDAO.insert(publicacao3);
        publicacaoDAO.insert(publicacao4);

        emprestimoDAO.insert(emprestimo1);
        emprestimoDAO.insert(emprestimo2);

        em.getTransaction().commit();
        em.close();
    }

}
