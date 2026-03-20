program programa1;



type
	mi_archivo = file of integer;
	
//programa principal
var
	nombre_archivo : String;
	archivo : mi_archivo;
	num:integer;
begin
writeln('ingrese el nombre del archivo');
readln(nombre_archivo);
assign(archivo , nombre_archivo);
rewrite(archivo);
writeln('ingrese un numero: ');
readln(num);
	
while(num <> 3000) do begin
	write(archivo, num);
	writeln('ingrese un numero: ');
	readln(num);	
	end;
close(archivo);
end.
