BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "tb_telefone" (
	"id"	integer,
	"ddd"	varchar(255),
	"numero"	varchar(255),
	"aluno_id"	bigint,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "tb_professor" (
	"id"	integer,
	"email"	varchar(255),
	"matricula"	varchar(255),
	"nomeCompleto"	varchar(255),
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "tb_material_curso" (
	"id"	integer,
	"url"	varchar(255),
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "tb_endereco" (
	"id"	integer,
	"bairro"	varchar(255),
	"cep"	integer,
	"cidade"	varchar(255),
	"endereco"	varchar(255),
	"estado"	varchar(255),
	"logradouro"	varchar(255),
	"numero"	varchar(255),
	"aluno_id"	bigint,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "tb_curso" (
	"id"	integer,
	"nome"	varchar(255),
	"sigla"	varchar(255),
	"material_curso_id"	bigint,
	"professor_id"	bigint,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "tb_aluno_curso" (
	"curso_id"	bigint NOT NULL,
	"aluno_id"	bigint NOT NULL
);
CREATE TABLE IF NOT EXISTS "tb_aluno" (
	"id"	integer,
	"dataNascimento"	datetime,
	"email"	varchar(255),
	"matricula"	varchar(255),
	"nomeCompleto"	varchar(255),
	PRIMARY KEY("id")
);
INSERT INTO "tb_telefone" VALUES (1,'35','99987-2682',1);
INSERT INTO "tb_telefone" VALUES (2,'35','99966-2725',NULL);
INSERT INTO "tb_telefone" VALUES (3,'35','99987-2682',3);
INSERT INTO "tb_endereco" VALUES (1,'Centro',37200200,'Lavras','Bernadino Macieira','MG','Rua','144',1);
INSERT INTO "tb_endereco" VALUES (2,'Centro',37200200,'Lavras','Bernadino Macieira','MG','Rua','144',NULL);
INSERT INTO "tb_endereco" VALUES (3,'Centro',37200200,'Lavras','Bernadino Macieira','MG','Rua','144',3);
INSERT INTO "tb_aluno" VALUES (1,918093600000,'cesarp@ciandt.com','201910560','Cesar Augusto Pires');
INSERT INTO "tb_aluno" VALUES (2,930366000000,'alicelopes@vidaveg.com','201910500','Alice Lopes Rodrigues');
INSERT INTO "tb_aluno" VALUES (3,1648177200000,'megrodriguespires@estudante.com','201910560','Meg Rodrigues Pires');
COMMIT;
