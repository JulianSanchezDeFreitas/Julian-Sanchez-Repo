#Escribir un Programa de “Menu de Comandos Amigable con el Usuario” llamado
#menú, el cual, al ser invocado, mostrará un menú con la selección para cada uno
#de los scripts creados en esta práctica. Las instrucciones de cómo proceder
#deben mostrarse junto con el menú. El menú deberá iniciarse y permanecer
#activo hasta que se seleccione Salir. Por ejemplo:
    #MENU DE COMANDOS
    #03. Ejercicio 3
    #12. Evaluar Expresiones
    #13. Probar estructuras de control
    #...
    #Ingrese la opción a ejecutar: 03

#!/bin/bash
direcotrio="/home/usuario/scripts/"
vector_opciones=("ejercicio1" "ejercicio2" "salir")
select opcion in "${vector_opciones[@]}"; do
    if [ "$opcion" == "salir" ] ; then
        exit 0
    fi
    bash "${direcotrio}${opcion}"
done

