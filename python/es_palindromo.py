def palindromo (palabra:str)-> bool:
    reverso = ""
    for char in palabra[::-1]:
        reverso += char
    return reverso == palabra
print(palindromo("anaasd"))