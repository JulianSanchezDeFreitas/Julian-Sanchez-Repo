import csv
from pathlib import Path
from collections import Counter
from datetime import datetime

def enRango(xx):
    format="%d/%m/%y, %H:%M:%S"
    h= datetime.strptime(xx, format)
    return h.weekday() in range(5, 7)


def mi_filtro(csv_reader, cant):
    users = filter(lambda x:  enRango(x["Hora"]), csv_reader)
    return Counter( map(lambda x: x['Nombre completo del usuario'], users)).most_common(cant)


file_route = Path('archivos') / 'logs_catedra.csv'

with open(file_route,encoding="utf-8") as file:
    csv_reader = csv.DictReader(file, delimiter=',')
    x= mi_filtro(csv_reader)
for elem in x:
    print(f'Usuario: {elem[0]} - Cantidad: {elem[1]}')