package br.com.atividade.jpa.entity;

import java.io.Serializable;

public class EmprestimoId implements Serializable {
    
    public long matriculaAluno;

    public long codigoPub;

    public EmprestimoId() {}

    public EmprestimoId(long matriculaAluno, long codigoPub) {
        this.matriculaAluno = matriculaAluno;
        this.codigoPub = codigoPub;
    }

    public long getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public long getCodigoPub() {
        return codigoPub;
    }

    public void setCodigoPub(int codigoPub) {
        this.codigoPub = codigoPub;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmprestimoId other = (EmprestimoId) obj;
        if (matriculaAluno != other.matriculaAluno)
            return false;
        if (codigoPub != other.codigoPub)
            return false;
        return true;
    }
    
}
