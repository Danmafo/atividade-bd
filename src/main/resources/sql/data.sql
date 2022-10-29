create table aluno (
    matricula bigint not null,
    nome varchar(255),
    primary key (matricula)
);

create table publicacao (
    cod_publicacao bigint not null,
    ano integer not null,
    autor varchar(255),
    tipo varchar(255),
    titulo varchar(255),
    primary key (cod_publicacao)
);

create table emprestimo (
    cod_publicacao bigint not null,
    matricula_aluno bigint not null,
    data_devolucao date,
    data_emprestimo date,
    primary key (cod_publicacao, matricula_aluno),
    foreign key (cod_publicacao) references publicacao(cod_publicacao),
    foreign key (matricula_aluno) references aluno(matricula)
);

insert into aluno(matricula, nome) values(1, 'Abelardo Santos');
insert into aluno(matricula, nome) values(2, 'Santiago Bernabeu');
insert into aluno(matricula, nome) values(3, 'Tainara Cristina');
insert into aluno(matricula, nome) values(4, 'Túlio Cristóvão');

insert into publicacao(cod_publicacao, titulo, ano, autor, tipo) values(1, 'Contos para Família', 2020, 'Joaquim Freitas', 'Revista');
insert into publicacao(cod_publicacao, titulo, ano, autor, tipo) values(2, 'História de Belém', 2005, 'Sérgio Mesquita', 'Artigo');
insert into publicacao(cod_publicacao, titulo, ano, autor, tipo) values(3, 'Cálculo Diferencial', 1995, 'Leopoldo Silva', 'Livro');
insert into publicacao(cod_publicacao, titulo, ano, autor, tipo) values(4, 'Mude seu Mindset', 2021, 'Amanda Vitória', 'Livro');
insert into publicacao(cod_publicacao, titulo, ano, autor, tipo) values(5, 'Como Cozinhar Bem', 2022, 'Guilherme Farias', 'Livro');

insert into emprestimo(matricula_aluno, cod_publicacao, data_emprestimo, data_devolucao)
values(1, 1, '2022-10-28', '2022-11-25');
insert into emprestimo(matricula_aluno, cod_publicacao, data_emprestimo, data_devolucao)
values(1, 2, '2022-10-30', '2022-11-28');
insert into emprestimo(matricula_aluno, cod_publicacao, data_emprestimo, data_devolucao)
values(3, 4, '2022-10-5', '2022-10-21');
insert into emprestimo(matricula_aluno, cod_publicacao, data_emprestimo, data_devolucao)
values(4, 3, '2022-10-22', '2022-11-28');