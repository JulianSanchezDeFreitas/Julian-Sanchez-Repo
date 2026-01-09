#21. Dada la siguiente declaración al comienzo de un script:
#num=(10 3 5 7 9 3 5 4)
#(la cantidad de elementos del arreglo puede variar).
#Implemente la función productoria dentro de este script, cuya tarea sea multiplicar
#todos los números que el arreglo contiene.

#!/bin/bash
productoria (){
    local resultado=1
    if [ ${#num[@]} -eq 0 ] ; then
        return 1
    fi
    for numero in "${num[@]}" ; do
        resultado=$(( $resultado * $numero))
    done
    echo "$resultado"
    return 0
}

