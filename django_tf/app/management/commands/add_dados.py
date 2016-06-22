import json
import os
import random

from datetime import datetime

from app.models import (Aliancas, Aeroportos, LinhasAereas, Clientes, Passagens,
                        Aeronaves, Voos, Partidas, Chegadas, Assentos, Promocoes)

from django.core.management.base import BaseCommand


class Command(BaseCommand):
    help = 'Adicionar dados no banco'

    def handle(self, *args, **options):
        print('Abrindo arquivos')
        airlines_arquivo = open(os.path.join('app', 'management', 'commands', 'dados', 'airlines.json'), 'r')
        airports_arquivo = open(os.path.join('app', 'management', 'commands', 'dados', 'airports.json'), 'r')
        alliances_arquivo = open(os.path.join('app', 'management', 'commands', 'dados', 'alliances.json'), 'r')
        equipment_arquivo = open(os.path.join('app', 'management', 'commands', 'dados', 'equipment.json'), 'r')
        routes_arquivo = open(os.path.join('app', 'management', 'commands', 'dados', 'routes.json'), 'r')
        datas_partida = open(os.path.join('app', 'management', 'commands', 'dados', 'datas_partida_chegada.json'), 'r')
        dados_basicos_file = open(os.path.join('app', 'management', 'commands', 'dados', 'dados_basicos.json'), 'r')

        print('Json Loads')
        airlines = json.loads(airlines_arquivo.read())
        airports = json.loads(airports_arquivo.read())
        alliances = json.loads(alliances_arquivo.read())
        equipment = json.loads(equipment_arquivo.read())
        routes = json.loads(routes_arquivo.read())
        datas = json.loads(datas_partida.read())
        dados_basicos = json.loads(dados_basicos_file.read())

        print('Fechando Arquivos')
        airlines_arquivo.close()
        airports_arquivo.close()
        alliances_arquivo.close()
        equipment_arquivo.close()
        routes_arquivo.close()
        datas_partida.close()
        dados_basicos_file.close()

        print('Criando Alianças')
        aliancas = {}
        for key, _ in alliances.items():
            aliancas[key] = Aliancas.objects.create(nome=key)

        print('Criando Linhas Aéreas')
        linhas_aereas = {}
        for key, value in airlines.items():
            ali = None
            for i, _ in alliances.items():
                if key in alliances[i]["list-of-airlines"]:
                    ali = aliancas[i]
                    break
            linhas_aereas[key] = LinhasAereas.objects.create(id_linha_aerea=key, nome=value, id_alianca=ali)

        print('Criando Aeroportos')
        aeroportos = {}
        for key in airports.keys():
            aeroportos[key] = Aeroportos.objects.create(id_aeroporto=key,
                                                        latitude=airports[key]['latitude'],
                                                        longitude=airports[key]['longitude'],
                                                        nome=airports[key]['airport-name'])
        print('Criando Aeronaves')
        aeronaves = {}
        for key in equipment.keys():
            aeronaves[key] = Aeronaves.objects.create(id_aeronave=key,
                                                      fabricante=equipment[key]['fabricante'],
                                                      modelo=equipment[key]['modelo'],
                                                      numero_de_assentos=50)
        print('Criando Voos')
        voos = []
        for i in range(0, 300):
            r = routes[i]
            if r['from'] in aeroportos:
                aer_part = aeroportos[r['from']]
            else:
                continue

            if r['to'] in aeroportos:
                aer_cheg = aeroportos[r['to']]
            else:
                continue

            part = Partidas.objects.create(data_partida=datas[i]['data_partida'],
                                           hora_partida=datas[i]['hora_partida'], id_aeroporto=aer_part)

            cheg = Chegadas.objects.create(data_chegada=datas[i]['data_chegada'],
                                           hora_chegada=datas[i]['hora_chegada'], id_aeroporto=aer_cheg)

            if r['equipment'] in aeronaves:
                aero = aeronaves[r['equipment']]
            else:
                part.delete()
                cheg.delete()
                continue

            if r['airline'] in linhas_aereas:
                lin_ae = linhas_aereas[r['airline']]
            else:
                part.delete()
                cheg.delete()
                continue

            voo = Voos.objects.create(id_linha_aerea=lin_ae, id_aeronaves=aero,
                                      tempo_estimado=random.randint(5, 24), id_partida=part,
                                      id_chegada=cheg)
            voos.append(voo)

        print('Criando Assentos')
        for a in aeronaves.keys():
            aero = aeronaves[a]
            for i in range(1, 10):
                Assentos.objects.create(id_aeronave=aero, tipo='{}{}'.format(str(i), "A"))
                Assentos.objects.create(id_aeronave=aero, tipo='{}{}'.format(str(i), "B"))
                Assentos.objects.create(id_aeronave=aero, tipo='{}{}'.format(str(i), "C"))
                Assentos.objects.create(id_aeronave=aero, tipo='{}{}'.format(str(i), "D"))
                Assentos.objects.create(id_aeronave=aero, tipo='{}{}'.format(str(i), "E"))

        print('Criando Clientes')
        clientes = []
        for cli in dados_basicos:
            c = Clientes.objects.create(nome=cli['nome'], cpf=cli['cpf'],
                                        rg=cli['rg'], numero_passaporte=cli['numero_passaporte'])
            clientes.append(c)

        PROMO = [Promocoes.objects.create(descricao='Desconto nas passagens',
                                          tipo='desconto', data_validade=datetime(2016, 11, 11)),
                 Promocoes.objects.create(descricao='Passagem Grátis',
                                          tipo='gratis', data_validade=datetime(2016, 11, 11)), ]

        print('Criando Passagens')
        VALORES = [1235.15, 2343.43, 5643.32, 4321.34]
        for v in range(1, 499):
            voo = random.choice(voos)
            assentos = Assentos.objects.filter(id_aeronave=voo.id_aeronaves)
            assento = random.choice(assentos)
            passa = Passagens.objects.create(id_cliente=random.choice(clientes), status="Pendente",
                                             data_compra=datetime.now(), preco_de_compra=random.choice(VALORES),
                                             id_assento=assento, id_voo=voo)
