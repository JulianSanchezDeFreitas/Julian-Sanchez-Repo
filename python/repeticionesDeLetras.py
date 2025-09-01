def repeticionesDeLetras(palabra:str)->list:
    letra_actual = palabra[0:1]
    contador_letra = 0
    Lista_final = []
    for letra in palabra:  
        if letra_actual == letra:
            contador_letra += 1 
        else:  
            Lista_final.append([letra_actual, contador_letra])
            contador_letra = 1
            letra_actual = letra
    Lista_final.append([letra_actual, contador_letra])
    return Lista_final

Lista = repeticionesDeLetras("aaaaaaabvsssade")
print(Lista)
