package Vista;
import Controlador.GestionUsuarios;
import Modelo.Usuario;

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

   public Usuario mostrarMenu() {
        System.out.println("Introduzca el DNI del usuario: ");
        dni = teclado.next();
        System.out.println("Introduzca la password del usuario: ");
        password = teclado.next();
        return gestorUsuarios.login(dni,password);
    }

   public Usuario ejecutar() {
        Usuario usuarioResultadoLogin = mostrarMenu();
        while(!usuarioResultadoLogin.getTipo().equals("administrador") && !usuarioResultadoLogin.getTipo().equals("normal")){
            usuarioResultadoLogin = mostrarMenu();
        }
        return usuarioResultadoLogin;
    }
}