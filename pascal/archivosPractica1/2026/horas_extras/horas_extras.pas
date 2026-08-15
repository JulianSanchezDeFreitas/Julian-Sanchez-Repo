program nombrePrograma;
const 
    valor_alto = 'ZZZ';
type
        str15 = string[15];
		CATEGORIA = 1..15;
        empleado = record
            departamento : str15;
            division : str15;
            numero : integer;
            categoria : CATEGORIA;
            horas_extras : integer;
        end;
        archivo_empleados = file of empleado;
        vector_categorias = array[CATEGORIA] of real;
procedure leer(var archivo:archivo_empleados; var empleado : empleado);
 
begin
    if not(EOF(archivo)) then begin
        read(archivo, empleado);
    end
    else begin
      empleado.departamento := valor_alto;
    end;
end;

procedure presentarListadoEnPantalla(var archivo:archivo_empleados; vector : vector_categorias);
var
    emple : empleado;
    horas_division : integer;
    monto_division : real;
    horas_departamento : integer;
    monto_departamento : real;
    departamento_actual : string;
    division_actual : string;
    importe : real;
begin
    importe := 0;
    reset(archivo);
    leer(archivo, emple);
    while (emple.departamento <> valor_alto) do begin
        horas_departamento := 0;
        monto_departamento := 0;
        departamento_actual := emple.departamento;
        writeln(departamento_actual);
        while (emple.departamento = departamento_actual)do begin
            horas_division := 0;
            monto_division := 0;
            division_actual := emple.division;
            writeln(division_actual);
            while((emple.departamento = departamento_actual) and (division_actual = emple.division)) do begin
                importe := emple.horas_extras * vector[emple.categoria];
                writeln('numero empleado: ',emple.numero,' horas: ',emple.horas_extras, ' importe: ',importe:0:2);
                horas_division := horas_division + emple.horas_extras;
                monto_division := monto_division + importe;
                leer(archivo, emple);
            end;
            writeln('Horas de division: ', horas_division,' monto division: ' ,monto_division:0:2);
            horas_departamento := horas_departamento + horas_division;
            monto_departamento := monto_departamento + monto_division
        end;
        writeln('horas departamento: ',horas_departamento,'monto departamento: ', monto_departamento:0:2);

    end;
    close(archivo);
end;

procedure asignarValoresAVector(var archivo:text; var vector : vector_categorias);
var
    numero_categoria : integer;
    valor : real;
    i : integer;
begin
    reset(archivo);
    for i:=1 to 15 do begin
        readln(archivo, numero_categoria, valor);
        vector[numero_categoria] := valor;
    end;
    writeln('vector cargado correctamente');
    close(archivo);
end;
// programa principal
var
    archivo : archivo_empleados;
    archivo_valores : text;
    nombre_archivo_empleados : string;
    nombre_archivo_valores : string;
    valores_categorias : vector_categorias;
begin
    write('ingrese el nombre del archivo de empleados: ');
    readln(nombre_archivo_empleados);
    assign(archivo, nombre_archivo_empleados);
    write('ingrese el nombre del archivo que contiene los valores por hora de cada categoria: ');
    readln(nombre_archivo_valores);
    assign(archivo_valores, nombre_archivo_valores);
    asignarValoresAVector(archivo_valores, valores_categorias);
    presentarListadoEnPantalla(archivo, valores_categorias);
    
end.
