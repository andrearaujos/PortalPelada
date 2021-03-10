-- Table: public.pelada

-- DROP TABLE public.pelada;

CREATE TABLE public.pelada
(
  pel_id integer NOT NULL DEFAULT nextval('pelada_pel_id_seq'::regclass),
  pel_data date NOT NULL,
  pel_hora time without time zone NOT NULL,
  pel_local character varying(100) NOT NULL,
  pel_usu_id integer,
  pel_nome_evento character varying(200)[],
  CONSTRAINT pelada_pkey PRIMARY KEY (pel_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.pelada
  OWNER TO postgres;
