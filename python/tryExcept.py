num = int(input("Ingrese un numero entero"))
try:
   resultado = num / 0
except ZeroDivisionError:
    print("estas dividiendo por 0 animal")

try:
    print("segundo try")
    resultado = 1 + 2
    raise ZeroDivisionError

except ZeroDivisionError:
    print("no hubo drama")
except:
    print("por las dudas")
finally:
    print("termino mi try")