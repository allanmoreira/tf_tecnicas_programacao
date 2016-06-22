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
-- Name: aeroportos; Type: TABLE; Schema: public; Owner: marlon
--

CREATE TABLE aeroportos (
    id_aeroporto character varying(5) NOT NULL,
    latitude double precision NOT NULL,
    longitude double precision NOT NULL,
    nome character varying(255) NOT NULL
);


ALTER TABLE aeroportos OWNER TO marlon;

--
-- Name: aeroportos_pkey; Type: CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY aeroportos
    ADD CONSTRAINT aeroportos_pkey PRIMARY KEY (id_aeroporto);


--
-- Name: aeroportos_id_aeroporto_e538f367_like; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX aeroportos_id_aeroporto_e538f367_like ON aeroportos USING btree (id_aeroporto varchar_pattern_ops);


--
-- PostgreSQL database dump complete
--

