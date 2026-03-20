program programa2;
const 
	num_comparable = 1500;

var 
	nombre_archivo : String;
	carga : file of integer;
	num:integer;
	pos : integer;
begin
writeln('ingrese el nombre del archivo: ');
readln(nombre_archivo);
assign(carga , nombre_archivo);
reset(carga);
writeln('agregue un numero nuevo al archivo');
readln(num);
pos:=filesize(carga);
seek(carga, pos);
write(carga, num);
reset(carga);
while(not EOF(carga))do begin
	read(carga, num);
	if(num<1500) then
		write(num,' - ');
		
	end;
close(carga);
end.

