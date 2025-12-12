#!/bin/bash
#Realizar un script que visualice por pantalla los números del 1 al 100 así
#como sus cuadrados


for i in {1..100}
do
    cuadrado=$(($i * $i))
    echo "$i  $cuadrado"
done