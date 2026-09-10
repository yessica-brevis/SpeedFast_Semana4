package speedfast;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        // ============================================================
        // CREACIÓN DE LOS PEDIDOS DE CAMILA
        // ============================================================

        // Creamos un pedido de comida.
        Pedido pedido101 = new PedidoComida(
                "101",
                "Av. Ulriksen 343",
                4
        );

        // Creamos un pedido de encomienda.
        Pedido pedido102 = new PedidoEncomienda(
                "102",
                "Av. Del Solar 3154",
                6
        );

        // Guardamos los pedidos de Camila en una lista.
        List<Pedido> pedidosCamila = Arrays.asList(
                pedido101,
                pedido102
        );


        // ============================================================
        // CREACIÓN DE LOS PEDIDOS DE LUIS
        // ============================================================

        // Creamos un pedido express.
        Pedido pedido103 = new PedidoExpress(
                "103",
                "Av. Apoquindo 3500",
                7
        );

        // Creamos un pedido de comida.
        Pedido pedido104 = new PedidoComida(
                "104",
                "Av. Grecia 850",
                3
        );

        // Guardamos los pedidos de Luis en una lista.
        List<Pedido> pedidosLuis = Arrays.asList(
                pedido103,
                pedido104
        );


        // ============================================================
        // CREACIÓN DE LOS PEDIDOS DE PEDRO
        // ============================================================

        // Creamos un pedido de encomienda.
        Pedido pedido105 = new PedidoEncomienda(
                "105",
                "Av. Cuatro Esquinas 230",
                5
        );

        // Creamos un pedido express.
        Pedido pedido106 = new PedidoExpress(
                "106",
                "Av. Tierras Blancas 4330",
                8
        );

        // Guardamos los pedidos de Pedro en una lista.
        List<Pedido> pedidosPedro = Arrays.asList(
                pedido105,
                pedido106
        );


        // ============================================================
        // CREACIÓN DE LOS REPARTIDORES
        // ============================================================

        // Creamos el repartidor Camila con sus pedidos asignados.
        Repartidor camila = new Repartidor(
                "Camila",
                pedidosCamila
        );

        // Creamos el repartidor Luis con sus pedidos asignados.
        Repartidor luis = new Repartidor(
                "Luis",
                pedidosLuis
        );

        // Creamos el repartidor Pedro con sus pedidos asignados.
        Repartidor pedro = new Repartidor(
                "Pedro",
                pedidosPedro
        );


        // ============================================================
        // CREACIÓN DEL EXECUTOR SERVICE
        // ============================================================

        // Creamos un grupo de 3 hilos.
        // Esto permite ejecutar a los tres repartidores en paralelo.
        ExecutorService executor = Executors.newFixedThreadPool(3);


        // ============================================================
        // INICIO DE LA SIMULACIÓN
        // ============================================================

        System.out.println("==========================================");
        System.out.println("ENTREGAS SPEEDFAST");
        System.out.println("==========================================");

        // Enviamos a Camila al ExecutorService.
        executor.execute(camila);

        // Enviamos a Luis al ExecutorService.
        executor.execute(luis);

        // Enviamos a Pedro al ExecutorService.
        executor.execute(pedro);


        // ============================================================
        // FINALIZACIÓN DEL EXECUTOR
        // ============================================================

        // Indicamos que no se agregarán nuevas tareas.
        executor.shutdown();

        try {

            // Esperamos hasta que todos los repartidores
            // terminen sus entregas.
            executor.awaitTermination(1, TimeUnit.HOURS);

        } catch (InterruptedException e) {

            // Restauramos el estado de interrupción del hilo.
            Thread.currentThread().interrupt();

            // Detenemos las tareas que aún estén ejecutándose.
            executor.shutdownNow();
        }


        // ============================================================
        // MENSAJE FINAL
        // ============================================================

        System.out.println("==========================================");
        System.out.println("   TODAS LAS ENTREGAS HAN FINALIZADO");
        System.out.println("==========================================");
    }
}