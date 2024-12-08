package Vista;
import Controlador.GestionPrestamo;
import Controlador.GestionUsuarios;

import java.util.Scanner;

public class ConsolaGestionUNormal {
    Scanner teclado;
    GestionUsuarios gestorUsuarios;
    GestionPrestamo gestorPrestamos;
    int idUsuario;
    int idEjemplar;

    public ConsolaGestionUNormal(){
        teclado = new Scanner(System.in);
        gestorUsuarios = new GestionUsuarios();
        gestorPrestamos = new GestionPrestamo();
    }

   public void inicioSesion() {
       System.out.println("\nPro favor inicie sesión:");
   }
    public int mostrarMenuNormal(){
        System.out.println("\nSeleccione su opción:");
        System.out.println("1. Mostrar todos mis préstamos");
        System.out.println("2. Realizar préstamo");
        System.out.println("2. Realizar devolución");
        System.out.println("-1 - Salir");
        System.out.print("Opción: ");
        int opcion = teclado.nextInt();
        return opcion;
    }

    public int mostrarMenuAdmin() {

        System.out.println("\nSeleccione su opción:");
        System.out.println("1. Gestión todos los préstamos");
        System.out.println("2. Gestión todos los ejemplares");
        System.out.println("3. Gestión todos los libros");
        System.out.println("4. Gestión todos los usuarios");
        System.out.println("5. Realizar préstamo para un determinado usuario y ejemplar");
        System.out.println("6. Devolver préstamo para un determinado usuario y ejemplar");
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
        inicioSesion();
        int opcion = mostrarMenu();
        while(opcion!=-1){
            realizarOpcion(opcion);
            opcion = mostrarMenu();
        }
    }
}