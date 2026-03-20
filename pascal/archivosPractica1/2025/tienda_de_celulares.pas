program ejercicio5;
type
    str20 = string[20]
    str50 = string[50]

    registro_celular = record;
        cod_celular : integer;
        nombre : str20
        descripcion : str50
        marca : str20
        precio : real
        stock_minimo : integer
        stock_actual : integer
        end;

    archivo_celulares = file of registro_celular;

procedure menu_de_opciones(salir:boolean);
    var
        opcion:integer;
    begin
        writeln('______Menu de opciones_____');
        writeln('- opcion 1');
        writeln('- opcion 2');
        writeln('- opcion 3');
        writeln('- opcion 4');
        writeln('- ingrese una opcion');
        readln(opcion);
        case opcion of
        1: ;
        2: ;
        3: ;
        4: ;
        5: salir:=true; 
  
    end;
// programa principal

var
    salir : boolean;
begin
    salir := false;
  while (salir = false) do begin
    menu_de_opciones(salir);  
  end;
end.