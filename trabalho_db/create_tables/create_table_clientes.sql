--
-- PostgreSQL Clientes

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clientes; Type: TABLE; Schema: public; Owner: marlon
--

CREATE TABLE clientes (
    id_cliente integer NOT NULL,
    nome character varying(200) NOT NULL,
    rg character varying(15) NOT NULL,
    cpf character varying(20) NOT NULL,
    numero_passaporte character varying(20) NOT NULL
);


ALTER TABLE clientes OWNER TO marlon;

--
-- Name: clientes_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: marlon
--

CREATE SEQUENCE clientes_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clientes_id_cliente_seq OWNER TO marlon;

--
-- Name: clientes_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: marlon
--

ALTER SEQUENCE clientes_id_cliente_seq OWNED BY clientes.id_cliente;


--
-- Name: id_cliente; Type: DEFAULT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY clientes ALTER COLUMN id_cliente SET DEFAULT nextval('clientes_id_cliente_seq'::regclass);


--
-- Name: clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id_cliente);


