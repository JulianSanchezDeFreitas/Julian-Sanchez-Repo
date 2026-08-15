program bajas_en_secuencial;
type 
    libro = record
        codigo : integer;
        genero : string;
        autor  : string;
        cantidad_paginas : integer;
        precio : real;
    end;

    archivo_libros = file of libro;

procedure leer(var archivo : archivo_libros, var libro : libro);
begin
  if (EOF(archivo)) then begin
        libro.codigo := 999;
  end;
  else begin
    read(archivo, libro);
  end;
end;

procedure leerLibro(var l: libro);
begin
    writeln('Ingrese el codigo del libro (-1 para finalizar): ');
    readln(l.codigo);

    if (l.codigo <> -1) then
    begin
        writeln('Ingrese el genero: ');
        readln(l.genero);

        writeln('Ingrese el autor: ');
        readln(l.autor);

        writeln('Ingrese la cantidad de paginas: ');
        readln(l.cantidad_paginas);

        writeln('Ingrese el precio: ');
        readln(l.precio);
    end;
end;

procedure inicializarArchivo(var archivo: archivo_libros, libro : libro);
begin
    rewrite(archivo);
    libro.codigo := 0;
    libro.genero := 'nulo';
    libro.autor := 'nulo';
    libro.cantidad_paginas := '-1';
    libro.precio := '-1';
    write(archivo, libro);
end;

procedure creacionYCarga(var archivo : archivo_libros);
var
    libro : libro;
    nombre : string;
begin
    writeln('ingrese el nombre del archivo a crear: ');
    readln(nombre);
    assign(archivo, nombre);
    inicializarArchivo(archivo);
    writeln('>>inicia la carga<<');
    leerLibro(libro);
    while (libro.codigo <> -1) do begin
        write(archivo, libro)
        leerLibro(libro);
    end;
    writeln('<<finaliza la carga>>');
end;

procedure agregarLibro(var archivo: archivo_libros);
var
    libro : libro;
    cabecera : libro;
    aux : libro;
begin
    reset(archivo);
    readln(archivo, cabecera);
    leerLibro(libro);
    if (cabecera.codigo = 0) then begin
      while(not EOF(archivo)) do begin
        read(libro, archivo);
      end;
      write(archivo, libro);
    end;
    else begin
        seek(archivo, cabecera.codigo * -1);
        read(archivo, aux);
        cabecera.codigo := aux.codigo;
        seek(archivo, filePos(archivo) - 1);
        write(archivo, libro);
        seek(archivo, 0);
        write(archivo, cabecera);
    end;
end;

procedure modificarLibro(var archivo : archivo_libros);
var
    codigo : integer;
    libro : libro;
begin
    reset(archivo);
    writeln('ingrese le numero de libro a modificar: ');
    readln(codigo);
    leer(archivo, libro);
    while (not (libro.codigo = 999) and (codigo <> libro.codigo)) do begin
        leer(archivo, libro);
    end;
    if (libro.codigo = 999) then begin
        writeln(' libro no encontrado');
    end; else begin
        writeln('----modificando libro ingrese los datos: ');
        leerLibro(libro);
        seek(archivo, filePos(archivo) - 1);
        write(archivo, libro);
    end;
end;

procedure eliminarLibro(var archivo : archivo_libros);
var
    codigo : integer;
    cabecera : libro;
begin
    writeln('ingrese el codigo de libro a eliminar');
    readln(codigo);
    leer(archivo, cabecera);
    leer(archivo, libro);
    while ((libro.codigo <> 999) and (libro.codigo <> codigo)) do begin
        leer(archivo, libro);
    end;
    if (libro.codigo = 999) then begin
        writeln('--¡--el codigo no existe--!--');
    end;
    else begin
        libro.codigo := cabecera.codigo;
        cabecera.codigo := (filePos(archivo) - 1) * (-1);
        seek(archivo, filePos(archivo) - 1);
        write(archivo, libro);
        seek(archivo, 0);
        write(archivo, cabecera);
    end;
end;

procedure generarModificaciones(var archivo :archivo_libros);
var
    opcion : string;
    volver : boolean;
begin
    writeln('ingrese el nombre del archivo a modificar: ');
    readln(nombre);
    assign(archivo, nombre);
    volver := false;
    writeln('ingrese una opcion parar realizar modificaciones en el archivo: ');
    writeln('a. agregar un libro');
    writeln('b. modificar un libro');
    writeln('c. eliminar');
    writeln('d. volver');
    if (opcion = 'a') then begin
            agregarLibro(archivo);
        end;
        else if (opcion = 'b') then begin
            modificarLibro(archivo);
        end;
        else if (opcion = 'c') then begin
            eliminarLibro(archivo);
        end;
        else if (opcion = 'd')then begin
            volver := true;
        end;
        else begin
          writeln('|¡|opcion invalida vuelva a intentar|!|')
        end;
end;
procedure exportar(var archivo : archivo_libros);
var
    archivo_texto : text;
    libro : libro;
    linea : string;
begin
    reset(archivo);
    assign(archivo_texto, 'libros.txt');
    leer(archivo, libro);
    leer(archivo, libro);
    while(libro.codigo <> 999) do begin 
        linea := libro.autor , libro.codigo, libro.precio;
        writeln(archivo_texto, linea)
    end;
end;
procedure menu(var archivo : archivo_libros);
var
    opcion : string;
    salida : boolean;
begin

    salida := false;
    while (salida = false) do begin
        writeln('------ | MENU | ------');
        writeln('a. cargar y crear el archivo');
        writeln('b. abrir archivo ; dar de alta/baja/modificar libros');
        writeln('c. exportar a texto');
        writeln('d. salir');
        writeln('----------------------------------');
        writeln('ingrese la opcion que necesite: ');
        readln(opcion);
        if (opcion = 'a') then begin
            creacionYCarga(archivo);
        end;
        else if (opcion = 'b') then begin
            generarModificaciones(archivo);
        end;
        else if (opcion = 'c') then begin
            exportar(archivo);
        end;
        else if (opcion = 'd')then begin
            salida := true;
        end;
        else begin
          writeln('|¡|opcion invalida vuelva a intentar|!|')
        end;
    end;


end;


// programa principal
var
    archivo : archivo_libros;
begin
    menu(archivo);
end.
