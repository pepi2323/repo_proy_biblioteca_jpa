package Controlador;

import Modelo.DAOGenerico;
import Modelo.Usuario;

public class GestionUsuarios {
    public DAOGenerico<Usuario,Integer> daousuario;

    public GestionUsuarios(){
        this.daousuario = new DAOGenerico<>(Usuario.class,Integer.class);
    }
    public boolean login(){
        return false;
    }

}
