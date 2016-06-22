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

--
-- Data for Name: promocoes; Type: TABLE DATA; Schema: public; Owner: marlon
--

INSERT INTO promocoes (id_promocao, descricao, tipo, data_validade) VALUES (1, 'Desconto nas passagens', 'desconto', '2016-11-11');
INSERT INTO promocoes (id_promocao, descricao, tipo, data_validade) VALUES (2, 'Passagem Grátis', 'gratis', '2016-11-11');


--
-- Name: promocoes_id_promocao_seq; Type: SEQUENCE SET; Schema: public; Owner: marlon
--

SELECT pg_catalog.setval('promocoes_id_promocao_seq', 2, true);


--
-- PostgreSQL database dump complete
--

