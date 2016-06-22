--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

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
-- Name: promocoes; Type: TABLE; Schema: public; Owner: marlon
--

CREATE TABLE promocoes (
    id_promocao integer NOT NULL,
    descricao character varying(100) NOT NULL,
    tipo character varying(20) NOT NULL,
    data_validade date NOT NULL
);


ALTER TABLE promocoes OWNER TO marlon;

--
-- Name: promocoes_id_promocao_seq; Type: SEQUENCE; Schema: public; Owner: marlon
--

CREATE SEQUENCE promocoes_id_promocao_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE promocoes_id_promocao_seq OWNER TO marlon;

--
-- Name: promocoes_id_promocao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: marlon
--

ALTER SEQUENCE promocoes_id_promocao_seq OWNED BY promocoes.id_promocao;


--
-- Name: id_promocao; Type: DEFAULT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY promocoes ALTER COLUMN id_promocao SET DEFAULT nextval('promocoes_id_promocao_seq'::regclass);


--
-- Name: promocoes_pkey; Type: CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY promocoes
    ADD CONSTRAINT promocoes_pkey PRIMARY KEY (id_promocao);


--
-- PostgreSQL database dump complete
--

