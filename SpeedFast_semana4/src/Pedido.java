package speedfast;

// Clase abstracta que representa un pedido general de SpeedFast.
public abstract class Pedido {

    // Identificador único del pedido.
    private String idPedido;

    // Dirección donde se debe entregar el pedido.
    private String direccionEntrega;

    // Distancia hasta el lugar de entrega en kilómetros.
    private int distanciaKm;

    // Constructor de la clase Pedido.
    public Pedido(String idPedido, String direccionEntrega, int distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    // Getter para obtener el identificador del pedido.
    public String getIdPedido() {
        return idPedido;
    }

    // Getter para obtener la dirección de entrega.
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    // Getter para obtener la distancia del pedido.
    public int getDistanciaKm() {
        return distanciaKm;
    }

    // Metodo que muestra un resumen general del pedido.
    public void mostrarResumen() {
        System.out.println(
                getTipoPedido()
                        + " #"
                        + idPedido
                        + " - Dirección: "
                        + direccionEntrega
                        + " - Distancia: "
                        + distanciaKm
                        + " km"
        );
    }

    // Metodo abstracto que cada tipo de pedido debe implementar.
    public abstract int calcularTiempoEntrega();

    // Metodo abstracto que permite conocer el tipo de pedido.
    public abstract String getTipoPedido();
}