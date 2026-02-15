package Repository;
import Modelos.Producto;
import java.util.ArrayList;
import java.util.List;
public class ProductoRepository {
    private List<Producto> productos = new ArrayList<>();
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarPorIsbn(String isbn) {
        for (Producto p : productos) {
            if (p.getIsbn().equalsIgnoreCase(isbn)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> getTodos() {
        return new ArrayList<>(productos);
    }

    public boolean eliminarProducto(String isbn) {
        return productos.removeIf(p -> p.getIsbn().equalsIgnoreCase(isbn));
    }
}
