import Modelo.DAOGenerico;
import Modelo.DAOUsuario;
import Modelo.Libro;
import Modelo.Usuario;

public class App {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la aplicación de biblioteca :)");
        DAOGenerico<Usuario, Integer> usudao = new DAOGenerico<>(Usuario.class, Integer.class);
        DAOGenerico<Libro, String> librodao = new DAOGenerico<>(Libro.class, String.class);
        //System.out.println(usudao.toString());
        //System.out.println(usudao.getAll());
        //System.out.println(usudao.getById(1));
        System.out.println(librodao.getById("9781111111111").toString());
    }
}
