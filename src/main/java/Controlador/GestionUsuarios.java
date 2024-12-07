package Controlador;

import Modelo.DAOGenerico;
import Modelo.DAOUsuario;
import Modelo.Usuario;

import java.util.Scanner;

public class GestionUsuarios {
    public DAOUsuario daousuario;
    String dni;
    String password;

    public GestionUsuarios(){
        this.daousuario = new DAOUsuario();
    }

    public boolean login(String dni, String password){
        Usuario usu = daousuario.getUsuarioByDni(dni);
        if(usu.getPassword().equals(password)){
            return true;
        }
        else {
            return false;
        }
    }

    public void pedirDatos(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el DNI: ");
        this.dni = teclado.nextLine();
        System.out.print("Introduce la contraseña: ");
        this.password = teclado.nextLine();
    }

}
