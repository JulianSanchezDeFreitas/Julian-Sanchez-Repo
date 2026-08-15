program nombrePrograma;
const
    valor_alto = 9999;

type
    dia = 1..31;
    mes = 1..12;
    acceso = record
        dia : dia;
        mes : mes;
        anio : integer;
        ID : integer;
        tiempo_acceso : real;
    end;

    archivo_accesos = file of acceso;

procedure leer(var archivo : archivo_accesos; var a : acceso);
begin
    if not(EOF(archivo)) then begin
        read(archivo, acceso);
    end
    else begin
        a.anio := valor_alto;
    end;
end;

procedure imprimirEnPantalla(var archivo : archivo_accesos; anio : integer);
var
    acc : acceso;
    tiempo_acceso_usuario : real;
    tiempo_acceso_dia : real;
    tiempo_acceso_mes : real;
    tiempo_acceso_anio : real;
    id_actual : integer;
    dia_actual : dia;
    mes_actual : mes;
begin
    reset(archivo);
    leer(archivo, acceso);
    while(acc.anio < anio) do begin
        leer(archivo acc);
    end;
    if(acc.anio = anio) then begin
        tiempo_acceso_anio := 0;
        while (acc.anio = anio) do begin
            tiempo_acceso_mes := 0;
            mes_actual := acc.mes;
            while (acc.anio = anio) and (mes_actual = acc.mes) do begin
                tiempo_acceso_dia := 0;
                dia_actual := acc.dia;
                while (acc.anio = anio) and (mes_actual = acc.mes) and (dia = acc.dia) do begin
                    tiempo_acceso_usuario := 0;
                    id_actual := acc.ID;
                    while((acc.anio = anio) and (mes_actual = acc.mes) and (dia_actual = acc.dia) and (id_actual = acc.ID)) do begin
                        tiempo_acceso_usuario := tiempo_acceso_usuario + acc.tiempo_acceso;
                        leer(archivo, acc);
                    end;
                    writeln('IdUsuario: ', id_actual, ' tiempo total de acceso en el dia: ', dia_actual, ' mes: ', mes_actual,' = ', tiempo_acceso_usuario )
                    tiempo_acceso_dia := tiempo_acceso_dia + tiempo_acceso_usuario;
                end;
                writeln('tiempo total de acceso del dia: ', dia_actual, ' mes : ', mes_actual, ' = ', tiempo_acceso_dia);
                tiempo_acceso_mes := tiempo_acceso_mes + tiempo_acceso_dia; 
            end;
            writeln('tiempo de acceso del mes', mes_actual ,' = ', tiempo_acceso_mes);
            tiempo_acceso_anio := tiempo_acceso_anio + tiempo_acceso_mes;
        end;
        writeln('tiempo de acceso de año', anio, ' = ', tiempo_acceso_anio);
    end;
    else    
        writeln('año no encontrado');
    
    close(archivo);
    writeln('fin de analisis');
end;
// programa principal
var
    // el archivo se encuentra ordenado por año, mes, dia y por ultimo id
    archivo : archivo_accesos;
    anio : integer;
    existe : boolean;
    nombre : string;
begin
    existe := false;
    writeln('ingrese el nombre del archivo: ');
    readln(nombre);
    assign(archivo, nombre);
    writeln('ingrese el año a buscar: ');
    readln(anio);
    imprimirEnPantalla(archivo, anio);
end.
