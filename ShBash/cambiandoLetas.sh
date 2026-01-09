#Escribir un script que al ejecutarse imprima en pantalla los nombre de los
#archivos que se encuentran en el directorio actual, intercambiando minúsculas
#por mayúsculas, además de eliminar la letra a (mayúscula o minúscula).
#Por ejemplo, si en el directorio actual están los siguientes archivos:
    #➢ IsO
    #➢ pepE
    #➢ Maria
#y ejecutó: ./ejercicio17 , se obtendrá como resultado:
    #➢ iSo
    #➢ PEPe
    #➢ mRI

#!/bin/bash

for archivo in /. ; do
    if [ -f "$archivo"] ; then    
        nombre=$(basename "$archivo")
        nombre_nuevo=$("$nombre" | tr "A-Za-z" "a-zA-Z" | tr -d "aA" )
        echo "$nombre_nuevo" 
    fi
done