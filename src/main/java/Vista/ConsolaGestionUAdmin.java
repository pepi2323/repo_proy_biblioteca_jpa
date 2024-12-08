package Vista;
import Controlador.GestionPrestamo;
import Controlador.GestionUsuarios;

import java.util.Scanner;

public class ConsolaGestionUAdmin {
    Scanner teclado;
    GestionUsuarios gestorUsuarios;
    GestionPrestamo gestorPrestamos;
    int idUsuario;
    int idEjemplar;
    int idPrestamo;

    public ConsolaGestionUAdmin(){
        teclado = new Scanner(System.in);
        gestorUsuarios = new GestionUsuarios();
        gestorPrestamos = new GestionPrestamo();
    }

    public int mostrarMenu(){
        System.out.println("\nSeleccione su opción:");
        System.out.println("1. Mostrar todos los préstamos");
        System.out.println("2. Realizar préstamo para un determinado usuario y ejemplar");
        System.out.println("3. Devolver préstamo para un determinado usuario y ejemplar");
        //para implementación futura
        System.out.println("4. CRUD Libros");
        System.out.println("5. CRUD Ejemplares");
        System.out.println("6. CRUD Usuarios");
        System.out.println("7. CRUD Préstamos");
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
                pedirDatosPrestamo();
                gestorPrestamos.prestarEjemplar(this.idUsuario,this.idEjemplar);
                break;
            }
            case 3:{
                pedirDatosDevolucionPrestamo();
                gestorPrestamos.devolverEjemplar(this.idPrestamo);
                break;
            }
            //resto de casos a implementar con sub-menús de la misma estructura
            case -1:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
        return opcion;
    }

    public void pedirDatosDevolucionPrestamo() {
        System.out.print("Introduce el ID del prestamo: ");
        this.idPrestamo = teclado.nextInt();
    }

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