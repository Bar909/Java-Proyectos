package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String idUsuario;
    private String idPedido;
    private List<Producto> productos;
    private double total;

    public Pedido(String idUsuario, String idPedido) {
        this.idUsuario = idUsuario;
        this.idPedido = idPedido;
        this.productos = new ArrayList<>();
        this.total = 0;
    }
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        total += producto.getPrecio();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getIdUsuario() {
        return idUsuario;
    }
}