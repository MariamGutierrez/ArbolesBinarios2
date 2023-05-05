/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herbalife;
import java.util.Scanner;

/**
 *
 * @author Catalina Quijano L
 */
public class Herbalife { 
    
    public static void main(String[] args) {
    Nodo raiz = new Nodo("Juan",0);
    Nodo maria = new Nodo("Maria",10000);
    Nodo martha = new Nodo("Martha",5000);
    Nodo brayan = new Nodo("Brayan",4000);
    Nodo dolores = new Nodo("Dolores",30000);
    Nodo mario = new Nodo("Mario",3000);
    Nodo pedro = new Nodo("Pedro",3000);
    Nodo josefa = new Nodo("Josefa",2000);
    Nodo natalia = new Nodo("Natalia",5000);
    Nodo carlos = new Nodo ("Carlos", 30000);
    Nodo marcos = new Nodo ("Marcos", 1000);
    Nodo jose = new Nodo ("Jose", 9000);
    Nodo javier = new Nodo ("Javier", 2000);
    Nodo manuel = new Nodo ("Manuel", 2000);
    Nodo cristian = new Nodo ("Cristian", 2000);
    Nodo fransisco = new Nodo ("Fransisco", 4000);

    
    raiz.izquierdo = maria;
    raiz.derecho = carlos; 
    maria.izquierdo = martha;
    martha.izquierdo = brayan;
    brayan.izquierdo = dolores;
    martha.derecho = mario;
    maria.derecho = pedro;
    pedro.izquierdo = josefa;
    pedro.derecho = natalia;
    carlos.izquierdo = marcos;
    carlos.derecho = jose;
    jose.izquierdo = javier;
    jose.derecho = manuel;
    manuel.izquierdo = cristian;
    manuel.derecho = fransisco;
        
    
    Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("---------- MENU ----------");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Descuento");
            System.out.println("3. liquidación");
            System.out.println("4. Agregar una compra");
            System.out.println("5. Mostrar raiz");
            System.out.println("0. Salir");
            System.out.println("---------------------------");

            System.out.print("Ingrese la opcion deseada: ");
            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    agregarNodo(raiz);
                    break;
                case 2:
                    descuento(raiz);
                case 3:
                    liquidacion(raiz);
                    maria.valor =0;
                    martha.valor =0;
                    brayan.valor =0;
                    dolores.valor =0;
                    mario.valor =0;
                    pedro.valor =0;
                    josefa.valor =0;
                    natalia.valor =0;
                    carlos.valor =0;
                    marcos.valor =0;
                    jose.valor =0;
                    javier.valor =0;
                    manuel.valor =0;
                    cristian.valor =0;
                    fransisco.valor =0;
                    break;
                case 4:
                    agregarCompra(raiz);
                    break;
                case 5:
                    //agregarCompra();
                   show(raiz,"");
                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
                    break;
            }
            System.out.println();
        } while (opcion != 0);

        sc.close();
    }





public static Nodo buscarNodo(Nodo nodo, String nombre) {
        if (nodo == null) {
            return null;
        }

        if (nodo.nombre.equals(nombre)) {
            return nodo;
        }

        Nodo resultadoIzq = buscarNodo(nodo.izquierdo, nombre);
        if (resultadoIzq != null) {
            return resultadoIzq;
        }

        Nodo resultadoDer = buscarNodo(nodo.derecho, nombre);
        if (resultadoDer != null) {
            return resultadoDer;
        }

        return null;
   }
//    public static void consultarCliente() {
//        Nodo raiz = new Nodo("Juan",0);
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Ingrese el nombre del cliente: ");
//        String nombreCliente = sc.nextLine();
//
//        Nodo nodoCliente = buscarNodo(raiz, nombreCliente);
//        if (nodoCliente == null) {
//            System.out.println("No se encontro al cliente. Intente de nuevo.");
//        } else {
//            System.out.println("El valor del cliente " + nombreCliente + " es: " + nodoCliente.valor);
//        }
//    }
//
    public static void agregarCompra(Nodo raiz) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = sc.nextLine();

        Nodo nodoCliente = buscarNodo(raiz, nombreCliente);
        if (nodoCliente == null) {
            System.out.println("No se encontro al cliente. Intente de nuevo.");
        } else {
            System.out.print("Ingrese el monto de la compra: ");
            int montoCompra = sc.nextInt();
            nodoCliente.valor += montoCompra;
            System.out.println("La compra se ha agregado con exito\n");
            System.out.println("Ahora la comisón de " + nodoCliente.nombre + " es " + nodoCliente.valor);
        }

        sc.nextLine();
}
    public static void show(Nodo nodo, String prefijo) {
        if (nodo == null) {
            return;
        }

        System.out.println(prefijo + ">> " + nodo.nombre + " (" + nodo.valor + ")");

        show(nodo.izquierdo, prefijo + "    ");
        show(nodo.derecho, prefijo + "    ");
    }

    private static void agregarNodo(Nodo raiz) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del nodo al que se va a vincular:");
        String nombreNodo = scanner.next();

        // Buscar el nodo al que se va a vincular
        Nodo nodoPadre = buscarNodo(raiz, nombreNodo);
        if (nodoPadre == null) {
            System.out.println("El nodo al que se desea vincular no existe.");
            return;
        }

        // Verificar si el nodo está completo
        if (nodoPadre.izquierdo != null && nodoPadre.derecho != null) {
            System.out.print("El nodo al que se desea vincular ya esta completo.");
            return;
        }

        // Solicitar datos del nuevo nodo
        System.out.print("Ingrese el nombre de la persona:");
        String nombre = scanner.next();
        System.out.print("Ingrese el valor de la persona:");
        int valor = scanner.nextInt();

        // Crear el nuevo nodo y agregarlo al árbol
        Nodo nuevoNodo = new Nodo(nombre, valor);
        if (nodoPadre.izquierdo == null) {
            nodoPadre.izquierdo = nuevoNodo;
        } else {
            nodoPadre.derecho = nuevoNodo;
        }
        System.out.println("Nodo agregado correctamente.");
}

        public static void descuento(Nodo raiz) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la persona que desea aplicar descuento:");
        String nombreNodo = scanner.next();

        // Buscar el nodo al que se va a vincular
        Nodo nodoPadre = buscarNodo(raiz, nombreNodo);
        if (nodoPadre == null) {
            System.out.println("El nodo al que se desea vincular no existe.");
            return;
        }
        if (nodoPadre.izquierdo != null && nodoPadre.derecho != null) {
            double totalVentas = calcularTotalVentas(nodoPadre);
        double descuento =totalVentas*0.001;
        double resultado = nodoPadre.valor - descuento;
        nodoPadre.valor = resultado;
        System.out.println("Las comisiones con el descuento aplicado para "+ nodoPadre.getNombre()+ " son: "+resultado);
            return;
        }else{
            System.out.println("Esta persona aun no puede recibir descuento");
        }
        
    }

    private static double calcularTotalVentas(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        double total = nodo.valor;

        total += calcularTotalVentas(nodo.izquierdo);
        total += calcularTotalVentas(nodo.derecho);

        return total;
    }
    
    public static void liquidacion(Nodo nodo) {
    if (nodo == null) {
        return;
    }
    
    double sum = nodo.valor;
    if (nodo.izquierdo != null) {
        sum += nodo.izquierdo.valor;
    }
    if (nodo.derecho != null) {
        sum += nodo.derecho.valor;
    }
    
    nodo.setValor(sum);
    
    liquidacion(nodo.izquierdo);
    liquidacion(nodo.derecho);
    
}


}

