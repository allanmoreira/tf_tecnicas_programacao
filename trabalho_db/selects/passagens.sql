﻿SELECT "passagens"."id_passagem", 
"passagens"."id_cliente_id", 
"passagens"."status", 
"passagens"."data_compra", 
"passagens"."preco_de_compra", 
"passagens"."promocoes_id", 
"passagens"."id_assento_id", 
"passagens"."id_voo_id", 
"clientes"."id_cliente", 
"clientes"."nome", 
"clientes"."rg", 
"clientes"."cpf", 
"clientes"."numero_passaporte", 
"assentos"."id_assento", 
"assentos"."id_aeronave_id", 
"assentos"."tipo", 
"aeronaves"."id_aeronave", 
"aeronaves"."fabricante", 
"aeronaves"."modelo", 
"aeronaves"."numero_de_assentos", 
"voos"."id_voo", 
"voos"."id_linha_aerea_id", 
"voos"."id_aeronaves_id", 
"voos"."tempo_estimado", 
"voos"."id_partida_id", 
"voos"."id_chegada_id", 
"linhas_aereas"."id_linha_aerea", 
"linhas_aereas"."nome", 
"linhas_aereas"."id_alianca_id", 
T7."id_aeronave", 
T7."fabricante", 
T7."modelo", 
T7."numero_de_assentos", 
"partidas"."id_partida", 
"partidas"."data_partida", 
"partidas"."hora_partida", 
"partidas"."id_aeroporto_id", 
"aeroportos"."id_aeroporto", 
"aeroportos"."latitude", 
"aeroportos"."longitude", 
"aeroportos"."nome", 
"chegadas"."id_chegada", 
"chegadas"."data_chegada", 
"chegadas"."hora_chegada", 
"chegadas"."id_aeroporto_id", 
T11."id_aeroporto", 
T11."latitude", 
T11."longitude", 
T11."nome" 
FROM "passagens" 
INNER JOIN "clientes" ON ("passagens"."id_cliente_id" = "clientes"."id_cliente") 
INNER JOIN "assentos" ON ("passagens"."id_assento_id" = "assentos"."id_assento") 
INNER JOIN "aeronaves" ON ("assentos"."id_aeronave_id" = "aeronaves"."id_aeronave") 
INNER JOIN "voos" ON ("passagens"."id_voo_id" = "voos"."id_voo") 
INNER JOIN "linhas_aereas" ON ("voos"."id_linha_aerea_id" = "linhas_aereas"."id_linha_aerea") 
INNER JOIN "aeronaves" T7 ON ("voos"."id_aeronaves_id" = T7."id_aeronave") 
INNER JOIN "partidas" ON ("voos"."id_partida_id" = "partidas"."id_partida") 
INNER JOIN "aeroportos" ON ("partidas"."id_aeroporto_id" = "aeroportos"."id_aeroporto") 
INNER JOIN "chegadas" ON ("voos"."id_chegada_id" = "chegadas"."id_chegada") 
INNER JOIN "aeroportos" T11 ON ("chegadas"."id_aeroporto_id" = T11."id_aeroporto")
WHERE "clientes"."id_cliente" = 17