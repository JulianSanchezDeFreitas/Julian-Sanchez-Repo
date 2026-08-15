program nombrePrograma;
const
    valor_alto = 9999;
type
    fecha = record
        dia : integer;
        mes : integer;
        anio : integer;
        end;
    sesion = record;
        codigo_usuario : integer;
        fecha : fecha;
        // lo modelo como tiempo en minutos
        tiempo_sesion : integer;
        end;

    archivo_sesiones = file of sesion;
    vector_detalles = array [1..5] of archivo_sesiones;
    vector_sesiones = array[1..5] of sesion;

procedure leer(var archivo : archivo_sesiones; var s : sesion);
begin
    if (not EOF(archivo)) then begin
        read(archivo, s);
    end
    else begin
        s.codigo_usuario := valor_alto;
    end;
end;
procedure minimo(var vectorD: vector_detalles;
                 var vectorS: vector_sesiones;
                 var min: sesion);
var
    i, pos: integer;
begin
    pos := -1;

    for i := 1 to 5 do
    begin
        if (vectorS[i].codigo_usuario <> valor_alto) then
        begin
            if (pos = -1) then
                pos := i
            else if (vectorS[i].codigo_usuario < vectorS[pos].codigo_usuario) then
                pos := i
            else if (vectorS[i].codigo_usuario = vectorS[pos].codigo_usuario) then
                if fechaMenor(vectorS[i].fecha, vectorS[pos].fecha) then
                    pos := i;
        end;
    end;

    if (pos = -1) then
        min.codigo_usuario := valor_alto
    else
    begin
        min := vectorS[pos];
        leer(vectorD[pos], vectorS[pos]);
    end;
end;

procedure procedimientoPedido(var vectorD : vector_detalles);
// falta agregar un proceso para comprar fechas ya que esta no es una forma valida de comprar registros en pascal
var
    minimo : sesion;
    maestro : archivo_sesiones;
    i : integer;
    vectorS : vector_sesiones;
    sesion_maestro : sesion;
begin
    assign(maestro, 'ubicacionPedida');
    rewrite(maestro);
    for i:=1 to 5 do begin
        reset(vectorD[i]);
        leer(vectorD[i], vectorS[i]);
    end;
    minimo(vectorD, vectorS, minimo);
    while (minimo.codigo_usuario <> valor_alto) do begin
        sesion_maestro.tiempo_sesion := 0;
        sesion_maestro.codigo := minimo.codigo_usuario;
        sesion_maestro.fecha := minimo.fecha;
        while((sesion_maestro.codigo = minimo.codigo_usuario) and (sesion_maestro.fecha = minimo.fecha)) do begin
            sesion_maestro.tiempo_sesion := sesion_maestro.tiempo_sesion + minimo.tiempo_sesion;
            minimo(vectorD, vectorS, minimo);
        end;
        write(maestro, sesion_maestro);
    end;
    for i:=1 to 5 do begin
        close(vector[i]);
    end;
    close(maestro);
end;
