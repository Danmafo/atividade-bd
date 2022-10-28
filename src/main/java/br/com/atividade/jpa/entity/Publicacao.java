package br.com.atividade.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publicacao")
public class Publicacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_publicacao")
    private long codigoPub;

    private String titulo;

    private int ano;

    private String autor;

    private String tipo;

    public Publicacao() {
    }

    public Publicacao(String titulo, int ano, String autor, String tipo) {
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.tipo = tipo;
    }

    public long getCodigoPub() {
        return codigoPub;
    }

    public void setCodigoPub(int codigoPub) {
        this.codigoPub = codigoPub;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
