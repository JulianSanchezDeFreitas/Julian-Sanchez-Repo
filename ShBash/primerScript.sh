#!/Bin/bash
 

echo "ingrese 2 numeros"
read n1 n2
suma=$((n1 + n2)) # doble parentesis para expresiones aritmeticas y
                  # el dolar para que bash remplaza la construccion por su resultado numerico
resta=$((n1 - n2))

multiplicacion=$((n1 * n2)) 

echo "suma $suma"
echo "resta $resta"
echo "multiplicacion $multiplicacion"
if [ "$n1" -gt "$n2" ]; then  #se pone comillas para evitar errores
    echo "n1 es mayor"
elif ["$n2" -gt "$n1" ]; then
    echo "n2 es mayor"
else
    echo "son iguales"
fi

# parte 2 del script, se reciben valores por parametro
# se controla que los paramentros sean enviados

if [ $# -ne 2]; then
    exit 5 # sale porque no se enviarion los 2 paramentros 
fi
n1=$1
n2=$2

suma=$(($n1 + $n2)) # doble parentesis para expresiones aritmeticas y
                  # el dolar para que bash remplaza la construccion por su resultado numerico
resta=$(($n1 - $n2))

multiplicacion=$(($n1 * $n2)) 

echo "suma $suma"
echo "resta $resta"
echo "multiplicacion $multiplicacion"
if [ "$n1" -gt "$n2" ]; then  #se pone comillas para evitar errores
    echo "n1 es mayor"
elif ["$n2" -gt "$n1" ]; then
    echo "n2 es mayor"
else
    echo "son iguales"
fi
