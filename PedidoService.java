package Business;
import Modelos.Pedido;
import Modelos.Producto;
import java.util.List;

public class PedidoService {
    private Pedido pedidoActual;
    private static int contador = 1;

     public PedidoService() {
        this.pedidoActual = null; 
    }
    public void iniciarPedido(String idUsuario) {
        this.pedidoActual = new Pedido(generarNuevoId(),idUsuario);
        System.out.println("Nuevo pedido para  el usuario: " + idUsuario);
    }
    public void agregarProductoPedido(Producto producto) {
        if (pedidoActual == null) { 
            System.out.println("No hay un pedido activo. Inicie un pedido primero.");
            return;
        }
        pedidoActual.agregarProducto(producto);
        System.out.println("Producto añadido al pedido.");
    }

    public void mostrarPedido() {
        if (pedidoActual == null) { 
            System.out.println("No hay un pedido activo.");
            return;
        }
        List<Producto> productos = pedidoActual.getProductos();
        if (productos.isEmpty()) {
            System.out.println("El pedido está vacío.");
            return;
        }

        System.out.println("Productos en el pedido:");
        for (Producto p : productos) {
            System.out.println("- " + p.getTitulo() + " | " + p.getPrecio() + "€");
        }

        System.out.println("Total: " + pedidoActual.getTotal() + "€");
    }

    public void realizarCompra() {
        List<Producto> productos = pedidoActual.getProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el pedido.");
            return;
        }

        System.out.println("Compra realizada con éxito. Total: " + pedidoActual.getTotal() + "€");
        pedidoActual = new Pedido(generarNuevoId(), pedidoActual.getIdUsuario());
    }
    private String generarNuevoId(){
        return("El nuevo ID es:"+ contador++);
    }
}