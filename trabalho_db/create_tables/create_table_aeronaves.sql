--
-- PostgreSQL Aeronaves
--

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
-- Name: aeronaves; Type: TABLE; Schema: public; Owner: marlon
--

CREATE TABLE aeronaves (
    id_aeronave character varying(3) NOT NULL,
    fabricante character varying(100) NOT NULL,
    modelo character varying(50),
    numero_de_assentos integer NOT NULL
);


ALTER TABLE aeronaves OWNER TO marlon;

--
-- Name: aeronaves_pkey; Type: CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY aeronaves
    ADD CONSTRAINT aeronaves_pkey PRIMARY KEY (id_aeronave);


--
-- Name: aeronaves_id_aeronave_6a942ed2_like; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX aeronaves_id_aeronave_6a942ed2_like ON aeronaves USING btree (id_aeronave varchar_pattern_ops);

