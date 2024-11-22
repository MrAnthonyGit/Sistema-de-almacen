import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gestor_Pedidos {

    private Pedidos[] pedidos;
    private int totalPedidos;

    // Constructor
    public Gestor_Pedidos(int capacidad) {
        pedidos = new Pedidos[capacidad];
        totalPedidos = 0;
    }

    // Método para cargar los pedidos desde el archivo Pedidos.txt
    public void cargar_Pedidos_Desde_Archivo(String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Suponiendo que los datos están separados por ";"
                String[] datos = linea.split(";");

                // Verificar que haya suficientes datos
                if (datos.length == 5) {
                    String codigo = datos[0];
                    String nombreArticulo = datos[1];
                    int cantidad = Integer.parseInt(datos[2]);
                    String fechaPedido = datos[3];
                    double totalPagar = Double.parseDouble(datos[4]);

                    // Crear un nuevo objeto Pedido y agregarlo al arreglo
                    if (totalPedidos < pedidos.length) {
                        pedidos[totalPedidos] = new Pedidos(codigo, nombreArticulo, cantidad, fechaPedido, totalPagar);
                        totalPedidos++;
                    }
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public Pedidos buscarPorCodigo(String codigo) {
        for (int i = 0; i < totalPedidos; i++) {
            if (pedidos[i].getCodigo().equals(codigo)) {
                return pedidos[i];  // Retorna el pedido si encuentra el código
            }
        }
        return null;  // Si no se encuentra el pedido, retorna null
    }

    // Método para obtener todos los pedidos
    public Pedidos[] get_Pedidos() {
        return pedidos;
    }

    // Método para obtener el total de pedidos cargados
    public int get_Total_Pedidos() {
        return totalPedidos;
    }
}
