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
-- Name: passagens; Type: TABLE; Schema: public; Owner: marlon
--

CREATE TABLE passagens (
    id_passagem integer NOT NULL,
    status character varying(10) NOT NULL,
    data_compra timestamp with time zone NOT NULL,
    preco_de_compra numeric(10,2) NOT NULL,
    id_assento_id integer NOT NULL,
    id_cliente_id integer NOT NULL,
    id_voo_id integer NOT NULL,
    promocoes_id integer
);


ALTER TABLE passagens OWNER TO marlon;

--
-- Name: passagens_id_passagem_seq; Type: SEQUENCE; Schema: public; Owner: marlon
--

CREATE SEQUENCE passagens_id_passagem_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE passagens_id_passagem_seq OWNER TO marlon;

--
-- Name: passagens_id_passagem_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: marlon
--

ALTER SEQUENCE passagens_id_passagem_seq OWNED BY passagens.id_passagem;


--
-- Name: id_passagem; Type: DEFAULT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY passagens ALTER COLUMN id_passagem SET DEFAULT nextval('passagens_id_passagem_seq'::regclass);


--
-- Name: passagens_pkey; Type: CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY passagens
    ADD CONSTRAINT passagens_pkey PRIMARY KEY (id_passagem);


--
-- Name: passagens_6d98a18e; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX passagens_6d98a18e ON passagens USING btree (id_cliente_id);


--
-- Name: passagens_6fe27678; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX passagens_6fe27678 ON passagens USING btree (id_assento_id);


--
-- Name: passagens_8d0d862c; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX passagens_8d0d862c ON passagens USING btree (promocoes_id);


--
-- Name: passagens_924c4021; Type: INDEX; Schema: public; Owner: marlon
--

CREATE INDEX passagens_924c4021 ON passagens USING btree (id_voo_id);


--
-- Name: passagens_id_assento_id_d8c247ab_fk_assentos_id_assento; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY passagens
    ADD CONSTRAINT passagens_id_assento_id_d8c247ab_fk_assentos_id_assento FOREIGN KEY (id_assento_id) REFERENCES assentos(id_assento) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: passagens_id_cliente_id_80219f55_fk_clientes_id_cliente; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY passagens
    ADD CONSTRAINT passagens_id_cliente_id_80219f55_fk_clientes_id_cliente FOREIGN KEY (id_cliente_id) REFERENCES clientes(id_cliente) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: passagens_id_voo_id_74a8891d_fk_voos_id_voo; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY passagens
    ADD CONSTRAINT passagens_id_voo_id_74a8891d_fk_voos_id_voo FOREIGN KEY (id_voo_id) REFERENCES voos(id_voo) DEFERRABLE INITIALLY DEFERRED;


--
-- Name: passagens_promocoes_id_05216594_fk_promocoes_id_promocao; Type: FK CONSTRAINT; Schema: public; Owner: marlon
--

ALTER TABLE ONLY passagens
    ADD CONSTRAINT passagens_promocoes_id_05216594_fk_promocoes_id_promocao FOREIGN KEY (promocoes_id) REFERENCES promocoes(id_promocao) DEFERRABLE INITIALLY DEFERRED;


--
-- PostgreSQL database dump complete
--

