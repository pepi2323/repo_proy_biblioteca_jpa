package Vista;
import Controlador.GestionPrestamo;

import java.sql.SQLException;
import java.util.Scanner;

public class Consola {
    Scanner teclado;
    GestionPrestamo gestorPrestamos;
    int idUsuario;
    int idEjemplar;

    public Consola(){
        teclado = new Scanner(System.in);
        gestorPrestamos = new GestionPrestamo();
    }
    public int mostrarMenu() {
        System.out.println("\nSeleccione su opción:");
        System.out.println("1. Mostrar todos los préstamos");
        System.out.println("2. Mostrar todos los ejemplares");
        System.out.println("3. Realizar préstamo");
       System.out.println("4 - Devolver préstamo");
//        System.out.println("5 - Eliminar por nombre");
//        System.out.println("6 - Eliminar todos");
//        System.out.println("7 - Restaurar todos");
//        System.out.println("8 - Mostrar todos los juguetes ordenados por nombre ascendente");
//        System.out.println("9 - Mostrar todos los juguetes ordenados por nombre descendente");
//        System.out.println("10 - Mostrar todos los juguetes ordenados por id ascendente");
//        System.out.println("11 - Mostrar todos los juguetes ordenados por id descendente");
        System.out.println("-1 - Salir");
        System.out.print("Opción: ");
        int opcion = teclado.nextInt();
        return opcion;
    }

    public int realizarOpcion(int opcion) {
        switch (opcion) {
            case 1:{
                System.out.println(gestorPrestamos.daoprestamo.getAll());
                break;
            }
            case 2:
            {
                System.out.println(gestorPrestamos.daoejemplares.getAll());
                break;
            }
            case 3:{
                pedirDatosPrestamo();
                gestorPrestamos.prestarEjemplar(this.idUsuario,this.idEjemplar);
                break;
            }
            case 4:{

                break;
            }
            case -1:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
        return opcion;
    }
//    public Juguete recogerDatosJuguete() {
//        System.out.print("Introduzca el ID del juguete: ");
//        int id = teclado.nextInt();
//        teclado.nextLine(); // limpiar buffer
//        System.out.print("Introduzca el nombre del juguete: ");
//        String nombre = teclado.next();
//        System.out.println("Datos del juguete: ID=" + id + ", Nombre=" + nombre);
//        return new Juguete(id, nombre);
//    }

    public void pedirDatosPrestamo() {
        System.out.print("Introduce el ID del usuario: ");
        this.idUsuario = teclado.nextInt();
        System.out.print("Introduce el ID del ejemplar: ");
        this.idEjemplar = teclado.nextInt();
    }

    public void ejecutar() {
        int opcion = mostrarMenu();
        while(opcion!=-1){
            realizarOpcion(opcion);
            opcion = mostrarMenu();
        }
    }
}