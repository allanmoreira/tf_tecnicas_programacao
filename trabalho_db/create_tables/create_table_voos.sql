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
-- Name: voos; Type: TABLE; Schema: public; Owner: marlon
--

CREATE TABLE voos (
    id_voo integer NOT NULL,
    tempo_estimado integer NOT NULL,
    id_aeronaves_id character varying(3) NOT NULL,
    id_chegada_id integer NOT NULL,
    id_linha_aerea_id character varying(10) NOT NULL,
    id_partida_id integer NOT NULL
);


ALTER TABLE voos OWNER TO marlon;

--
-- Name: voos_id_voo_seq; Type: SEQUENCE; Schema: public; Owner: marlon
--

CREATE SEQUENCE voos_id_voo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE voos_id_voo_seq OWNER TO marlon;

--
-- Name: voos_id_voo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: marlon
--

ALTER SEQUENCE voos_id_voo_seq OWNED BY voos.id_voo;


--
-- Name: id_voo; Type: DEFAULT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY voos ALTER COLUMN id_voo SET DEFAULT nextval('voos_id_voo_seq'::regclass);


--
-- Name: voos_pkey; Type: CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY voos
    ADD CONSTRAINT voos_pkey PRIMARY KEY (id_voo);


--
-- Name: voos_bc5dcf4c; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX voos_bc5dcf4c ON voos USING btree (id_chegada_id);


--
-- Name: voos_dc3437d7; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX voos_dc3437d7 ON voos USING btree (id_linha_aerea_id);


--
-- Name: voos_fb740687; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX voos_fb740687 ON voos USING btree (id_aeronaves_id);


--
-- Name: voos_fc9703e2; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX voos_fc9703e2 ON voos USING btree (id_partida_id);


--
-- Name: voos_id_aeronaves_id_812b5cec_like; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX voos_id_aeronaves_id_812b5cec_like ON voos USING btree (id_aeronaves_id varchar_pattern_ops);


--
-- Name: voos_id_linha_aerea_id_30439968_like; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX voos_id_linha_aerea_id_30439968_like ON voos USING btree (id_linha_aerea_id varchar_pattern_ops);


--
-- Name: voos_id_aeronaves_id_812b5cec_fk_aeronaves_id_aeronave; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY voos
    ADD CONSTRAINT voos_id_aeronaves_id_812b5cec_fk_aeronaves_id_aeronave FOREIGN KEY (id_aeronaves_id) REFERENCES aeronaves(id_aeronave) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: voos_id_chegada_id_8f2d900a_fk_chegadas_id_chegada; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY voos
    ADD CONSTRAINT voos_id_chegada_id_8f2d900a_fk_chegadas_id_chegada FOREIGN KEY (id_chegada_id) REFERENCES chegadas(id_chegada) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: voos_id_linha_aerea_id_30439968_fk_linhas_aereas_id_linha_aerea; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY voos
    ADD CONSTRAINT voos_id_linha_aerea_id_30439968_fk_linhas_aereas_id_linha_aerea FOREIGN KEY (id_linha_aerea_id) REFERENCES linhas_aereas(id_linha_aerea) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: voos_id_partida_id_fb236736_fk_partidas_id_partida; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY voos
    ADD CONSTRAINT voos_id_partida_id_fb236736_fk_partidas_id_partida FOREIGN KEY (id_partida_id) REFERENCES partidas(id_partida) DEFERRABLE INITIALLY DEFERRED;


--
-- PostgreSQL database dump complete
--

