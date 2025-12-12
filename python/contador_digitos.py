def contador_digitos(n : int)->int:

    digitos = 0
    if n == 0:
        return 1
    n = abs(n)
    while n > 0  :
        n = n // 10 
        digitos = digitos + 1
    return digitos


print(contador_digitos(55000))


