#Realice un script que reciba como parámetro el nombre de un directorio. Deberá
#validar que el mismo exista y de no existir causar la terminación del script con
#código de error 4. Si el directorio existe deberá contar por separado la cantidad
#de archivos que en él se encuentran para los cuales el usuario que ejecuta el
#script tiene permiso de lectura y escritura, e informar dichos valores en pantalla.
#En caso de encontrar subdirectorios, no deberán procesarse, y tampoco deberán
#ser tenidos en cuenta para la suma a informar.

#!/bin/bash



if [ $# -ne 1 ] ; then
    exit 1
fi

direcotorio=$1

if  [ ! -d "$direcotorio" ] ; then
    exit 4
fi
contador_lectura=0
contador_escritura=0

for archivo in "$directorio"/* ; do
    if [ -f "$archivo" ] ; then
        if [ -r "$archivo" ] ; then
            ((contador_lectura++))
        fi
        if [ -w "$archivo" ] ; then
            ((contador_escritura++))
        fi
done

echo "en el direcotrio $directorio, hay en total, $contador_lectura archivos con permiso de lectura y 
$contador_escritura archivos con permiso de escritura"