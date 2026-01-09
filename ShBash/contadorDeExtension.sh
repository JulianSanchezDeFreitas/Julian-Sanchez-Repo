#Realizar un script que reciba como parámetro una extensión y haga un reporte
#con 2 columnas, el nombre de usuario y la cantidad de archivos que posee con
#esa extensión. Se debe guardar el resultado en un archivo llamado reporte.txt

#!/bin/bash

if [ $# -ne 1 ] ; then
    echo " no se ingreso una extension por parametro"
    exit 1
if

#verifico que sea una extension
extension=$1
salida="reporte.txt"

for dir in /home/* ; do
    if [ -d "$dir" ]; then
        usuario=$(basename "$dir")
        cantidad=$(find "$dir" type -f name "*$extension" 2>/dev/null | wc -l)
        echo "$usuario / $cantidad " >> "$salida"
    fi