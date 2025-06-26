program ejercicio3p2;
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

procedure apellido_determinado(var carga:archivo_de_empleados; apellido:str20);
var
    emple : empleado;

begin
    reset(carga);
    while(not EOF(carga)) do begin
        read(carga, emple);
        if(emple.ape = apellido)then
            writeln('apellido: ', emple.ape) 
    end;
    close(carga);
end;

procedure pronto_jubilarse(var carga:archivo_de_empleados);
var
    emple:empleado;
begin
    reset(carga);
    while (not( EOF(carga)))do begin
        read(carga, emple);
        if (emple.edad>70) then
            writeln('el empleado ',emple.ape , ' se puede jubilar');

        end;

end;
//programa principal
var
    carga : archivo_de_empleados;
    apellido:str20;
begin
    assign(carga, 'C:\Users\Julian\Desktop\carpetas\FOD\archivosPractica1\empleados.dat');
    reset(carga);
    read(apellido);
    apellido_determinado(carga, apellido);
    pronto_jubilarse(carga);

end.