-- Table: public.convite

-- DROP TABLE public.convite;

CREATE TABLE public.convite
(
  con_id integer NOT NULL DEFAULT nextval('convite_con_id_seq'::regclass),
  con_convidado_id integer NOT NULL,
  con_pelada_id integer NOT NULL,
  CONSTRAINT convite_pkey PRIMARY KEY (con_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.convite
  OWNER TO postgres;
