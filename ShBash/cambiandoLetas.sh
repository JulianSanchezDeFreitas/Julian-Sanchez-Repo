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

for archivo in /. ; do #itero por cada archivo del sistema
    if [ -f "$archivo"] ; then    #si es archivo entro al if
        nombre=$(basename "$archivo") #me quedo con el nombre del archivo
        nombre_nuevo=$("$nombre" | tr "A-Za-z" "a-zA-Z" | tr -d "aA" ) #cambios las mayusculas a minusculas y viceverza, ademas de borrar las a
        echo "$nombre_nuevo" #imprimo el nuevo nombre
    fi
done