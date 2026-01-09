#Realice un script que implemente a través de la utilización de funciones las
#operaciones básicas sobre arreglos:
    #➢ inicializar: Crea un arreglo llamado array vacío
    #➢ agregar_elem <parametro1>: Agrega al final del arreglo el parámetro
    #recibido
    #➢ eliminar_elem <parametro1>: Elimina del arreglo el elemento que se
    #encuentra en la posición recibida como parámetro. Debe validar que
    #se reciba una posición válida
    #➢ longitud: Imprime la longitud del arreglo en pantalla
    #➢ imprimir: Imprime todos los elementos del arreglo en pantalla
    #➢ inicializar_Con_Valores <parametro1><parametro2>: Crea un arreglo
    #con longitud <parametro1>y en todas las posiciones asigna el valor
    #<parametro2>

    #!/bin/bash

    function inicializar () {
        array_vacio=()
        return 0
    }

    function agregar_elem () {
        if [ $# -ne 1] ; then
            return 1
        fi
        array_vacio+="($1)"
        return 0
    }

    function eliminar_elem () {
        if [ $# -ne 1] ; then
            return 1
        fi
        indice=$1
        if [ $indice -lt "${#array_vacio[@]}" ] ; then
            return 2
        fi
        unset "array_vacio[$indice]"

    }

    function longitud () {
        echo "${#array_vacio[@]}"
        return 0
    }

    function imprimir (){
        echo "${array_vacio[@]}"
        return 0
    }

    function inicializar_Con_Valores () {
        if [ $# -ne 2 ] ; then
            return 1
        fi
        inicializar
        longitud=$1
        valor=$2
        for i in {1..$longitud} ; do
            $array_vacio+=("$valor")
        done
        }