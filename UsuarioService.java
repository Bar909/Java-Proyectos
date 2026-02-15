package Business;
import Modelos.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public void registrarUsuario(String nombre, String id){
        for(Usuario usuario : usuarios){
            if (usuario.getId().equals(id)){
                System.out.println("Ya existe un usuario con es ID.");
                return;
            }
        }
        usuarios.add(new Usuario(nombre,id));
        System.out.println("Usuario registrado.");
    }
    public Usuario buscarUsuario(String id){
        for (Usuario usuario: usuarios){
            if(usuario.getId().equals(id)){
                return usuario;
            }
        }
        return null;
    }
    public void mostrarUsuarios(){
        if(usuarios.isEmpty()){
            System.out.println("No hay usuarios registrados.");
        } else{
            for(Usuario usuario: usuarios){
                System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getNombre());
            }
        }

    }

}
