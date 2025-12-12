#Crear un script que reciba como parámetro el nombre de un archivo e
#informe si el mismo existe o no, y en caso afirmativo indique si es un
#directorio o un archivo. En caso de que no exista el archivo/directorio cree
#un directorio con el nombre recibido como parámetro.

#!/bin/bash

if [ -z "$1"  ] ;then
    exit 1
fi
nombre=$1


if [ -e "$nombre" ] ; then
    if [ -f "$nombre" ] ; then
        echo "existe y es archivo"
    else
        echo "existe y es Directorio"
    fi
else
    `mkdir` "$nombre"
    echo "directorio creado"
fi
