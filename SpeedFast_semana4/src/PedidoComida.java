package speedfast;

// Clase que representa un pedido de comida.
public class PedidoComida extends Pedido
        implements Despachable, Cancelable, Rastreable {

    // Constructor de PedidoComida.
    public PedidoComida(String idPedido, String direccionEntrega, int distanciaKm) {

        // Llamamos al constructor de la clase padre.
        super(idPedido, direccionEntrega, distanciaKm);
    }

    // Calcula el tiempo de entrega de un pedido de comida.
    @Override
    public int calcularTiempoEntrega() {

        // Tiempo base de 15 minutos más 2 minutos por kilómetro.
        return 15 + (getDistanciaKm() * 2);
    }

    // Devuelve el tipo de pedido.
    @Override
    public String getTipoPedido() {
        return "PedidoComida";
    }

    // Implementación del metodo despachar().
    @Override
    public void despachar() {
        System.out.println("Pedido de comida despachado.");
    }

    // Implementación del metodo cancelar().
    @Override
    public void cancelar() {
        System.out.println("Pedido de comida cancelado.");
    }

    // Implementación del metodo rastrear().
    @Override
    public void rastrear() {
        System.out.println("Rastreando pedido de comida #" + getIdPedido());
    }
}