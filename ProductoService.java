package Business;
import Modelos.Producto;
import Repository.ProductoRepository;
import java.util.List;

public class ProductoService {
    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto buscarProductoPorIsbn(String isbn) {
        return productoRepository.buscarPorIsbn(isbn);
    }

    public List<Producto> listarProductos() {
    return productoRepository.getTodos();
    }


    public void agregarProducto(String isbn, String titulo, String autor, double precio) {
        productoRepository.agregarProducto(new Producto(isbn, titulo, autor, precio));
        System.out.println("Producto añadido correctamente.");
    }
}
