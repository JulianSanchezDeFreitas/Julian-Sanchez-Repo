program prueba;
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


//programa principal

var
    carga:archivo_de_empleados;
    nuevo:Text;
    emple:empleado;
begin
    assign(carga, 'C:\Users\Julian\Desktop\FOD\archivosPractica1\empleados.dat');
    assign(nuevo, 'C:\Users\Julian\Desktop\FOD\archivosPractica1\textoEmple.txt');
    reset(carga);
    rewrite(nuevo);
    while(not EOF(carga))do begin
        read(carga, emple);
        write(nuevo, emple.ape ,' ; ');
        end;
close(carga);
close(nuevo);
end.
