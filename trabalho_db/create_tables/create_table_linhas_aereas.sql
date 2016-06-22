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
-- Name: linhas_aereas; Type: TABLE; Schema: public; Owner: marlon
--

CREATE TABLE linhas_aereas (
    id_linha_aerea character varying(10) NOT NULL,
    nome character varying(100) NOT NULL,
    id_alianca_id integer
);


ALTER TABLE linhas_aereas OWNER TO marlon;

--
-- Name: linhas_aereas_pkey; Type: CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY linhas_aereas
    ADD CONSTRAINT linhas_aereas_pkey PRIMARY KEY (id_linha_aerea);


--
-- Name: linhas_aereas_1f6c0c30; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX linhas_aereas_1f6c0c30 ON linhas_aereas USING btree (id_alianca_id);


--
-- Name: linhas_aereas_id_linha_aerea_a5f333ae_like; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX linhas_aereas_id_linha_aerea_a5f333ae_like ON linhas_aereas USING btree (id_linha_aerea varchar_pattern_ops);


--
-- Name: linhas_aereas_id_alianca_id_76c49fe3_fk_aliancas_id_alianca; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY linhas_aereas
    ADD CONSTRAINT linhas_aereas_id_alianca_id_76c49fe3_fk_aliancas_id_alianca FOREIGN KEY (id_alianca_id) REFERENCES aliancas(id_alianca) DEFERRABLE INITIALLY DEFERRED;


--
-- PostgreSQL database dump complete
--

