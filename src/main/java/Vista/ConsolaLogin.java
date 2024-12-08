package Vista;
import Controlador.GestionUsuarios;

import java.util.Scanner;

public class ConsolaLogin {
    Scanner teclado;
    GestionUsuarios gestorUsuarios;
    String dni;
    String password;

    public ConsolaLogin(){
        teclado = new Scanner(System.in);
        gestorUsuarios = new GestionUsuarios();
    }

   public String mostrarMenu() {
        System.out.println("Introduzca el DNI del usuario: ");
        dni = teclado.next();
        System.out.println("Introduzca la password del usuario: ");
        password = teclado.next();
        return gestorUsuarios.login(dni,password);
    }

   public String ejecutar() {
        String resultadoLogin = mostrarMenu();
        while(!resultadoLogin.equals("administrador") && !resultadoLogin.equals("normal")){
            resultadoLogin = mostrarMenu();
        }
        return resultadoLogin;
    }
}