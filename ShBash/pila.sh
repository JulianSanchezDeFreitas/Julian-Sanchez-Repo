#Realice un script que simule el comportamiento de una estructura de PILA e
#implemente las siguientes funciones aplicables sobre una estructura global
#definida en el script:
#➔ push: Recibe un parámetro y lo agrega en la pila
#➔ pop: Saca un elemento de la pila
#➔ length: Devuelve la longitud de la pila
#➔ print: Imprime todos elementos de la pila
#Dentro del mismo script y utilizando las funciones implementadas:
#1. Agregue 10 elementos a la pila
#2. Saque 3 de ellos
#3. Imprima la longitud de la pila
#4. Luego imprima la totalidad de los elementos que en ella se encuentran.

pila=()

function push (){
    if [ $# -ne 1 ] ; then
        return 1
    fi
    pila+=("$1")
    return 0
}

function pop (){
    if [ ${#PILA[@]} -eq 0 ] ; then
        return 2
    fi
    local ultimo_indice=$((${#pila[@]} - 1))
    unset '$pila[ultimo_indice]'
}

function length (){
    echo "${#pila[@]}"
    return 0
}

function print (){
    echo "${pila[@]}"
    return 0
}