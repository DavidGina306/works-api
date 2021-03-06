create table comentarios (
	id bigint not null auto_increment,
	ordem_servico_id bigint not null,
	descricao text not null, 
	data_criacao datetime not null,
	primary key(id)
);

alter table comentarios add constraint fk_comentario_ordem_servico 
foreign key (ordem_servico_id) references ordem_servicos(id);