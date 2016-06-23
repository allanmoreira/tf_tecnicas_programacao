--
-- PostgreSQL Assentos

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
-- Name: assentos; Type: TABLE; Schema: public; Owner: marlon
--

CREATE TABLE assentos (
    id_assento integer NOT NULL,
    tipo character varying(10) NOT NULL,
    id_aeronave_id character varying(3) NOT NULL
);


ALTER TABLE assentos OWNER TO marlon;

--
-- Name: assentos_id_assento_seq; Type: SEQUENCE; Schema: public; Owner: marlon
--

CREATE SEQUENCE assentos_id_assento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE assentos_id_assento_seq OWNER TO marlon;

--
-- Name: assentos_id_assento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: marlon
--

ALTER SEQUENCE assentos_id_assento_seq OWNED BY assentos.id_assento;


--
-- Name: id_assento; Type: DEFAULT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY assentos ALTER COLUMN id_assento SET DEFAULT nextval('assentos_id_assento_seq'::regclass);


--
-- Name: assentos_pkey; Type: CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY assentos
    ADD CONSTRAINT assentos_pkey PRIMARY KEY (id_assento);


--
-- Name: assentos_495d0533; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX assentos_495d0533 ON assentos USING btree (id_aeronave_id);


--
-- Name: assentos_id_aeronave_id_f05a8875_like; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX assentos_id_aeronave_id_f05a8875_like ON assentos USING btree (id_aeronave_id varchar_pattern_ops);


--
-- Name: assentos_id_aeronave_id_f05a8875_fk_aeronaves_id_aeronave; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY assentos
    ADD CONSTRAINT assentos_id_aeronave_id_f05a8875_fk_aeronaves_id_aeronave FOREIGN KEY (id_aeronave_id) REFERENCES aeronaves(id_aeronave) DEFERRABLE INITIALLY DEFERRED;

