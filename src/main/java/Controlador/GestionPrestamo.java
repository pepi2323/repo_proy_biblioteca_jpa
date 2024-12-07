package Controlador;

import Modelo.DAOGenerico;
import Modelo.Ejemplar;
import Modelo.Prestamo;
import Modelo.Usuario;

import java.time.LocalDate;

public class GestionPrestamo {

    public DAOGenerico<Ejemplar,Integer> daoejemplares = new DAOGenerico<>(Ejemplar.class,Integer.class);
    public DAOGenerico<Usuario,Integer> daousuario = new DAOGenerico<>(Usuario.class,Integer.class);
    public DAOGenerico<Prestamo,Integer> daoprestamo = new DAOGenerico<>(Prestamo.class,Integer.class);

    public boolean prestarEjemplar(int  idUsuario, int idEjemplar){
        Usuario usuario = daousuario.getById(idUsuario);
        Ejemplar ejemplar = daoejemplares.getById(idEjemplar);
        //comprobamos que no esté penalizado,
        // que no tenga más de 3 préstamos en activo
        // y que el libro esté disponible
        if(usuario.getPenalizacionHasta()==null
                && usuario.getPrestamosActivos() < 100
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

    public boolean devolverEjemplar(Prestamo prestamo){
        Usuario usuario = prestamo.getUsuario();
        Ejemplar ejemplar = prestamo.getEjemplar();
        LocalDate fecha_actual = LocalDate.now();
        if(prestamo.getFechaDevolucion().isAfter(fecha_actual)){
            LocalDate fecha_penalizacion_actual = usuario.getPenalizacionHasta();
            usuario.setPenalizacionHasta(fecha_penalizacion_actual.plusDays(15));
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
