program TiendaCelulares;

type
  Celular = record
    codigo: integer;
    nombre: string[50];
    descripcion: string[100];
    marca: string[30];
    precio: integer;
    stockMin: integer;
    stockDisp: integer;
  end;

  ArchivoCelulares = file of Celular;

var
  archivo: ArchivoCelulares;
  nombreArchivo: string;

procedure CrearArchivoDesdeTexto(var arch: ArchivoCelulares; nombreX: string);
var
  txt: Text;
  cel: Celular;
  cod:integer;
  precio: integer;
  marca :string[30];
  stockDisp : integer;
  stockMin : integer;
  descripcion : string[100];
  nombre : string[50];
begin
  Assign(txt, 'celularesB.txt');
  Reset(txt);

  Assign(arch, nombreX);
  Rewrite(arch);

  while not EOF(txt) do
  begin

    Readln(txt, cod, precio, marca);
    Writeln(cod, precio);
    Readln(txt, stockDisp, StockMin, descripcion);
    Readln(txt, nombre);
    
    //asignaciones al registro
    cel.codigo:= cod;
    cel.precio:= precio;
    cel.marca:= marca;
    cel.stockDisp:= stockDisp;
    cel.stockMin:= stockMin;
    cel.descripcion:= descripcion;
    cel.nombre:= nombre;

    Write(arch, cel);
  end;

  Close(txt);
  Close(arch);
  Writeln('Archivo binario creado con éxito.');
end;

procedure ListarStockBajo(var arch: ArchivoCelulares);
var
  cel: Celular;
begin
  Reset(arch);
  Writeln('Celulares con stock menor al mínimo:');
  while not EOF(arch) do
  begin
    Read(arch, cel);
    if cel.stockDisp < cel.stockMin then
    begin
      Writeln('Código: ', cel.codigo);
      Writeln('Nombre: ', cel.nombre);
      Writeln('Marca: ', cel.marca);
      Writeln('Precio: ', cel.precio);
      Writeln('Stock disponible: ', cel.stockDisp, ' | Stock mínimo: ', cel.stockMin);
      Writeln('Descripción: ', cel.descripcion);
      Writeln('-------------------------------');
    end;
  end;
  Close(arch);
end;

procedure leerCel(var cel:celular);
begin
  writeln('ingrese un nombre');
  Readln(cel.nombre);
  writeln('ingrese un codigo');
  Readln(cel.codigo);
  writeln('ingrese un precio');
  Readln(cel.precio);
  writeln('ingrese una descripcion');
  Readln(cel.descripcion);
  writeln('ingrese una marca');
  Readln(cel.marca);
  writeln('ingrese un stock minimo');
  Readln(cel.stockMin);
  writeln('ingrese un stock disponible');
  Readln(cel.stockDisp);

end;
procedure BuscarPorDescripcion(var arch: ArchivoCelulares);
var
  cel: Celular;
  cadena: string;
begin
  Write('Ingrese la cadena a buscar en la descripción: ');
  Readln(cadena);
  Reset(arch);
  Writeln('Resultados de la búsqueda:');
  while not EOF(arch) do
  begin
    Read(arch, cel);
    if cadena = cel.descripcion then
    begin
      Writeln('Código: ', cel.codigo);
      Writeln('Nombre: ', cel.nombre);
      Writeln('Marca: ', cel.marca);
      Writeln('Precio: ', cel.precio);
      Writeln('Stock disponible: ', cel.stockDisp, ' | Stock mínimo: ', cel.stockMin);
      Writeln('Descripción: ', cel.descripcion);
      Writeln('-------------------------------');
    end;
  end;
  Close(arch);
end;

procedure ExportarATexto(var arch: ArchivoCelulares);
var
  txt: Text;
  cel: Celular;
begin
  Assign(txt, 'celulares.txt');
  Rewrite(txt);

  Reset(arch);
  while not EOF(arch) do
  begin
    Read(arch, cel);
    Writeln(txt, cel.codigo, ' ', cel.precio, ' ', cel.marca);
    Writeln(txt, cel.stockDisp, ' ', cel.stockMin, ' ', cel.descripcion);
    Writeln(txt, cel.nombre);
  end;
  Close(arch);
  Close(txt);
  Writeln('Archivo exportado a "celulares.txt".');
end;

procedure MostrarMenu;
begin
  Writeln;
  Writeln('--- Menú de opciones ---');
  Writeln('1. Crear archivo binario desde "celulares.txt"');
  Writeln('2. Listar celulares con stock bajo');
  Writeln('3. Buscar celulares por descripción');
  Writeln('4. Exportar archivo binario a "celulares.txt"');
  Writeln('5. Añadir celulares al archivo');
  Writeln('6. Modificar stock de un celular');
  Writeln('7. Exportar celulares sin stock en "SinStock.txt"');
  Writeln('8. Salir');
  Writeln;
end;

procedure aniadirCelulares(var archivo:ArchivoCelulares);
var
  cel:celular;
begin
    Reset(archivo);
    leerCel(cel);
    seek(archivo, filesize(archivo));
    while (cel.codigo<>-1) do begin
      write(archivo, cel);
      leerCel(cel);
    end;
    close(archivo);
end;

procedure modificarStock(var archivo:ArchivoCelulares);
var
    unCelular: celular;
    codigo : integer;
    stockNuevo : integer;
    pos : integer;
    encontre : boolean;
begin
  encontre := false;
  writeln('ingrese un codigo para modificar el stock: ');
  readln(codigo);
  reset(archivo);
  while (not EOF(archivo)) and (not (encontre)) do
  begin
    read(archivo, unCelular);
    if (unCelular.codigo = codigo) then
    begin
      writeln('Celular encontrado!');
      writeln('ingrese el nuevo stock del celular');
      readln(stockNuevo);
      unCelular.stockDisp := stockNuevo;
      pos:= filePos(archivo)-1;
      seek(archivo, pos);
      write(archivo, unCelular);
      encontre := true;
    end;
    
  end;
  if (encontre = false) then
    writeln('no se encontro el celular');
  close(archivo);
end;

// a continuar

procedure exportarSinStock(var archivo:ArchivoCelulares);
var
    salida_archivo : Text;
    cel : celular;
begin
  Assign(salida_archivo, 'sinStock.txt');
  reset(archivo);
  Rewrite(salida_archivo);
  while not EOF(archivo) do begin
    read(archivo, cel);
    if (cel.stockDisp = 0) then begin
      Writeln(salida_archivo, cel.codigo, ' ', cel.precio, ' ', cel.marca);
      Writeln(salida_archivo, cel.stockDisp, ' ', cel.stockMin, ' ', cel.descripcion);
      Writeln(salida_archivo, cel.nombre);
    end;

  end;
  close(salida_archivo);
  close(archivo);
end;



var
  opcion: char;

begin
  Write('Ingrese el nombre del archivo binario de celulares: ');
  Readln(nombreArchivo);
  repeat
    MostrarMenu;
    Write('Seleccione una opción: ');
    Readln(opcion);
    Assign(archivo, nombreArchivo);
    case opcion of
      '1': CrearArchivoDesdeTexto(archivo, nombreArchivo);
      '2': begin
             ListarStockBajo(archivo);
           end;
      '3': begin
             BuscarPorDescripcion(archivo);
           end;
      '4': begin
             ExportarATexto(archivo);
           end;
      '5': begin
             aniadirCelulares(archivo);
           end;
      '6': begin
             modificarStock(archivo);
           end;
      '7': begin
             exportarSinStock(archivo);
           end;
    end;
  until opcion = '8';
end.
