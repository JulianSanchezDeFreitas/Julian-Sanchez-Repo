// Procedimiento auxiliar para evitar desbordar el EOF
procedure LeerDetalle(var archD: tArchDetalle; var regD: tVenta; var valMax: integer);
begin
  if not Eof(archD) then
    Read(archD, regD)
  else
    regD.codigo := valMax; // Si terminó, le asignamos un número altísimo (p.ej. 9999)
end;

procedure ActualizarMaestroSeguro(var archM: tArchMaestro; var archD: tArchDetalle);
var
  regM: tProducto;
  regD: tVenta;
  cantTotalVendida, codActual, VALOR_ALTO: integer;
begin
  VALOR_ALTO := 9999; // Un código que jamás existirá
  Reset(archM);
  Reset(archD);

  LeerDetalle(archD, regD, VALOR_ALTO);

  while (regD.codigo <> VALOR_ALTO) do
  begin
    codActual := regD.codigo;
    cantTotalVendida := 0;

    // Este bucle ahora procesa TODAS las ventas de este código de forma segura
    while (regD.codigo = codActual) do 
    begin
      cantTotalVendida := cantTotalVendida + regD.cantidad;
      LeerDetalle(archD, regD, VALOR_ALTO); // Avanza seguro
    end;

    // Buscar y actualizar en el maestro
    Read(archM, regM);
    while regM.codigo <> codActual do
      Read(archM, regM);

    regM.stockActual := regM.stockActual - cantTotalVendida;
    Seek(archM, FilePos(archM) - 1);
    Write(archM, regM);
  end;

  Close(archM); Close(archD);
end;