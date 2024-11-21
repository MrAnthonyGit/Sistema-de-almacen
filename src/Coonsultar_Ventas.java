import java.io.*;
import java.util.*;

public class Coonsultar_Ventas {

    private String codigo;
    private String nombre;
    private String categoria;
    private int cantidadVendida;
    private double montoTotal;
    private double total;

    private String Nombre_Archivo = "Ventas.txt";
    private FileReader fr;
    private BufferedReader br;

    public Coonsultar_Ventas() throws Exception{
        try {
            fr = new FileReader(Nombre_Archivo);
            br = new BufferedReader(fr);

        }catch(FileNotFoundException e) {throw e;}

    }

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

    public void get_Ventas(){                   // verificar funcuncionamiento
        List<Venta> ventas = cargarVentas();
        for (Venta venta : ventas){
            this.codigo = venta.codigo;
            this.nombre = venta.nombre;
            this.categoria = venta.categoria;
            this.cantidadVendida = venta.cantidadVendida;
            this.montoTotal = venta.montoTotal;
        }
    }

}
