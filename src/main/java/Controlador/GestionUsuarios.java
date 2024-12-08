package Controlador;

import Modelo.DAOGenerico;
import Modelo.DAOUsuario;
import Modelo.Usuario;

import java.util.Scanner;

public class GestionUsuarios {
    public DAOUsuario daousuario;

    public GestionUsuarios(){
        this.daousuario = new DAOUsuario();
    }

    public String login(String dni, String password){
        Usuario usuario = daousuario.getUsuarioByDni(dni);
        if(usuario.getPassword().equals(password)){
            return usuario.getTipo();
        }
        else {
            return null;
        }
    }

}
