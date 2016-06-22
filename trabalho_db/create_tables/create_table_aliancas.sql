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
-- Name: aliancas; Type: TABLE; Schema: public; Owner: marlon
--

CREATE TABLE aliancas (
    id_alianca integer NOT NULL,
    nome character varying(100) NOT NULL
);


ALTER TABLE aliancas OWNER TO marlon;

--
-- Name: aliancas_id_alianca_seq; Type: SEQUENCE; Schema: public; Owner: marlon
--

CREATE SEQUENCE aliancas_id_alianca_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aliancas_id_alianca_seq OWNER TO marlon;

--
-- Name: aliancas_id_alianca_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: marlon
--

ALTER SEQUENCE aliancas_id_alianca_seq OWNED BY aliancas.id_alianca;


--
-- Name: id_alianca; Type: DEFAULT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY aliancas ALTER COLUMN id_alianca SET DEFAULT nextval('aliancas_id_alianca_seq'::regclass);


--
-- Name: aliancas_pkey; Type: CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY aliancas
    ADD CONSTRAINT aliancas_pkey PRIMARY KEY (id_alianca);


--
-- PostgreSQL database dump complete
--

