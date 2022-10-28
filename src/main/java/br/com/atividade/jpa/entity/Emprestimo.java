package br.com.atividade.jpa.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprestimo")
@IdClass(EmprestimoId.class)
public class Emprestimo {
    
    @Id
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="matriculaAluno")
    private Aluno matriculaAluno;

    @Id
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="codigoPub")
    private Publicacao codigoPub;

    private Date dataEmprestimo;

    private Date dataDevolucao;
    
    public Emprestimo() {}

    public Emprestimo(Aluno matriculaAluno, Publicacao codigoPub, Date dataDevolucao, Date dataEmprestimo) {
        this.matriculaAluno = matriculaAluno;
        this.codigoPub = codigoPub;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Aluno getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(Aluno matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public Publicacao getCodigoPub() {
        return codigoPub;
    }

    public void setCodigoPub(Publicacao codigoPub) {
        this.codigoPub = codigoPub;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    
}
