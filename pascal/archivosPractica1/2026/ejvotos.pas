const
    valor_alto = 9999;
type
    votos_en_mesa = record
      cod_provincia : integer;
      cod_localidad : integer;
      numero_nesa : integer;
      cant_votos : integer;     
    end;

    archivo_votos = file of votos_en_mesa; 

procedure leer(var archivo : archivo_votos; var votos : votos_en_mesa);
begin
    if not(EOF(archivo)) then begin
        read(archivo, votos);
    end
    else begin
      votos.cod_provincia := valor_alto;
    end;
end;

procedure procesarArchivo(var archivo:archivo_votos);
var
    reg_votos : votos_en_mesa;
    localidad_actual : integer;
    provincia_actual : integer;
    total_votos_provincia : integer;
    total_votos_localidad : integer;
    total_votos : integer;
begin
    total_votos := 0;
    reset(archivo);
    leer(archivo, reg_votos);
    while (reg_votos.cod_provincia <> valor_alto) do begin
        writeln('codigo de provincia ' , reg_votos.cod_provincia);
        total_votos_provincia := 0;
        provincia_actual := reg_votos.cod_provincia;
        while (reg_votos.cod_provincia = provincia_actual)do begin  
        total_votos_localidad := 0;
        localidad_actual := reg_votos.cod_localidad;
            while ((reg_votos.cod_provincia = provincia_actual) and (localidad_actual = reg_votos.cod_localidad)) do begin
                total_votos_localidad:= total_votos_localidad + reg_votos.cant_votos;
                leer(archivo, reg_votos);
            end;
        writeln('de la localidad ', localidad_actual, 'se tienen ',total_votos_localidad, ' votos');
        total_votos_provincia := total_votos_provincia + total_votos_localidad;
        end;
        writeln('total votos provincia ', total_votos_provincia);
        total_votos := total_votos + total_votos_provincia;
    end;
    writeln('--------total votos general------------- ', total_votos);
    close(archivo);
end;

    // programa principal
var
    archivo : archivo_votos;
    nombre_archivo : String;
begin
    write('ingrese nombre de archivo ');
    readln(nombre_archivo);
    assign(archivo, nombre_archivo);
    procesarArchivo(archivo);
end.
