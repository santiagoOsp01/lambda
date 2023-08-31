package org.example;


import java.util.HashMap;
import java.util.Map;

public class lambda {


    static Map<String,ServicioConParam> servicios = new HashMap<>();

    public static void main( String[] args ) {
        get("/hello", str -> "Hola " + str);
        get("/author", str -> str);
        get("/coseno", str -> {
            return "" + Math.cos(Double.parseDouble(str));
        });
        get("/seno", new ServicioConParam() {
            @Override
            public String ejecutar(String str) {
                return "" + Math.sin(Double.parseDouble(str));
            }
        });
        ServicioConParam s  = buscar("/hello");
        System.out.println("la funcion /hello es: " + s.ejecutar("Santiago"));
        System.out.println(buscar("/author").ejecutar("san"));
        System.out.println(buscar("/coseno").ejecutar("1.6"));
        System.out.println(buscar("/seno").ejecutar("2.3"));
    }

    public static ServicioConParam buscar(String nombre) {
        return servicios.get(nombre);
    }

    public static void get(String str, ServicioConParam service){
        servicios.put(str, service);
    }
}
