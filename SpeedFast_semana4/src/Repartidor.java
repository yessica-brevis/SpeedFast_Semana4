package speedfast;

import java.util.List;
import java.util.Random;

// Clase que representa a un repartidor.
// Implementa Runnable para poder ejecutar sus tareas mediante un hilo.
public class Repartidor implements Runnable {

    // Nombre del repartidor.
    private String nombre;

    // Lista de pedidos asignados al repartidor.
    private List<Pedido> pedidos;

    // Constructor de Repartidor.
    public Repartidor(String nombre, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.pedidos = pedidos;
    }

    // Metodo que contiene las tareas que realizará el repartidor.
    @Override
    public void run() {

        // Creamos un generador de números aleatorios.
        Random random = new Random();

        // Recorremos los pedidos asignados al repartidor.
        for (Pedido pedido : pedidos) {

            // Mostramos que el repartidor comenzó la entrega.
            System.out.println(
                    "[Repartidor: " + nombre + "] Entregando "
                            + pedido.getTipoPedido()
                            + " #"
                            + pedido.getIdPedido()
                            + "..."
            );

            try {

                // Generamos un tiempo aleatorio entre 1 y 3 segundos.
                int tiempoEspera = 1000 + random.nextInt(3000);

                // Pausamos el hilo para simular la entrega.
                Thread.sleep(tiempoEspera);

            } catch (InterruptedException e) {

                // Restauramos el estado de interrupción del hilo.
                Thread.currentThread().interrupt();

                // Informamos que la entrega fue interrumpida.
                System.out.println(
                        "[Repartidor: " + nombre + "] Entrega interrumpida."
                );

                // Terminamos la ejecución del repartidor.
                return;
            }

            // Informamos que el pedido fue entregado.
            System.out.println(
                    "[Repartidor: " + nombre + "] Pedido #"
                            + pedido.getIdPedido()
                            + " entregado."
            );
        }
    }
}