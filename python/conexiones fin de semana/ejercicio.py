import csv
from pathlib import Path
from collections import Counter
from datetime import datetime

def enRango(xx):
    format="%d/%m/%y, %H:%M:%S"
    h= datetime.strptime(xx, format)
    return h.weekday() in range(5, 7)


def mi_filtro(csv_reader, cant=1):
    if (cant != 1):
        users = filter(lambda x:  enRango(x["Hora"]), csv_reader)
        return Counter( map(lambda x: x['Nombre completo del usuario'], users)).most_common(cant)
    else:
        for line in csv_reader:
            if enRango(line["Hora"]):
                return [(line['Nombre completo del usuario'], )]
nombre_archivo = 'logs_cat.csv'
file_route = Path('archivos') / nombre_archivo
try:
    if nombre_archivo.endswith('.csv'):

        with open(file_route, encoding="utf-8") as file:      #agregue el encoding, si no salta error "unicodeDecodeError charmap"
            csv_reader = csv.DictReader(file, delimiter=',')
            x= mi_filtro(csv_reader)
    else:
        raise csv.Error
     
except FileNotFoundError:
    print("el archivo no existe")
    x = []
except csv.Error:
    print("el archivo no es un csv")
    x = []
except:
    print("error no contemplado")


try :
    for elem in x:
        print(f'Usuario: {elem[0]} - Cantidad: {elem[1]}')
except IndexError:
    print(f"Usuario: {elem[0]} es el primero que cumple la condicion")