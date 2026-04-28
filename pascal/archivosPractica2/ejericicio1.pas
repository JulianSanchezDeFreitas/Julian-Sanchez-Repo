program ejercicio1;

type
str5 = String[5];
  empleado = record
    codigo : integer;
    nombre : str5;
    monto_comision : integer;
  end;

archivo_de_empleados = file of empleado;

function randomStr(): string;
var 
    i:integer;
    nombre:string;
begin
Randomize;
for i := 1 to 5 do
    nombre := chr(random (127-32)+32);
randomStr:=nombre;
end;

procedure crearArchivo(var archivo:archivo_de_empleados);
var 
    codigo : integer;
    emple : empleado;
begin
    reset(archivo);
    Randomize;
    write('ingrese un codigo');
    readln(codigo);
    while (codigo <> -1) do begin
      emple.codigo := codigo;
      emple.nombre := 'rando';
      emple.monto_comision := random(15);
      write(archivo, emple);
      write('ingrese un codigo');
      readln(codigo);
    end;
    close(archivo);
end;

procedure compactarArchivo(var archivo: archivo_de_empleados; var ac:archivo_de_empleados);
var
    emple : empleado;
    codigo_actual : integer;
    suma : integer;
    pos : integer;
    nuevo : empleado;
begin
  reset(archivo);
  reset(ac);
  read(archivo,emple);
  while not EOF(archivo) do begin
    suma:=0;
    codigo_actual := emple.codigo;
    nuevo.codigo := emple.codigo;
    nuevo.nombre := emple.nombre;
    while not EOF(archivo) and (emple.codigo = codigo_actual) do begin
      suma := suma + emple.monto_comision;
      read(archivo, emple);
    end;
    nuevo.monto_comision := suma;
    write(ac, nuevo);
  end;
  close(archivo);
  close(ac);
  
end;

procedure exportar(var archivo:archivo_de_empleados; num:integer);
var
    salida_archivo : Text;
    emple : empleado;
begin
  if num = 1 then begin
    Assign(salida_archivo, 'empleadosExp.txt')
	end
    else begin
      Assign(salida_archivo, 'empleadosExp_comp.txt');
	end;
  reset(archivo);
  Rewrite(salida_archivo);
  while not EOF(archivo) do begin
    read(archivo, emple);
    Writeln(salida_archivo, emple.codigo, ' ; ', emple.nombre, ' ; ', emple.monto_comision);
    Writeln(salida_archivo, '---------------------------------------------'); 

  end;

  close(salida_archivo);
  close(archivo);
end;


var
    archivo: archivo_de_empleados;
    archivo_compacto : archivo_de_empleados;
begin
  assign(archivo_compacto, 'archivoCompacto.dat');
  assign(archivo, 'archivoEmpleados.dat');
  rewrite(archivo_compacto);
  rewrite(archivo);
  crearArchivo(archivo);
  compactarArchivo(archivo, archivo_compacto);
  exportar(archivo, 1);
  exportar(archivo_compacto, 4);
end.
