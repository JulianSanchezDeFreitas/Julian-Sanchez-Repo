//Realizar un algoritmo que cree un archivo binario de números enteros no ordenados y permita
//incorporar datos al archivo. Los números son ingresados desde el teclado. La carga finaliza
//cuando se ingresa el número 30000, que no debe incorporarse al archivo. El nombre del archivo
//debe ser proporcionado por el usuario desde el teclado.s
type
    arch_numeros = file of integer;
//programa principal
var
    numero : integer;
    nombre_archivo : String;
    arch : arch_numeros;
begin
    nombre_archivo := 'c:\Users\Julian\Desktop\repositorio\pascal\archivosPractica1\2026\archivoDeNumerosEnteros.dat';
    assign(arch, nombre_archivo);
    rewrite(arch);
    writeln('escribe un numero');
    read(numero);    
    while(numero <> 3000) do begin
        write(arch, numero);
        writeln('escribe un numero');
        read(numero);
    end;
	close(arch);
end.
