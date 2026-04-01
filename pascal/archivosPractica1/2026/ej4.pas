//4. Agregar al menú del programa del ejercicio 3, opciones para:
//a. Añadir uno o más empleados al final del archivo con sus datos ingresados por teclado.
//Tener en cuenta que no se debe agregar al archivo un empleado con un número de
//empleado ya registrado (control de unicidad).
//b. Modificar la edad de un empleado dado.
//c. Exportar el contenido del archivo a un archivo de texto llamado “todos_empleados.txt”.
//d. Exportar a un archivo de texto llamado “faltaDNIEmpleado.txt”, los empleados que no
//tengan cargado el DNI (DNI en 0).
//NOTA: Las búsquedas deben realizarse por número de empleado


// en la resolucion de este ejercicio solo voy a poner los procesos, luego seran agregado al "ej3.pas" en forma de comentario

function existeEmpleado(numero_buscado:integer, archivo:archivo_empleados):boolean;
var
    emple : empleado
    encontre : boolean;
begin
    encontre := false;
    reset(archivo);
    while (not EOF(archivo)) and (not encontre) do begin
        read(archivo, emple);
        if(emple.num_emlpeado = numero_buscado) then begin
            encontre := true; 
        end
    end;
    close(archivo);
    existeEmlpeado := encontre;
    
end;
procedure anadirEmpleado(var archivo:archivo_empleados);
var
    emple_aux : empleado
    emple : empleado;
    num_empleado_valido : boolean;
    posicion_final_archivo : integer;
begin
    //leo un empleado, y establezco que el final del archivo es 0, a modo de incializar la variabel
    leerEmpleado(emlpe);
    posicion_final_archivo := 0;
    while (emple <> cortar_registro) do begin
        // si el empleado es valido me fijo si existe en el archivo
        num_empleado_valido := existeEmpleado(emlpe.num_empleado, archivo);
        if (num_empleado_valido)then begin
            // si no existe en el archivo abro el archivo, eso significa que voy a agregar un empleado
            reset(archivo);
            if(posicion_final_archivo = 0) then begin
                //si la poscicion es = 0, significa que es la primera vez que voy a agregar un emlpeado
                //asi que voy hasta el final del archivo
                while not EOF(archivo) do begin
                    read(archivo, emple_aux);
                end;
                // me guardo la posicion final del archivo para evitar volver a ver todo el archivo para encontrar el final
                posicion_final_archivo := filepos(archivo)              
            end else begin
                //reposiciono la flecha del archivo al ultimo elemento, en caso de que la posicion final del archivo no sea 0
                    seek(archivo, posicion_final_archivo);
                end;
                // escribo en el archivo y actualizo la referencia al final del archivo
            write(archivo, emple);
            write('---emlpeado cargado---')
            posicion_final_archivo := posicion_final_archivo + 1;
        end
        leerEmpleado(emple);
    end;
    close(archivo);
end;

procedure modificarEdad(var archivo:archivo_empleados);
var
    emple : empleado;
    encontre : boolean;
    edad : integer;
    posicion_escritura : integer;
    numero_empleado : integer;
begin
    write('ingrese un numero de empleado');
    readln(numero_empleado);
    //inicializo la variable y abro el archivo
    encontre := false;
    reset(archivo);
    // si no es el final del archivo y tampoco encontre el nombre sigo buscando
    while not EOF(archivo) and (not encontre) do begin
        read(archivo, emlpe);
        if (emple.num_empleado = numero_empleado) then begin
            //encontre el empleado asi qeu procedo a pedir la edad y cambiarla
            writeln('ingrese la nueva edad del empleado');
            readln(edad);
            emple.edad = edad;
            // guardo la posicion en al que tengo que escribir el empleado en una variable para mas legibilidad
            posicion_escritura := filepos(archivo)-1;
            seek(archivo, posicion_escritura);
            write(archivo, emple);
            writeln(' se cambio la edad exitosamente');
            encontre := true;
        end;
    end;
    if not encontre then begin
        writeln('no se encontro el empleado: ', numero_empleado);
    end;
    close(archivo);
end;

procedure exportarATexto(var archivo:archivo_empleados);
var
    archivo_de_texto : text;
    emple : empleado;
    linea : String;
begin
    // asigno el archivo de salida
    assign(archivo_de_texto, 'todos_empleados.txt');
    rewrite(archivo_de_texto);
    reset(archivo);
    while not EOF(archivo) do begin
    // mientras no termine el archivo anoto los empleados al archivo de texto salida
        read(archivo, emple);
        linea := 'Nombre: ' + emple.nombre + ' apellido: ' + emple.apellido + ' dni: ' + IntToStr(emple.dni) + ' edad: ' + IntToStr(emple.edad) + ' numero de empleado: ' + IntToStr(num_empleado);
        write(archivo_de_texto, linea);
    end;
    write('se exporto correctamente a texto en el archivo "todos_empleados.txt"');
    close(archivo_de_texto);
    close(archivo);
end;

procedure exportarEmpleadosSinDni(var archivo : archivo_empleados);
var
    emple : empleado;
    archivo_de_dni : text;
    linea : String; 
begin
    // asigno el archov de salida
    assign(archivo_de_dni, 'faltaDNIEmpleado.txt');
    rewrite(archivo_de_dni);
    reset(archivo);
    while not EOF(archivo) do begin
    // si no termine todo el archivo leo empleados
      read(archivo, emple);
      if (emple.dni = 0) then begin
      // si el dni es 0 lo guardo en el nuevo archivo salida
            linea := 'Numero de empleado: ' + IntToStr(num_empleado);
            write(archivo_de_texto, linea);
      end;
    end;
    close(archivo);
    close(archivo_de_texto);
end;
