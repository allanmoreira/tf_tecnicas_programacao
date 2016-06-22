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
-- Name: chegadas; Type: TABLE; Schema: public; Owner: marlon
--

CREATE TABLE chegadas (
    id_chegada integer NOT NULL,
    data_chegada date NOT NULL,
    hora_chegada time without time zone NOT NULL,
    id_aeroporto_id character varying(5) NOT NULL
);


ALTER TABLE chegadas OWNER TO marlon;

--
-- Name: chegadas_id_chegada_seq; Type: SEQUENCE; Schema: public; Owner: marlon
--

CREATE SEQUENCE chegadas_id_chegada_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE chegadas_id_chegada_seq OWNER TO marlon;

--
-- Name: chegadas_id_chegada_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: marlon
--

ALTER SEQUENCE chegadas_id_chegada_seq OWNED BY chegadas.id_chegada;


--
-- Name: id_chegada; Type: DEFAULT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY chegadas ALTER COLUMN id_chegada SET DEFAULT nextval('chegadas_id_chegada_seq'::regclass);


--
-- Name: chegadas_pkey; Type: CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY chegadas
    ADD CONSTRAINT chegadas_pkey PRIMARY KEY (id_chegada);


--
-- Name: chegadas_ded997b7; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX chegadas_ded997b7 ON chegadas USING btree (id_aeroporto_id);


--
-- Name: chegadas_id_aeroporto_id_f0e02d72_like; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX chegadas_id_aeroporto_id_f0e02d72_like ON chegadas USING btree (id_aeroporto_id varchar_pattern_ops);


--
-- Name: chegadas_id_aeroporto_id_f0e02d72_fk_aeroportos_id_aeroporto; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY chegadas
    ADD CONSTRAINT chegadas_id_aeroporto_id_f0e02d72_fk_aeroportos_id_aeroporto FOREIGN KEY (id_aeroporto_id) REFERENCES aeroportos(id_aeroporto) DEFERRABLE INITIALLY DEFERRED;


--
-- PostgreSQL database dump complete
--

