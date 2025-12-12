#!/bin/bash


# una calculadora que recibe 2 numeros y un operador y realiza la operacion, orden numero operacion numero

if [ $# -ne 3 ] ; then
    exit 1
fi
# se supone que los numeros enviados son numeros y no otra cosa
# verificacion echa por gemini "! [[ "$num1" =~ ^[0-9]+(\.[0-9]+)?$ ]] || ! [[ "$num2" =~ ^[0-9]+(\.[0-9]+)?$ ]];" then para numeros
n1=$1
n2=$3
operador=$2
#controlo el operador 
case "$operador" in
    "+" | "-" | "*" | "%")
        ;;
    *)
        echo "Error: Operador '$operador' no válido."
        echo "Operadores permitidos: +, -, *, %"
        exit 2
        ;;
esac
# evito division por 0
if [ "$operador" == "%" ] && [ $n2 -eq 0 ]; then
    exit 3
fi
resultado=$(($n1 $operador $n2))

echo "el resultado es $resultado"

