package Repository;
import Modelos.Pedido;
import java.util.ArrayList;
import java.util.List;
public class PedidoRepository {
    private List<Pedido> pedidos = new ArrayList<>();

    public void guardarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> obtenerPedidosPorUsuario(String idUsuario) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getIdUsuario().equals(idUsuario)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<Pedido> obtenerTodos() {
        return new ArrayList<>(pedidos);
    }
}

