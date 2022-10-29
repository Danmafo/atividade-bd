# atividades-sd
Atividades p/ 1° Avaliação do Aplicação de Banco de Dados

<br>

# Autor:
<table>
    <tr>
        <td>Matrícula<td>
        <td>Discente<td>
    </tr>
    <tr>
        <td>20200795040<td>
        <td>Daniel Marques Fonseca<td>
    </tr> 
</table>

<br>

## Observações Gerais:
### Teste
<p>Para testar o programa é necessário rodar os scripts na pasta /<strong>resources/sql/data.sql</strong> no console do H2. Como os testes acabam alterando algumas linhas, para fazê-lo de novo, será necessário dropar as tabelas e rodar o mesmo script anterior, ou fazer mudanças no código.</p>

<br>

### Mapeamento das tabelas
<p>Por questão de escolha, decidi fazer o relacionamento entre os empréstimos e alunos ser unidirecional, sendo que apenas os empréstimos vêem os alunos.</p>

<p>Além disso, como a escolha dos ids era livre, o empréstimo possui um id composto de <strong>matrícula do aluno</strong> e <strong>código da publicação</strong></p>

<br>

## Ao Código:

<p>Neste pacote se encontram as classes DAO que possuem todas as operações de CRUD</p>

```java
package br.com.atividade.jpa.dao;
```

<p>A única particularidade entre elas é o método findById do EmprestimoDAO, que por se tratar de um Id composto precisou de uma atenção a mais.</p>

```java
public Emprestimo findById(long matricula, long codPublicacao) {
        String jpql = "SELECT e FROM Emprestimo e WHERE e.matriculaAluno.matriculaAluno = :matricula AND e.codigoPub.codigoPub = :codPublicacao";
        return this.em.createQuery(jpql, Emprestimo.class)
        .setParameter("matricula", matricula).setParameter("codPublicacao", codPublicacao).getSingleResult();

    }
```

<br>

<p>Aqui se encontram todas as classes POJO do projeto, com excessão da classe EmprestimoId, que serve para mapear o id composto do tabela de emprestimo</p>

```java
package br.com.atividade.jpa.entity;
```

<p>A classe Emprestimo é anotada com <strong>@IdClass</strong> que recebe a classe id para podermos declarar aqui um id composto.</p>

<p>Os ids fazem referencia aos ids das suas respectivas classes e o relacionamento é de <strong>Muitos Para Um</strong></p>

```java
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

    // construtores, getters, setters e toString

}
```

<p>Outros POJOs possuem mapeamento simples com Id sendo gerenciado pela aplicação.</p>

<br>

<p>Pacote que contém a interface que todos objeto DAO implementam.</p>

```java
package br.com.atividade.jpa.interfaces;
```

<p>Foi necessário remover o findById para implementar no EmprestimoDAO, hava vista que o seu findById recebe mais de um parâmetro.</p>

```java
public interface DAO<T> {

	List<T> findAll();
	void insert(T t);
	void update(T t);
	void delete(T t);
	
}
```

<br>

<p>Pacote que possui testes fazendo as operações de CRUD na tabela de empréstimo e mostrando o resultado de antes e depois da operações.</p>

```java
package br.com.atividade.jpa.teste;
```

<br>

<p>Pacote com classes úteis que construí para ajudar em ações pontuais na aplicação.</p>

```java
package br.com.atividade.jpa.util;
```

<p>Para datas que não foram inseridas manualmente, é calculado a data de devolução para 15 dias depois da data de emissão.</p>

```java
public class CalculaDataDevolucao {

    public static Date calcular(Date dataEmprestimo) {
        Calendar c = Calendar.getInstance();
        c.setTime(dataEmprestimo);
        c.add(Calendar.DATE, 15);
        Date dataEmprestimoMaisQuinzeDias = c.getTime();
        return dataEmprestimoMaisQuinzeDias;
    }
    
}
```

<p>Como durante a execução da aplicação acabamos criando um EntityManager mais de uma vez, joguei ele em um método estático que me devolve esse EntityManager onde eu precisar dele.</p>

```java
public class JPAUtil {
    
    public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("atividade-jpa-bd");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
```

<br>

## Resources

<p>Dentro da pasta META-INF se encontra o arquivo de configuração <strong>persistence.xml</strong>. Para essa aplicação utilizo banco H2 na url de testes, e também o Hibernate como especifição da JPA.</p>

<p>Na pasta sql é guardado o script de criação das tabelas e de inserções de dados nas mesmas.</p>