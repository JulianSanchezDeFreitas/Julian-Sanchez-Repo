#24. Realice un script que agregue en un arreglo todos los nombres de los usuarios
#del sistema pertenecientes al grupo “users”. Adicionalmente el script puede
#recibir como parámetro:
#➢ “-b n”: Retorna el elemento de la posición n del arreglo si el mismo
#existe. Caso contrario, un mensaje de error.
#➢ “-l”: Devuelve la longitud del arreglo
#➢ “-i”: Imprime todos los elementos del arreglo en pantalla

arreglo_de_nombres=($(getent group "users" | cut -d: -f4 | tr ',' ' '))




if [ $# -eq 0 ] || [ ${#arreglo_de_nombres[@]} -eq 0 ] ; then
    exit 0
fi
operador=$1
case $operador in 
    "-b")
        if [ -z $2 ] ; then
            exit 2
        fi
        numero=$2
        if [ ! [ "$n" -ge 0 ] && [ "$n" -lt "${#usuarios[@]}" ]] ; then   
            exit 3
        fi
        echo "${arreglo_de_nombres[$numero]}"
    ;;
    "-l")
        echo "${#arreglo_de_nombres[@]}"
    ;;
    "-i")
        echo "${arreglo_de_nombres[@]}"
    ;;
    *)
        echo "error en parametro"
        exit 1
    ;;
esac

