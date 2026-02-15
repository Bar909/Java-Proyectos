package Business;
import Modelos.Libro;
import java.util.ArrayList;
import java.util.List;

public class LibroService {
    private List<Libro> libros = new ArrayList<>();
    private UsuarioService usuarioService;

    public LibroService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    public void agregarLibro(String titulo,String autor,String isbn){
        libros.add(new Libro(titulo,autor,isbn));
        System.out.println("Libro añadido.");
    }
    public void editarLibro(String isbn, String nuevoTitulo, String nuevoAutor){
        for(Libro libro :libros){
            if (libro.getIsbn().equals(isbn)){
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                System.out.println("Libro editado.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }
    public void eliminarLibro(String isbn){
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)) {
                libros.remove(i);
                System.out.println("Libro eliminado.");
                return;
            }
        }
        System.out.println("Libro no encontrado");
    }
    public void buscarLibros(int tipo, String termino){
        List<Libro> encontrado = new ArrayList<>();
        if(encontrado.isEmpty()){
            System.out.println("Libro no encontrado.");
        }else {
            for (Libro l : encontrado) {
                System.out.println("Título: " + l.getTitulo() + ", Autor: " + l.getAutor() + ", ISBN: " + l.getIsbn());
            }
        }
    }
    
    public void prestarLibro(String idUsuario,String isbn){
        if(usuarioService.buscarUsuario(idUsuario) == null){
            System.out.println("Usuario no encontrado.");
            return;
        } 
        for (Libro libro :libros){
            if(libro.getIsbn().equals(isbn)){
                if (libro.isDisponible()) {  
                    libro.setDisponible(false); 
                    System.out.println("Libro prestado a usuario: " + idUsuario);
                } else {
                    System.out.println("El libro ya está prestado.");
                }
                return;
            }
        }
        System.out.println("Libro no encontrado");
    }
    public void devolverLibro(String isbn){
        for(Libro libro: libros){
            if(libro.getIsbn().equals(isbn)){
                libro.setDisponible(true);
                System.out.println("Libro devuelto.");
                return;
            }
        }
        System.out.println("Libro no encontrado");
    }
}


