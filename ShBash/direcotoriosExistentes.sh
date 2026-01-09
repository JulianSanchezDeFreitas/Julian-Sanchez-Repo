
#25. Escriba un script que reciba una cantidad desconocida de parámetros al
#momento de su invocación (debe validar que al menos se reciba uno). Cada
#parámetro representa la ruta absoluta de un archivo o directorio en el sistema. El
#script deberá iterar por todos los parámetros recibidos, y solo para aquellos
#parámetros que se encuentren en posiciones impares (el primero, el tercero, el
#verificar si el archivo o directorio existen en el sistema, imprimiendo en pantalla
#que tipo de objeto es (archivo o directorio). Además, deberá informar la cantidad
#de archivos o directorios inexistentes en el sistema.


#!/bin/bash

if [ $# -eq 0] ; then
    exit 1
fi

contador=0
contador_inexistentes=0
for ruta in "$@" ; do 
    ((contador++))
    if [ -e "$ruta" ] ; then
        if (( contador % 2 != 0)) ; then
            if [ -d "$ruta" ] ; then
                echo "es un direcotrio"
            elif [ -f "$ruta" ] ; then           
                echo "es un archivo regular"
            fi
        fi
    else
        ((contador_inexistentes++))
    fi
done
echo "la cantidad de archivos inexistentes es $contador_inexistentes"