-- Table: public.usuario

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario
(
  usu_id integer NOT NULL DEFAULT nextval('usuario_usu_id_seq'::regclass),
  usu_nome_completo character varying(150) NOT NULL,
  usu_apelido character varying(50) NOT NULL,
  usu_email character varying(100) NOT NULL,
  usu_senha character varying(50) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (usu_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuario
  OWNER TO postgres;
