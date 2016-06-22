from django.db import models


class Aeroportos(models.Model):
    id_aeroporto = models.CharField(primary_key=True, max_length=5)
    latitude = models.FloatField()
    longitude = models.FloatField()
    nome = models.CharField(max_length=255)

    class Meta:
        db_table = 'aeroportos'


class Partidas(models.Model):
    id_partida = models.AutoField(primary_key=True)
    data_partida = models.DateField()
    hora_partida = models.TimeField()
    id_aeroporto = models.ForeignKey('Aeroportos', related_name='partida_aeroporto')

    class Meta:
        db_table = 'partidas'


class Chegadas(models.Model):
    id_chegada = models.AutoField(primary_key=True)
    data_chegada = models.DateField()
    hora_chegada = models.TimeField()
    id_aeroporto = models.ForeignKey('Aeroportos', related_name='chegada_aeroporto')

    class Meta:
        db_table = 'chegadas'


class Aliancas(models.Model):
    id_alianca = models.AutoField(primary_key=True)
    nome = models.CharField(max_length=100)

    class Meta:
        db_table = 'aliancas'


class LinhasAereas(models.Model):
    id_linha_aerea = models.CharField(max_length=10, primary_key=True)
    nome = models.CharField(max_length=100)
    id_alianca = models.ForeignKey("Aliancas", null=True, related_name="aliancas_linhas_aereas")

    class Meta:
        db_table = 'linhas_aereas'


class Voos(models.Model):
    id_voo = models.AutoField(primary_key=True)
    id_linha_aerea = models.ForeignKey("LinhasAereas", related_name="voos_linhas_aereas")
    id_aeronaves = models.ForeignKey("Aeronaves", related_name="voos_aeronaves")
    tempo_estimado = models.IntegerField()
    id_partida = models.ForeignKey("Partidas", related_name="voo_partida")
    id_chegada = models.ForeignKey("Chegadas", related_name="voo_chegada")

    class Meta:
        db_table = 'voos'


class Aeronaves(models.Model):
    id_aeronave = models.CharField(primary_key=True, max_length=3)
    fabricante = models.CharField(max_length=100)
    modelo = models.CharField(max_length=50, null=True, blank=True)
    numero_de_assentos = models.IntegerField()

    class Meta:
        db_table = 'aeronaves'


class Assentos(models.Model):
    id_assento = models.AutoField(primary_key=True)
    id_aeronave = models.ForeignKey("Aeronaves", related_name="assento_aeronave")
    tipo = models.CharField(max_length=10)

    class Meta:
        db_table = 'assentos'


class Passagens(models.Model):
    id_passagem = models.AutoField(primary_key=True)
    id_cliente = models.ForeignKey("Clientes", related_name="passagem_cliente")
    status = models.CharField(max_length=10)
    data_compra = models.DateTimeField()
    preco_de_compra = models.DecimalField(max_digits=10, decimal_places=2)
    promocoes = models.ForeignKey("Promocoes", related_name="passagem_promocoes", null=True)
    id_assento = models.ForeignKey("Assentos", related_name="reserva_assento")
    id_voo = models.ForeignKey("Voos", related_name="reserva_voo")

    class Meta:
        db_table = 'passagens'


class Promocoes(models.Model):
    id_promocao = models.AutoField(primary_key=True)
    descricao = models.CharField(max_length=100)
    tipo = models.CharField(max_length=20)
    data_validade = models.DateField()

    class Meta:
        db_table = 'promocoes'


class Clientes(models.Model):
    id_cliente = models.AutoField(primary_key=True)
    nome = models.CharField(max_length=200)
    rg = models.CharField(max_length=15)
    cpf = models.CharField(max_length=20)
    numero_passaporte = models.CharField(max_length=20)

    class Meta:
        db_table = 'clientes'
