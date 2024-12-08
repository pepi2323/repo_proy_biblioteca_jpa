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
    String tipo_usuario="";

    public ConsolaMain(){
        teclado = new Scanner(System.in);
    }

    public void mostrarMenu(){
        System.out.println("\nSeleccione su opción:");
        System.out.println("1. Iniciar sesión en la aplicación");
        System.out.println("-1. Salir de la aplicación");
        System.out.print("Opción: ");
        opcion = teclado.nextInt();
    }

    public void realizarOpcion(int opcion) {
        switch (opcion) {
            case 1:{
                tipo_usuario=consola_login.ejecutar();
                if(tipo_usuario.equals("normal"))
                {
                    consola_u_normal.ejecutar();
                }
                if(tipo_usuario.equals("administrador")){
                    consola_u_admin.ejecutar();
                }
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
    }

    public void ejecutar() {
        mostrarMenu();
        realizarOpcion(opcion);
    }
}