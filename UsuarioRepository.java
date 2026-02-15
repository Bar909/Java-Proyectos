package Repository;
import Modelos.Usuario;
import java.util.ArrayList;
import java.util.List;
public class UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario u: usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }
    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios); 
    }
}
