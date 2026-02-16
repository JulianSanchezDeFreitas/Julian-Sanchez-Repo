#Escribir un script en Bash que reciba como argumento una lista de nombres de usuario (debe validar que se reciba, al
#menos, uno) y, para cada uno de los usuarios válidos que se hayan recibido, deberá imprimir un reporte con la siguiente
#información:
#• Nombre de usuario.
#• Ruta al directorio personal, sólo si el usuario tiene directorio personal configurado y éste existe.
#• Cantidad de archivos (no directorios) en su directorio personal. Deberá informar 0 si el usuario no posee directorio
#personal o no existe.

#!/bin/bash

if [ $# -eq 0 ];then
    exit 1
fi

for user in "$@" ; do
    archivos=0
    ruta="sin directorio"
    directorio=$(grep "$user" /etc/passwd | cut -d: -f6)
    if [ ! directorio -d ] ; then
        archivos=$(find "$directorio" -type f | wc -l)
        ruta=$directorio  
    else
        archivos=0
    fi  
    echo "nombre: $user , directorio :$ruta , archivos: $archivos"
done