//3. Realizar un programa que presente un menú con opciones para:
    //a. Crear un archivo binario de registros no ordenados de empleados y completarlo con
    //datos ingresados desde teclado. De cada empleado se registra: número de empleado,
    //apellido, nombre, edad y DNI. Algunos empleados pueden ingresan el DNI con valor 0, lo
    //que significa que al momento de la carga puede no tenerlo. La carga finaliza cuando se
    //ingresa el String ‘fin’ como apellido.
    //b. Abrir el archivo anteriormente generado y
        //i. Listar en pantalla los datos de empleados que tengan un nombre o apellido
        //determinado, el cual se proporciona desde el teclado.
        //ii. Listar en pantalla los empleados de a uno por línea.
        //iii. Listar en pantalla los empleados mayores de 70 años, próximos a jubilarse.
//NOTA: El nombre del archivo a crear o utilizar debe ser proporcionado por el usuario
uses SysUtils;
const
    cortar_registro = 'fin';
    edad_jubilatoria = 70;
type
	opcion_elegida = 'a'..'f';
    str15 = String[15];
    empleado = record
    num_empleado : integer;
      apellido : str15;
      nombre : str15;
      edad : integer;
      dni : integer;
    end;
    archivo_empleados = file of empleado;
//Terminan los type

procedure imprimir_empleado(emple:empleado);
//imprime un empleado en una sola linea
begin
    writeln('--------------------------------');
    writeln('Nombre: ', emple.nombre, ' apellido: ',emple.apellido, ' dni: ',emple.dni,' edad: ',emple.edad, ' numero de empleado: ',emple.num_empleado);
    writeln('--------------------------------');
end;

procedure leerEmpleado(var emple:empleado);
begin
    writeln('ingrese el apellido del empleado');
    readln(emple.apellido);
    if(emple.apellido <> cortar_registro) then begin
        writeln('ingrese el nombre');
        readln(emple.nombre);
        writeln('ingrese el dni');
        readln(emple.dni);
        writeln('ingrese la edad');
        readln(emple.edad);
        writeln('ingrese el numero de empleado');
        readln(emple.num_empleado);
    end;
end;


procedure crearArchivo(nombre:String; var archivo:archivo_empleados);
// crea el archivo de empleados con el nombre recibido por parametro y empieza a su vez la carga de empleados
//la condicion de corte es el apellido 'fin'
var
    emple:empleado;
begin
    assign(archivo, nombre);
    rewrite(archivo);
    leerEmpleado(emple);
    while(emple.apellido <> cortar_registro) do begin
        // escribo el empleado en el archivo
        write(archivo, emple);
        writeln('carga del empleado exitosa');
        writeln('------ Siguiente empleado ------');
        leerEmpleado(emple);       
    end;
    close(archivo);
end;

procedure buscarDatosDeEmpleado(nombre_o_apellido:str15; var archivo:archivo_empleados);
// a partir de un nombre o apellido busca en el archivo de empleados un registro que cumpla con el requisito 
var 
    emple : empleado;
    encontre : boolean;
begin
    encontre := false;
    reset(archivo);
    // si no se termino el archivo o no encontre el nombre/apellido sigo el bucle 
    while  not EOF(archivo) and not(encontre) do begin
        read(archivo, emple);
        if (emple.apellido = nombre_o_apellido) or (emple.nombre = nombre_o_apellido) then begin
          imprimir_empleado(emple);
          encontre:=true;
        end;
    end;
    if not encontre then begin
      writeln('empleado no encontrado');
    end;
    close(archivo);
end;

procedure listarEmpleados(var archivo:archivo_empleados);
//lista todos los empleados dentro del archivo, cada empleado se imprime en una sola linea
var
    emple:empleado;
begin
    reset(archivo);
    while not EOF(archivo) do begin
       read(archivo, emple);
       imprimir_empleado(emple);
    end;
    close(archivo);
end;

procedure listarEmpleadosProximosAJubilarse(var archivo:archivo_empleados);
// lista todos los empleados proximos a jubilarse(se toma como empleado proximo a jubilarse el que sea mayor a 70 años)
var
    emple:empleado;
begin
    reset(archivo);
    while not EOF(archivo) do begin
        read(archivo, emple);
        if (emple.edad > edad_jubilatoria) then begin
            imprimir_empleado(emple);
        end;
    end;
    writeln('---- Fin de la lista ----');
end;

// salvo los procesos abrirArchivo y menuDeOpciones los siguientes procesos son del punto 4 de la pracita 1
// tienen su archivo aparte especifico hablando del ejercicio

function existeEmpleado(numero_buscado:integer; var archivo:archivo_empleados): boolean; //REVISAR
var
    emple : empleado;
    encontre : boolean;
