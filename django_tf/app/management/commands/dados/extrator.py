import codecs
import json


def converter_airlines():
    arqui = codecs.open('airlines.dat', 'r', 'utf-8')
    linhas = arqui.readlines()
    arqui.close()
    airlines = {}
    for i in range(1, len(linhas)):
        air = linhas[i].split('\t')
        airlines[air[0]] = air[1].replace('\n', '')

    arqu_save = codecs.open('airlines.json', 'w', 'utf-8')
    arqu_save.write(json.dumps(airlines, ensure_ascii=False, indent=1))
    arqu_save.close()


def converter_airports():
    arqui = codecs.open('airports.dat', 'r', 'utf-8')
    linhas = arqui.readlines()
    arqui.close()
    airports = {}
    for i in range(1, len(linhas)):
        air = linhas[i].split('\t')
        airports[air[0]] = {'latitude': air[1], 'longitude': air[2],
                            'airport-name': air[3].replace('\n', '').rstrip().lstrip()}

    arqu_save = codecs.open('airports.json', 'w', 'utf-8')
    arqu_save.write(json.dumps(airports, ensure_ascii=False, indent=1))
    arqu_save.close()


def converter_alliances():
    arqui = codecs.open('alliances.dat', 'r', 'utf-8')
    linhas = arqui.readlines()
    arqui.close()
    alliances = {}
    for i in range(1, len(linhas)):
        air = linhas[i].split('\t')
        alliances[air[0]] = {'list-of-airlines': air[1].replace('\n', '').replace('\r', '').split()}

    arqu_save = codecs.open('alliances.json', 'w', 'utf-8')
    arqu_save.write(json.dumps(alliances, ensure_ascii=False, indent=1))
    arqu_save.close()


def converter_equipment():
    arqui = codecs.open('equipment.dat', 'r', 'utf-8')
    linhas = arqui.readlines()
    arqui.close()
    equipment = {}
    for i in range(1, len(linhas)):
        air = linhas[i].split(',')
        if len(air) == 3:
            equipment[air[0]] = {'fabricante': air[1], 'modelo': air[2].replace('\n', '').replace('\r', '')}
        elif len(air) == 2:
            equipment[air[0]] = {'fabricante': air[1].replace('\n', '').replace('\r', ''), 'modelo': ''}

    arqu_save = codecs.open('equipment.json', 'w', 'utf-8')
    arqu_save.write(json.dumps(equipment, ensure_ascii=False, indent=1))
    arqu_save.close()


def converter_routes():
    arqui = codecs.open('routes.dat', 'r', 'utf-8')
    linhas = arqui.readlines()
    arqui.close()
    routes = []
    for i in range(1, len(linhas)):
        rou = linhas[i].split(',')
        if len(rou) < 3:
            print(linhas[i])
            continue
        tmp = {'airline': rou[0], 'from': rou[1], 'to': rou[2]}
        if rou[3] == '0':
            tmp['equipment'] = rou[4].replace('\n', '').replace('\r', '')
        else:
            tmp['equipment'] = rou[3].replace('\n', '').replace('\r', '')
        routes.append(tmp)

    arqu_save = codecs.open('routes.json', 'w', 'utf-8')
    arqu_save.write(json.dumps(routes, ensure_ascii=False, indent=1))
    arqu_save.close()


if __name__ == '__main__':
    # converter_airlines()
    # converter_airports()
    # converter_alliances()
    # converter_equipment()
    converter_routes()
