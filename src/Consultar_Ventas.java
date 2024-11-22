import java.io.*;
import java.util.*;

public class Consultar_Ventas {

    private List<Venta> ventas; // Lista de ventas cargadas
    private String codigo;
    private String nombre;
    private String categoria;
    private int cantidadVendida;
    private double montoTotal;

    // Constructor
    public Consultar_Ventas() {
        ventas = new ArrayList<>(); // Inicializamos la lista de ventas
    }

    // Método para cargar ventas desde el archivo
    private static List<Venta> cargarVentas() {
        List<Venta> ventas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("ventas.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(";");
                String codigo = datos[0];
                String nombre = datos[1];
                String categoria = datos[2];
                int cantidadVendida = Integer.parseInt(datos[3]);
                double montoTotal = Double.parseDouble(datos[4]);

                ventas.add(new Venta(codigo, nombre, categoria, cantidadVendida, montoTotal));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de ventas: " + e.getMessage());
        }

        return ventas;
    }

    // Método para establecer las ventas cargadas desde el archivo
    public void set_Ventas() {
        this.ventas = cargarVentas(); // Sobreescribe la lista de ventas con las del archivo
    }

    // Método para obtener la lista de ventas
    public List<Venta> getVentas() {
        return this.ventas;
    }

    // Método para calcular el total general de todas las ventas
    public double calcularTotalGeneral() {
        double total = 0;
        for (Venta venta : ventas) {
            total += venta.getMontoTotal();
        }
        return total;
    }

    // Métodos Getter y Setter para las propiedades
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