begin
    encontre := false;
    reset(archivo);
    while (not EOF(archivo)) and (not encontre) do begin
        read(archivo, emple);
        if(emple.num_empleado = numero_buscado) then begin
            encontre := true; 
        end
    end;
    close(archivo);
    existeEmpleado := encontre;
    
end;
procedure anadirEmpleado(var archivo:archivo_empleados);
var
    emple_aux : empleado;
    emple : empleado;
    num_empleado_valido : boolean;
    posicion_final_archivo : integer;
begin
    //leo un empleado, y establezco que el final del archivo es 0, a modo de incializar la variable
    leerEmpleado(emple);
    posicion_final_archivo := 0;
    while (emple.apellido <> cortar_registro) do begin
        // si el empleado es valido me fijo si existe en el archivo
        num_empleado_valido := not (existeEmpleado(emple.num_empleado, archivo));
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
            write('---emlpeado cargado---');
            posicion_final_archivo := posicion_final_archivo + 1;
            close(archivo);
        end else begin
            writeln('numero de empleado invalido');
        end;
        leerEmpleado(emple);
    end;
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
        read(archivo, emple);
        if (emple.num_empleado = numero_empleado) then begin
            //encontre el empleado asi qeu procedo a pedir la edad y cambiarla
            writeln('ingrese la nueva edad del empleado');
            readln(edad);
            emple.edad := edad;
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
        linea := 'Nombre: ' + emple.nombre + ' apellido: ' + emple.apellido + ' dni: ' + IntToStr(emple.dni) + ' edad: ' + IntToStr(emple.edad) + ' numero de empleado: ' + IntToStr(emple.num_empleado);
        writeln(archivo_de_texto, linea);
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
            linea := 'Numero de empleado: ' + IntToStr(emple.num_empleado);
            write(archivo_de_dni, linea);
      end;
    end;
    close(archivo);
    close(archivo_de_dni);
end;

procedure abrirArchivo(var archivo:archivo_empleados);
// muestra las opciones a realizar con el archivo ya creado y llama al proceso correspondiente para resolver la situacion
var
    opcion : opcion_elegida;
    salida : boolean;
    apellido_o_nombre : str15;
    nombre_archivo: String;
begin
    writeln('ingrese el nombre del archivo');
    readln(nombre_archivo);
    assign(archivo, nombre_archivo);
    salida := false;
    while not salida do begin
        writeln('---- ingrese una opcion ----');
        writeln('a. listar datos de un empleado con nombre o apellido');
        writeln('b. listar los empleados');
        writeln('c. listar los empleados proximos a jubilarse');
        writeln('d. añadir empleado');
        writeln('e. modificar edad');
        writeln('f. Salir');
        readln(opcion);
        if (opcion = 'a') then begin
            writeln('ingrese el nombre o apellido');
            readln(apellido_o_nombre);
            buscarDatosDeEmpleado(apellido_o_nombre,archivo);
        end
        else if(opcion = 'b') then begin
            listarEmpleados(archivo);
        end
        else if (opcion = 'c') then begin
            listarEmpleadosProximosAJubilarse(archivo);
        end
        else if (opcion = 'd') then begin
            anadirEmpleado(archivo);
        end
        else if (opcion = 'e') then begin
            modificarEdad(archivo);
        end
        else if(opcion = 'f') then begin
            salida:=true;
        end
        else begin
          writeln('opcion incorrecta o inexistente');
        end;
    end;
end;

procedure menuDeOpciones();
// proceso para mostrar las opciones del menu, con el que se interactua con el archivo
var
    salida : boolean;
    opcion : String;
    archivo : archivo_empleados;
    nombre : String;
begin
    // variable habilitar la salida del menu, el algoritmo no contempla todavia la opcion de no abrir el archivo si no esta creado, peude fallar
    salida := false;
    while not salida do begin
    //bucle principal del menu
        writeln('a. Crear archivo binario para datos de empleados');
        writeln('b. Abrir archivo');
        writeln('c. Exportar arachivo a txt');
        writeln('d. Exportar a txt empleados sin dni');
        writeln('e. Salir');
        readln(opcion);
        if (opcion = 'a') then begin
            writeln('ingrese el nombre del archivo');
            readln(nombre);
            crearArchivo(nombre, archivo);
        end 
        else if(opcion = 'b') then begin
            abrirArchivo(archivo);
        end
        else if(opcion = 'c') then begin
            exportarATexto(archivo);
        end
        else if(opcion = 'd') then begin
            exportarEmpleadosSinDni(archivo);
        end
        else if (opcion = 'e') then begin
          salida:=true;
        end
        else begin
          writeln('opcion incorrecta, vuelva a intentarlo')
        end;

    end;

end;

//programa principal
begin
    menuDeOpciones();
end.
