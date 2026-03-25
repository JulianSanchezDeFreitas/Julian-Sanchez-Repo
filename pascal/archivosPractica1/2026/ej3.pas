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

const
    cortar_registro = 'fin';
    edad_jubilatoria = 70;
type
    str15 = String[15];
    empleado = record
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
    writeln('Nombre: ', emple.nombre, ' apellido: ',emple.apellido, ' dni: ',emple.dni,' edad: ',emple.edad);
    writeln('--------------------------------');
end;
procedure crearArchivo(nombre:String; var archivo:archivo_empleados);
// crea el archivo de empleados con el nombre recibido por parametro y empieza a su vez la carga de empleados
//la condicion de corte es el apellido 'fin'
var
    emple:empleado;
begin
    assign(archivo, nombre);
    rewrite(archivo);
    writeln('ingrese el apellido del empleado');
    readln(emple.apellido);
    while(emple.apellido <> cortar_registro) do begin
        writeln('ingrese el nombre');
        readln(emple.nombre);
        writeln('ingrese el dni');
        readln(emple.dni);
        writeln('ingrese la edad');
        readln(emple.edad);
        // escribo el empleado en el archivo
        write(archivo, emple);
        writeln('carga del empleado exitosa');
        writeln('------ Siguiente empleado ------');
        writeln('ingrese el apellido del empleado');
        readln(emple.apellido);       
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


procedure abrir_archivo(var archivo:archivo_empleados);
// muestra las opciones a realizar con el archivo ya creado y llama al proceso correspondiente para resolver la situacion
var
    opcion : String;
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
        writeln('d. Salir');
        readln(opcion);
        if (opcion = 'a') then begin
            writeln('ingrese el nombre o apellido');
            readln(apellido_o_nombre);
            buscarDatosDeEmpleado(apellido_o_nombre,archivo);
        end
        else if(opcion='b') then begin
            listarEmpleados(archivo);
        end
        else if (opcion='c') then begin
            listarEmpleadosProximosAJubilarse(archivo);
        end
        else if(opcion='d') then begin
            salida:=true;
        end
        else begin
          writeln('opcion incorrecta o inexistente');
        end;
    end;
end;

procedure menu_de_opciones();
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
        writeln('c. Salir');
        readln(opcion);
        if (opcion='a') then begin
            writeln('ingrese el nombre del archivo');
            readln(nombre);
            crearArchivo(nombre, archivo);
        end 
        else if(opcion='b') then begin
            abrir_archivo(archivo);
        end
        else if (opcion='c') then begin
          salida:=true;
        end
        else begin
          writeln('opcion incorrecta, vuelva a intentarlo')
        end;

    end;

end;

//programa principal
begin
    menu_de_opciones();
end.
