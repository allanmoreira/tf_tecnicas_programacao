--
-- PostgreSQL Partidas

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
-- Name: partidas; Type: TABLE; Schema: public; Owner: marlon
--

CREATE TABLE partidas (
    id_partida integer NOT NULL,
    data_partida date NOT NULL,
    hora_partida time without time zone NOT NULL,
    id_aeroporto_id character varying(5) NOT NULL
);


ALTER TABLE partidas OWNER TO marlon;

--
-- Name: partidas_id_partida_seq; Type: SEQUENCE; Schema: public; Owner: marlon
--

CREATE SEQUENCE partidas_id_partida_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE partidas_id_partida_seq OWNER TO marlon;

--
-- Name: partidas_id_partida_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: marlon
--

ALTER SEQUENCE partidas_id_partida_seq OWNED BY partidas.id_partida;


--
-- Name: id_partida; Type: DEFAULT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY partidas ALTER COLUMN id_partida SET DEFAULT nextval('partidas_id_partida_seq'::regclass);


--
-- Name: partidas_pkey; Type: CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY partidas
    ADD CONSTRAINT partidas_pkey PRIMARY KEY (id_partida);


--
-- Name: partidas_ded997b7; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX partidas_ded997b7 ON partidas USING btree (id_aeroporto_id);


--
-- Name: partidas_id_aeroporto_id_0ae50424_like; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX partidas_id_aeroporto_id_0ae50424_like ON partidas USING btree (id_aeroporto_id varchar_pattern_ops);


--
-- Name: partidas_id_aeroporto_id_0ae50424_fk_aeroportos_id_aeroporto; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY partidas
    ADD CONSTRAINT partidas_id_aeroporto_id_0ae50424_fk_aeroportos_id_aeroporto FOREIGN KEY (id_aeroporto_id) REFERENCES aeroportos(id_aeroporto) DEFERRABLE INITIALLY DEFERRED;

