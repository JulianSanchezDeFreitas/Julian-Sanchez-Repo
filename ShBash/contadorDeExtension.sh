#Realizar un script que reciba como parámetro una extensión y haga un reporte
#con 2 columnas, el nombre de usuario y la cantidad de archivos que posee con
#esa extensión. Se debe guardar el resultado en un archivo llamado reporte.txt

#!/bin/bash

if [ $# -ne 1 ] ; then
    echo " no se ingreso una extension por parametro"
    exit 1
if


extension=$1
salida="reporte.txt"
# para cada directorio en el home hago lo siguiente
for dir in /home/* ; do 
   # si el archivo actual es un directorio 
    if [ -d "$dir" ]; then 
        # me quedo con el nombre de usuario
        usuario=$(basename "$dir")  
        # cuento al cantidad de archivos dentro del directorio con dicha extension
        cantidad=$(find "$dir" type -f name "*$extension" 2>/dev/null | wc -l) # los codigos de 2 se mandan a dev/null un "vacio"
        # se escribe en reporte.txt el usuario y la cantidad
        echo "$usuario / $cantidad " >> "$salida"
    fi