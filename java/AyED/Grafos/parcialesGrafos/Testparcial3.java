package parcialesGrafos;

import java.util.List;

import grafoListAdy.AdjListGraph;
import grafosInterface.Graph;
import grafosInterface.Vertex;

public class Testparcial3 {
    
    public static void main(String[] args) {
        //creacion de personas y grafo
        Graph<Persona> mapa = new AdjListGraph<>();
        Persona empleado = new Empleado("inspector", "buenos aires");       
        Persona jubilado1 = new Jubilado("juan", "bogota");
        Persona jubilado2 = new Jubilado("María", "Córdoba");
        Persona jubilado3 = new Jubilado("Luis", "Rosario");
        Persona jubilado4 = new Jubilado("Ana", "Quito");
        Persona jubilado5 = new Jubilado("Pedro", "Valparaíso");
        Persona jubilado6 = new Jubilado("Carmen", "Lima");
        Persona jubilado7 = new Jubilado("Jorge", "Montevideo");
        Persona jubilado8 = new Jubilado("Lucía", "Arequipa");
        Persona jubilado9 = new Jubilado("Raúl", "Salta");
        Persona jubilado10 = new Jubilado("Marta", "Cusco");
        Persona jubilado11 = new Jubilado("Sergio", "Iquique");
        Persona jubilado12 = new Jubilado("Elena", "Temuco");
        Persona jubilado13 = new Jubilado("Carlos", "Popayán");
        Persona jubilado14 = new Jubilado("Isabel", "Trujillo");
        Persona jubilado15 = new Jubilado("Eduardo", "Neuquén");
        Persona jubilado16 = new Jubilado("Patricia", "Rancagua");
        Persona jubilado17 = new Jubilado("Fernando", "Ambato");
        Persona jubilado18 = new Jubilado("Rosa", "Bariloche");
        Persona jubilado19 = new Jubilado("Gustavo", "Tandil");
        Persona jubilado20 = new Jubilado("Claudia", "Puno");
        Persona jubilado21 = new Jubilado("Ricardo", "Oruro");
        Persona jubilado22 = new Jubilado("Beatriz", "San Juan");
        Persona jubilado23 = new Jubilado("Manuel", "Posadas");
        Persona jubilado24 = new Jubilado("Graciela", "San Luis");
        Persona jubilado25 = new Jubilado("Alfredo", "Santa Marta");
        Persona jubilado26 = new Jubilado("Laura", "Talca");
        Persona jubilado27 = new Jubilado("Oscar", "Tarija");
        Persona jubilado28 = new Jubilado("Silvia", "Chiclayo");
        Persona jubilado29 = new Jubilado("Andrés", "Curicó");
        Persona jubilado30 = new Jubilado("Norma", "Zamora");
        Persona jubilado31 = new Jubilado("Miguel", "Encarnación");
        // creacion de vertices
        Vertex<Persona> vert1 = mapa.createVertex(jubilado1);
        Vertex<Persona> vert2 = mapa.createVertex(jubilado2);
        Vertex<Persona> vert3 = mapa.createVertex(jubilado3);
        Vertex<Persona> vert4 = mapa.createVertex(jubilado4);
        Vertex<Persona> vert5 = mapa.createVertex(jubilado5);
        Vertex<Persona> vert6 = mapa.createVertex(jubilado6);
        Vertex<Persona> vert7 = mapa.createVertex(jubilado7);
        Vertex<Persona> vert8 = mapa.createVertex(jubilado8);
        Vertex<Persona> vert9 = mapa.createVertex(jubilado9);
        Vertex<Persona> vert10 = mapa.createVertex(jubilado10);
        Vertex<Persona> vert11 = mapa.createVertex(jubilado11);
        Vertex<Persona> vert12 = mapa.createVertex(jubilado12);
        Vertex<Persona> vert13 = mapa.createVertex(jubilado13);
        Vertex<Persona> vert14 = mapa.createVertex(jubilado14);
        Vertex<Persona> vert15 = mapa.createVertex(jubilado15);
        Vertex<Persona> vert16 = mapa.createVertex(jubilado16);
        Vertex<Persona> vert17 = mapa.createVertex(jubilado17);
        Vertex<Persona> vert18 = mapa.createVertex(jubilado18);
        Vertex<Persona> vert19 = mapa.createVertex(jubilado19);
        Vertex<Persona> vert20 = mapa.createVertex(jubilado20);
        Vertex<Persona> vert21 = mapa.createVertex(jubilado21);
        Vertex<Persona> vert22 = mapa.createVertex(jubilado22);
        Vertex<Persona> vert23 = mapa.createVertex(jubilado23);
        Vertex<Persona> vert24 = mapa.createVertex(jubilado24);
        Vertex<Persona> vert25 = mapa.createVertex(jubilado25);
        Vertex<Persona> vert26 = mapa.createVertex(jubilado26);
        Vertex<Persona> vert27 = mapa.createVertex(jubilado27);
        Vertex<Persona> vert28 = mapa.createVertex(jubilado28);
        Vertex<Persona> vert29 = mapa.createVertex(jubilado29);
        Vertex<Persona> vert30 = mapa.createVertex(jubilado30);
        Vertex<Persona> vert31 = mapa.createVertex(jubilado31);
        Vertex<Persona> verticeEmpleado = mapa.createVertex(empleado);
        //conexiones 
        mapa.connect(vert1, vert15);
        mapa.connect(vert2, vert8);
        mapa.connect(vert3, vert11);
        mapa.connect(vert4, vert22);
        mapa.connect(vert5, vert1);
        mapa.connect(vert6, vert13);
        mapa.connect(vert7, vert25);
        mapa.connect(vert8, vert30);
        mapa.connect(vert9, vert20);
        mapa.connect(vert10, vert6);
        mapa.connect(vert11, vert18);
        mapa.connect(vert12, vert31);
        mapa.connect(vert13, vert17);
        mapa.connect(vert14, vert2);
        mapa.connect(vert15, vert23);
        mapa.connect(vert16, vert7);
        mapa.connect(vert17, vert26);
        mapa.connect(vert18, vert4);
        mapa.connect(vert19, vert29);
        mapa.connect(vert20, vert14);
        mapa.connect(vert21, vert10);
        mapa.connect(vert22, vert12);
        mapa.connect(vert23, vert19);
        mapa.connect(vert24, vert3);
        mapa.connect(vert25, vert5);
        mapa.connect(vert26, vert16);
        mapa.connect(vert27, vert9);
        mapa.connect(vert28, vert24);
        mapa.connect(vert29, vert28);
        mapa.connect(vert30, vert21);
        mapa.connect(vert31, vert27);

        // Conexiones con verticeEmpleado (algunas)
        mapa.connect(vert1, verticeEmpleado);
        mapa.connect(vert7, verticeEmpleado);
        mapa.connect(vert12, verticeEmpleado);
        mapa.connect(vert19, verticeEmpleado);
        mapa.connect(vert23, verticeEmpleado);
        mapa.connect(vert28, verticeEmpleado);
        mapa.connect(verticeEmpleado, vert1);
        mapa.connect(verticeEmpleado, vert12);
        mapa.connect(verticeEmpleado, vert5);
        mapa.connect(verticeEmpleado, vert20);
        mapa.connect(verticeEmpleado, vert30);
        // testeo final
        Parcial3 prueba = new Parcial3();

        List<String> retorno = prueba.resolver(mapa, empleado, 89);
        System.out.println("retorno");
        System.out.println(retorno);
        System.out.println(retorno.size());
     }
}
