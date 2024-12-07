import Controlador.GestionPrestamo;
import Modelo.*;

public class AppPruebas {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la aplicación de biblioteca :)");
        DAOGenerico<Usuario, Integer> usudao = new DAOGenerico<>(Usuario.class, Integer.class);
        DAOGenerico<Libro, String> librodao = new DAOGenerico<>(Libro.class, String.class);
        DAOGenerico<Ejemplar,Integer> ejempladao = new DAOGenerico<>(Ejemplar.class,Integer.class);
        DAOGenerico<Prestamo,Integer> prestamodao = new DAOGenerico<>(Prestamo.class,Integer.class);
        Usuario usuario =usudao.getById(1);

        System.out.println("Antes: "+ejempladao.getById(7).toString());
        System.out.println(" Antes Préstamos activos: "+usuario.getPrestamos());

        GestionPrestamo gestor = new GestionPrestamo();
        gestor.prestarEjemplar(1,7);

        usuario =usudao.getById(1);
        System.out.println("Después: "+ejempladao.getById(7).toString());

        prestamodao.getAll();
        System.out.println("Total de préstamos: "+usudao.getById(1).getPrestamos());

    }
}
