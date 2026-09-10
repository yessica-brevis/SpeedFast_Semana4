package speedfast;

// Clase que representa un pedido de encomienda.
public class PedidoEncomienda extends Pedido
        implements Despachable, Cancelable, Rastreable {

    // Constructor de PedidoEncomienda.
    public PedidoEncomienda(String idPedido, String direccionEntrega, int distanciaKm) {

        // Llamamos al constructor de la clase padre.
        super(idPedido, direccionEntrega, distanciaKm);
    }

    // Calcula el tiempo de entrega de una encomienda.
    @Override
    public int calcularTiempoEntrega() {

        // Tiempo base de 17 minutos más 2 minutos por kilómetro.
        return 17 + (getDistanciaKm() * 2);
    }

    // Devuelve el tipo de pedido.
    @Override
    public String getTipoPedido() {
        return "PedidoEncomienda";
    }

    // Implementación del metodo despachar().
    @Override
    public void despachar() {
        System.out.println("Encomienda despachada.");
    }

    // Implementación del metodo cancelar().
    @Override
    public void cancelar() {
        System.out.println("Encomienda cancelada.");
    }

    // Implementación del metodo rastrear().
    @Override
    public void rastrear() {
        System.out.println("Rastreando encomienda #" + getIdPedido());
    }
}