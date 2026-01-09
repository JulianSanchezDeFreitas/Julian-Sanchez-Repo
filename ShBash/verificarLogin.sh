#Crear un script que verifique cada 10 segundos si un usuario se ha logueado en
#el sistema (el nombre del usuario será pasado por parámetro). Cuando el usuario
#finalmente se loguee, el programa deberá mostrar el mensaje ”Usuario XXX
#logueado en el sistema” y salir.

#!/bin/bash

if [ $# -ne 1] ; then
    exit 1
fi

usuario=$1
# el contador no es parte del ejercicio pero para evitar bucles
contador=0

while true ; do
    if who | grep -wq "$usuario"; then
        echo "el usuario esta logueado"
        exit 0
    else
        contador=$contador + 1
        echo "no se encontro"
        sleep 10 
    fi

    if [ $contador -eq 10 ] ; then
        echo "limite de intentos alcanzado"
        exit 2
    fi|
done