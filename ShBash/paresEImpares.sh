#22. Implemente un script que recorra un arreglo compuesto por números e imprima
#en pantalla sólo los números pares y que cuente sólo los números impares y los
#informe en pantalla al finalizar el recorrido.

#!/bin/bash
contador=()
for numero in "${arreglo[@]}" ; do
    if (( $numero % 2 == 0 )) ; then
        echo "$numero"
    else    
        contador+=("$numero")
    fi
done
echo "${contador[@]}"
exit 0