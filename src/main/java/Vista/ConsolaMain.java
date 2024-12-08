package Vista;

import java.util.Scanner;

public class ConsolaMain {
    //teclado
    Scanner teclado;

    //Consolas
    ConsolaLogin consola_login = new ConsolaLogin();
    ConsolaGestionUNormal consola_u_normal = new ConsolaGestionUNormal();
    ConsolaGestionUAdmin consola_u_admin = new ConsolaGestionUAdmin();
    //opción general de selección

    int opcion=0;

    public ConsolaMain(){
        teclado = new Scanner(System.in);
    }

    public int mostrarMenu(){
        System.out.println("\nSeleccione su opción:");
        System.out.println("1. Iniciar sesión");
        System.out.println("-1. Salir de la aplicación");
        System.out.print("Opción: ");
        int opcion = teclado.nextInt();
        return opcion;
    }

    public int realizarOpcion(int opcion) {
        switch (opcion) {
            case 1:{
                opcion = consola_login.ejecutar();
                break;
            }
            //usuario admin
            case 2: {
                consola_u_admin.ejecutar();
                break;
            }
            //usuario normal
            case 3: {
                consola_u_normal.ejecutar();
                break;
            }
            case -1: {
                System.out.println("Saliendo del programa...");
                break;
            }
            default: {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        return opcion;
    }

    public void ejecutar() {
        int opcion = mostrarMenu();
        while(opcion!=-1){
            realizarOpcion(opcion);
            opcion = mostrarMenu();
        }
    }
}