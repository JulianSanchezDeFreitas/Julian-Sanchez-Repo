# es isograma

def wordCleaner(palabra:str)->str:
    palabra = palabra.replace(" ", "")
    return palabra.lower()

def esIsograma(palabra:str)->bool:
    """uso de set, contra recorro toda la palabra"""
    palabra_limpia = wordCleaner(palabra)
    set_letras  = set()
    for letra in palabra_limpia:
        set_letras.add(letra)
    return True if( len(set_letras) == len(palabra_limpia)) else False

def esIsograma2(palabra:str)->bool:
    """ Recorro hasta que encuentro una letra que ya aparecio"""
    palabra_limpia = wordCleaner(palabra=palabra)
    lista_letras = []
    for letra in palabra_limpia:
        if letra in lista_letras:
            return False
        lista_letras.append(letra)
    return True

palabra = "holaa"
palabra2 = "carajo"
fueIsograma2 = esIsograma2(palabra2)
print(fueIsograma2)
#fueIsograma = esIsograma(palabra=palabra)
#print(fueIsograma)
