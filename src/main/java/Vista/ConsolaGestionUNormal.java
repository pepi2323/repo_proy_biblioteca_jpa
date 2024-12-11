package Vista;
import Controlador.GestionPrestamo;
import Controlador.GestionUsuarios;
import Modelo.Prestamo;
import Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolaGestionUNormal {
    Scanner teclado;
    GestionPrestamo gestorPrestamos;
    int idUsuario;
    int idEjemplar;
    int idPrestamo;
    Usuario usuario;
    public ConsolaGestionUNormal(Usuario usuario){
        teclado = new Scanner(System.in);
        gestorPrestamos = new GestionPrestamo();
        this.usuario=usuario;
    }

    public int mostrarMenu(){
        System.out.println("\nSeleccione su opción:");
        System.out.println("1. Mostrar todos mis préstamos");
        System.out.println("2. Realizar préstamo");
        System.out.println("3. Realizar devolución");
        System.out.println("-1 - Salir");
        System.out.print("Opción: ");
        int opcion = teclado.nextInt();
        return opcion;
    }

    public int realizarOpcion(int opcion) {
        switch (opcion) {
            case 1:{
                List<Prestamo> lista = gestorPrestamos.obtenerPrestamosUsuario(usuario.getId());
                if(lista!=null){
                    System.out.println(lista);
                }
                else{
                    System.out.println("No hay libros actualmente prestados");
                }
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
            case -1:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
        return opcion;
    }

    public void pedirDatosPrestamo() {
        System.out.print("Introduce el ID del usuario: ");
        this.idUsuario = teclado.nextInt();
        System.out.print("Introduce el ID del ejemplar: ");
        this.idEjemplar = teclado.nextInt();
    }

    public void pedirDatosDevolucionPrestamo() {
        System.out.print("Introduce el ID del prestamo: ");
        this.idPrestamo = teclado.nextInt();
    }

    public void ejecutar() {
        int opcion = mostrarMenu();
        while(opcion!=-1){
            realizarOpcion(opcion);
            opcion = mostrarMenu();
        }
    }
}