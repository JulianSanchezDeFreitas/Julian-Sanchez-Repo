#!/bin/bash


#Renombrando Archivos: haga un script que renombre solo archivos de un
#directorio pasado como parámetro, agregandole una CADENA, contemplando las
#opciones:
#➢ “-a CADENA”: renombra el fichero concatenando CADENA al final del nombre
#del archivo
#➢ “-b CADENA”: renombra el fichero concatenando CADENA al comienzo del
#nombre del archivo
#Ejemplos:
#Si tengo los siguientes archivos: /tmp/a /tmp/b , al ejecutar: ./renombra /tmp/ -a EJ
#obtendré como resultado: /tmp/aEJ /tmp/bEJ. Y si ejecuto: ./renombra /tmp/ -b EJ
#el resultado será: /tmp/EJa /tmp/EJb

#reviso que se hayan mandado los 3 parametros

if [ $# -ne 3 ] ; then
    exit 1
fi
directorio=$1
operacion=$2
cadena=$3

if [ ! -d $directorio ] ;then
    exit 2
fi

if ! [[ "$operacion" == "-a"  ||  "$operacion" == "-b" ]] ; then
    exit 3
fi

for archivo in "$directorio"/* ; do
    if [ -f "$archivo" ]; then
        nombre=$(basename "$archivo")
        ruta=$(dirname "$archivo")

        if [ "$operacion" == "-a" ] ; then
            nuevo_nombre="${nombre}${cadena}"
        else 
            nuevo_nombre="${cadena}${nombre}"
        fi
        mv "$archivo" "${ruta}/${nuevo_nombre}"
    fi
done
echo "Se han renombrado los archivos del directorio $directorio"