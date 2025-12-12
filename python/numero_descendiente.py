def numero_descendiente(n : int)-> int:
    lista_numeros = list()
    n = str(n)
    for digito in n:
        lista_numeros.append(digito)
    lista_numeros.sort(reverse=True)
    cadena = "".join(lista_numeros)
    numero_ordenado = int(cadena)
    return numero_ordenado

print(numero_descendiente(32145))