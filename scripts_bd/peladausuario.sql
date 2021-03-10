-- Table: public.peladausuario

-- DROP TABLE public.peladausuario;

CREATE TABLE public.peladausuario
(
  pelusu_id integer NOT NULL DEFAULT nextval('peladausuario_pelusu_id_seq'::regclass),
  pelusu_usu_id integer NOT NULL,
  pelusu_pel_id integer NOT NULL,
  CONSTRAINT peladausuario_pkey PRIMARY KEY (pelusu_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.peladausuario
  OWNER TO postgres;
