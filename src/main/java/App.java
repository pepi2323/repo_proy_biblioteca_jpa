import Modelo.DAOUsuario;
import Modelo.Usuario;

public class App {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la aplicación de biblioteca :)");

        DAOUsuario daou = new DAOUsuario();

        System.out.println(daou.getAllUsuarios());
    }
}
