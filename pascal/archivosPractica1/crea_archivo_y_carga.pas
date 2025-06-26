program ejercicio3;
type
str20 = string[20];

empleado = record
	numero_emp:integer;
	ape : str20;
	nom : str20;
	edad : integer;
	dni : integer;
	end;
	
archivo_de_empleados = file of empleado;

procedure Leer(var e:empleado);
begin 
	writeln('ingrese un apellido: ');
	read(e.ape);
	if (e.ape <> 'fin') then begin
	  writeln('ingrese un numero de empleado:  ');
	  readln(e.numero_emp);
	  writeln('ingrese un nombre:  ');
	  readln(e.nom);
	  writeln('ingrese una edad:  ');
	  readln(e.edad);
	  writeln('ingrese un dni:  ');
	  readln(e.dni);
	end;

end;
procedure print_empleado(e:empleado);
begin
  writeln('---Empleado---');
  writeln(e.nom);
  writeln(e.ape);
  writeln(e.numero_emp);
  writeln(e.dni);
  writeln(e.edad);
  writeln('---------------------')
end;

procedure imprimir_archivo(var archivo : archivo_de_empleados);
var
	em:empleado;
begin
	reset(archivo);
	while(not EOF(archivo)) do begin
		read(archivo, em);
		print_empleado(em);
	end;
end;
//programa principal
var
	archivo:archivo_de_empleados;
	emple : empleado;

begin
	assign(archivo, 'C:\Users\Julian\Desktop\carpetas\FOD\archivosPractica1\empleados.dat');
	rewrite(archivo);
	Leer(emple);
	while (emple.ape <> 'fin') do begin
		write(archivo, emple);
		Leer(emple);
	end;
	imprimir_archivo(archivo);
	close(archivo);
end.
