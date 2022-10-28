package br.com.atividade.jpa.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="matricula_aluno")
    private Aluno matriculaAluno;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cod_publicacao")
    private Publicacao codigoPub;

    @Column(name = "data_emprestimo")
    private Date dataEmprestimo;

    @Column(name = "data_devolucao")
    private Date dataDevolucao;
    
    public Emprestimo() {}

    public Emprestimo(Aluno matriculaAluno, Publicacao codigoPub, Date dataEmprestimo, Date dataDevolucao) {
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

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Emprestimo\nmatriculaAluno = " + matriculaAluno.getMatriculaAluno() + ",\ncodigoPub = " + codigoPub.getCodigoPub() + ",\ndataEmprestimo = "
                + sdf.format(dataEmprestimo) + ",\ndataDevolucao = " + sdf.format(dataDevolucao);
    }
    
}
