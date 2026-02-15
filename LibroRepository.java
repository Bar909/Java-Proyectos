package Repository;
import java.util.ArrayList;
import java.util.List;
import Modelos.Libro;

public class LibroRepository {
    private List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro){
        libros.add(libro);
    }
    public void eliminarLibro(String isbn){
        libros.removeIf(libro -> libro.getIsbn().equals(isbn));

    }
    public void editarLibro(Libro libroEditado){
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(libroEditado.getIsbn())) {
                libros.set(i, libroEditado);
                return;
            }
        }
    }
    public List<Libro> buscarLibros(int tipo, String termino){
        List<Libro> encontrado = new ArrayList<>();
        for (Libro libro: libros){
            switch (tipo){
                case 1:
                    if(libro.getTitulo().equalsIgnoreCase(termino)){
                        encontrado.add(libro);
                    }
                    break;
                case 2:
                    if(libro.getAutor().equalsIgnoreCase(termino)){
                        encontrado.add(libro);
                    }
                    break;
                case 3:
                    if(libro.getIsbn().equalsIgnoreCase(termino)){
                        encontrado.add(libro);
                   }
                break;
            default:
                   break;
            }
        }
        return encontrado;
    }
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    public boolean prestarLibro(String isbn) {
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro != null && libro.isDisponible()) {
            libro.setDisponible(false);
            return true;
        }
        return false;
    }
    
    public boolean devolverLibro(String isbn) {
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro != null && !libro.isDisponible()) {
            libro.setDisponible(true);
            return true;
        }
        return false;
    }
    public List<Libro> getTodos(){
        return new ArrayList<>(libros);
    }
}
