create table curso(
	id integer primary key,
	nome varchar(50) not null,
	descricao varchar(150) not null,
	turno varchar(150) not null
);

create table disciplina(
	id integer primary key,
	nome varchar(50) not null,
	hora integer not null
);

create table professor(
	id integer primary key,
	nome varchar(50) not null,
	endereco varchar(150),
	telefone varchar(11),
	email varchar(50),
	salario numeric not null
);

create table aluno(
	id integer primary key,
	nome varchar(50) not null,
	endereco varchar(150),
	telefone varchar(11),
	email varchar(50)
);

create table turma(
	id integer primary key,
	ref_disc integer references disciplina(id),
	ref_curso integer references curso(id),
	ref_prof integer references professor(id),
	horario integer not null,
	turno varchar(50) not null,
	periodo varchar(50) not null
);

create table turmaProfessor(
	id serial primary key,
	ref_prof integer references professor(id),
	ref_curso integer references curso(id)
);

create table notas(
	id serial primary key,
	ref_aluno integer references aluno(id),
	ref_disc integer references disciplina(id),
	nota1 numeric default 0,
	nota2 numeric default 0,
	nota3 numeric default 0
);

create table HorariosOcupados(
	id serial primary key,
	ref_aluno integer references aluno(id),
	ref_disc integer references disciplina(id),
	horario integer not null
);

create table matricula(
	id serial primary key,
	ref_aluno integer references aluno(id),
	ref_turma integer references turma(id)
);

CREATE TABLE Usuario(
	login varchar(50) primary key,
	senha varchar(50)
)
