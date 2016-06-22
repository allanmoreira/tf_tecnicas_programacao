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
-- Data for Name: aliancas; Type: TABLE DATA; Schema: public; Owner: marlon
--

INSERT INTO aliancas (id_alianca, nome) VALUES (1, 'Star Alliance');
INSERT INTO aliancas (id_alianca, nome) VALUES (2, 'SkyTeam ');
INSERT INTO aliancas (id_alianca, nome) VALUES (3, 'oneworld');


--
-- Name: aliancas_id_alianca_seq; Type: SEQUENCE SET; Schema: public; Owner: marlon
--

SELECT pg_catalog.setval('aliancas_id_alianca_seq', 3, true);


--
-- PostgreSQL database dump complete
--

