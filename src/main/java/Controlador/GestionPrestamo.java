package Controlador;

import Modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionPrestamo {

    public DAOGenerico<Ejemplar,Integer> daoejemplares;
    public DAOGenerico<Usuario,Integer> daousuario;
    public DAOGenerico<Prestamo,Integer> daoprestamo;
    public DAOGenerico<Libro,String> daoLibro;

    public static void main(String[] args) {
        GestionPrestamo gp = new GestionPrestamo();
        System.out.println(gp.daousuario.getById(1));
    }

    public GestionPrestamo(){
        daoejemplares = new DAOGenerico<>(Ejemplar.class,Integer.class);
        daousuario = new DAOGenerico<>(Usuario.class,Integer.class);
        daoprestamo = new DAOGenerico<>(Prestamo.class,Integer.class);
        daoLibro = new DAOGenerico<>(Libro.class,String.class);
    }

    public boolean prestarEjemplar(int  idUsuario, int idEjemplar){
        Usuario usuario = daousuario.getById(idUsuario);
        Ejemplar ejemplar = daoejemplares.getById(idEjemplar);
        //comprobamos que no esté penalizado,
        // que no tenga más de 3 préstamos en activo
        // y que el libro esté disponible
        if(usuario.getPenalizacionHasta()==null
                && usuario.getPrestamosActivos() < 3
                && ejemplar.getEstado().equals("Disponible")
        ){
            ejemplar.setEstado("Prestado");
            daoejemplares.update(ejemplar);
            Prestamo prestamo = new Prestamo(usuario,ejemplar,LocalDate.now());
            daoprestamo.add(prestamo);
            return true;
        }
        else if(usuario.getPrestamosActivos()==3){
            System.out.println("El usuario ya tiene 3 libros prestados, es el máximo permitido");
        }
        else if(!ejemplar.getEstado().equals("Disponible")){
            System.out.println("Ejemplar no disponible o dañado");
        }
        return false;
    }

    public List<Prestamo> obtenerPrestamosUsuario(int idUsuario){
        return daousuario.getById(idUsuario).getPrestamos();

    }

    public boolean devolverEjemplar(int idPrestamo){
        Prestamo prestamo = daoprestamo.getById(idPrestamo);
        Usuario usuario = prestamo.getUsuario();
        Ejemplar ejemplar = prestamo.getEjemplar();
        LocalDate fecha_actual = LocalDate.now();
        if(prestamo.getFechaDevolucion().isAfter(fecha_actual)){
            LocalDate fecha_penalizacion_actual = usuario.getPenalizacionHasta();
            //en caso de que ya esté penalizado
            if(fecha_penalizacion_actual!=null){
                usuario.setPenalizacionHasta(fecha_penalizacion_actual.plusDays(15));
            }
            //en caso de que no estuviera antes penalizado
            else {
                usuario.setPenalizacionHasta(LocalDate.now().plusDays(15));
            }
            ejemplar.setEstado("Disponible");
            daoejemplares.update(ejemplar);
            return true;
        }
        else {
            ejemplar.setEstado("Disponible");
            daoejemplares.update(ejemplar);
            return false;
        }
    }


}
