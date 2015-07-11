create table departamento(
	id serial  not null,
	nome varchar(255) not null,
	sigla varchar(255) not null,
	primary key(id)
);

create table curso(
	id serial not null,
	nome varchar(255) not null,
	sigla varchar(255) not null,
	departamento_id integer not null,
	primary key(id),
	foreign key(departamento_id) references departamento(id)
);

create table refeicao(
	id serial not null,
	turno varchar(255) not null,
	descricao varchar(255) not null,
	opcao_vegan varchar(255) not null,
	primary key(id)
);

create table consumidor(
	id serial not null,
	nome varchar(255) not null,
	matricula integer not null,
	ano_ingresso integer not null,
	sexo varchar(255) not null,
	titulo varchar(255) not null,
	cpf varchar(11) not null,
	curso_id integer,
	departamento_id integer,
	primary key (id),
	foreign key(curso_id) references curso(id),
	foreign key(departamento_id) references departamento(id)
);

create table ticket(
	id serial not null,
	pago boolean not null,
	consumidor_id integer not null,
	refeicao_id integer not null,
	primary key(id),
	foreign key(consumidor_id) references consumidor(id),
	foreign key(refeicao_id) references refeicao(id)
);