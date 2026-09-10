package speedfast;

// Clase que representa un pedido express.
public class PedidoExpress extends Pedido
        implements Despachable, Cancelable, Rastreable {

    // Constructor de PedidoExpress.
    public PedidoExpress(String idPedido, String direccionEntrega, int distanciaKm) {

        // Llamamos al constructor de la clase padre.
        super(idPedido, direccionEntrega, distanciaKm);
    }

    // Calcula el tiempo de entrega de un pedido express.
    @Override
    public int calcularTiempoEntrega() {

        // El pedido express tiene un tiempo fijo de 15 minutos.
        return 15;
    }

    // Devuelve el tipo de pedido.
    @Override
    public String getTipoPedido() {
        return "PedidoExpress";
    }

    // Implementación del metodo despachar().
    @Override
    public void despachar() {
        System.out.println("Pedido express despachado.");
    }

    // Implementación del metodo cancelar().
    @Override
    public void cancelar() {
        System.out.println("Pedido express cancelado.");
    }

    // Implementación del metodo rastrear().
    @Override
    public void rastrear() {
        System.out.println("Rastreando pedido express #" + getIdPedido());
    }
}