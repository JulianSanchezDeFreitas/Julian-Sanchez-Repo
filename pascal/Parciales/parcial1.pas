const 
    GANANCIA_TOTAL = 10000;
type 
    aplicacion = record
        codigo : integer;
        nombre : String;
        precio_licencia : real;
        origen : String;
        cantidad_licencias_disponibles : integer;
        cantidad_minima_licencias : integer;
    end;

    venta = record;
        codigo : integer;
        cantidad_licencias : integer;
    end;
    vecor_registros = array [1..20] of venta;
    aplicaciones_maestro = file of aplicacion;
    ventas_detalle = file of venta;
    vector_detalles = array [1..20] of ventas_detalle;
    

procedure minimo(
    var vA : vector_detalles;
    var vR : vector_registros;
    var min : venta);

var
  i,posMin : integer;
begin
  min.codigo := valorAlto;
  posMin := -1;

  for i:=1 to dimF do
    if (vR[i].codigo < min.codigo) then begin
      min := vR[i];
      posMin := i;
    end;

  if (posMin <> -1) then
    leer(vA[posMin],vR[posMin]);
end;

procedure procesarDetalles (var vectorDetalles : vector_detalles, merge : ventas_detalle );
var
  vR : vectorRegistros;
  min : venta;
  regMerge : venta;
  codigoActual : integer;
  totalLicencias : integer;
  i : integer;
begin

  { abrir archivos }

  for i:=1 to dimF do begin
    reset(vector_detalles[i]);
    leer(vector_detalles[i],vR[i]);
  end;

  minimo(vector_detalles,vR,min);

  while (min.codigo <> valorAlto) do begin

    codigoActual := min.codigo;
    totalLicencias := 0;

    while (min.codigo = codigoActual) do begin
      totalLicencias := totalLicencias + min.cantidad_licencias;
      minimo(vA,vR,min);
    end;
    venta.codigo := codigoActual;
    venta.cantidad_licencias := min.cantidad_licencias;
    write(merge, venta);
  end;

  { cerrar archivos }

  for i:=1 to dimF do
    close(vector_detalles[i]);
end;

// programa principal
var
    vectorDetalles : vector_detalles;
    merge : ventas_detalle;
    maestro : aplicaciones_maestro;
begin
    // x20 assign a todos los archivo detalle
    assign(merge, 'merge.dat');
    assign(maestro, 'maestro.dat');
    rewrite(merge);
    reset(maestro);
    procesarDetalles(vectorDetalles, merge);
    actualizarMaestro(maestro, merge);
  
end.