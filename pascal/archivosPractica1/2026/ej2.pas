//Realizar un algoritmo, que utilizando el archivo de números enteros no ordenados creado en el
//ejercicio 1, informe por pantalla cantidad de números menores a 15000 y el promedio de los
//números ingresados. El nombre del archivo a procesar debe ser proporcionado por el usuario
//una única vez. Además, el algoritmo deberá listar el contenido del archivo en pantalla. Resolver
//el ejercicio realizando un único recorrido del archivo.
const
    numero_limite = 15000;
type
    // defino mi variable que representa al archivo
    arch_numeros = file of integer;

procedure procesar_archivo(var arch:arch_numeros);
var
    suma_total : integer;
    cantidad_num_menores : integer;
    num : integer;
    cantidad_de_num : integer;
begin
    cantidad_de_num := 0;
    suma_total:=0;
    cantidad_num_menores:=0;
    reset(arch);
    while not (EOF(arch)) do begin
        read(arch, num);
        cantidad_de_num := cantidad_de_num + 1;
        suma_total:= suma_total + num;
        if (num < numero_limite) then 
            cantidad_num_menores := cantidad_num_menores + 1;
    end;
    
    if ( cantidad_de_num > 0) then
        write('el promedio de todos los numeros en el archivo es: ', (suma_total/cantidad_de_num):0:2)
        write(' y la cantidad de numeros menores a 15000 es: ', cantidad_num_menores);
    else
        write('el promedio de todos los numeros en el archivo y la cantidad de numeros menores a 15000 es: 0, no tiene datos el archivo')
end;


//programa principal


var
    arch : arch_numeros;
    nombre : String;
begin
    write('ingrese el nombre del archivo');
    read(nombre);
    // asigno el nombre enviado a mi archivo de numeros
    assign(arch, nombre);
    procesar_archivo(arch);
    
end.
